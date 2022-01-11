package com.timesheetstaff;

import org.apache.commons.io.IOUtils;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.security.RolesAllowed;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("api/v1/timesheetstaff")
public class TimesheetStaffRestController {
    @Autowired
    TimesheetStaffService timesheetStaffService;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("jobimport")
    Job job;

    @Autowired
    @Qualifier("jobexport")
    Job jobexport;

    @GetMapping
    @RolesAllowed("admin")
    public List<TimesheetStaff> getAll(){
        return timesheetStaffService.getAll();
    }

    @GetMapping("/list/{staffid}")
    @RolesAllowed("admin")
    public List<TimesheetStaff> getDetailTimesheetByStaffId(@PathVariable String staffid){return timesheetStaffService.getByStaffId(staffid);}

    @GetMapping("/detail/{staffid}/{date}")
    @RolesAllowed("admin")
    public TimesheetStaff getDetailTimesheetByStaffIdAndDate(@PathVariable String staffid, @PathVariable String date){
        return timesheetStaffService.getDetailByStaffIdAndDate(staffid,date);
    }

    @GetMapping("/list/{staffid}/{date}")
    @RolesAllowed("admin")
    public List<TimesheetStaff> getListTimesheetByStaffIdAndDate2(@PathVariable String staffid, @PathVariable String date){
        String year = date.substring(0,4);
        String month = date.substring(5,7);
        return  timesheetStaffService.getAllByStaffIdAndDate(staffid,year,month);
    }

    @PutMapping()
    @RolesAllowed("admin")
    public TimesheetStaff update(@RequestBody TimesheetStaff timesheetStaff) {
        TimesheetStaff t1 = timesheetStaffService.getDetailByStaffIdAndDate(timesheetStaff.getStaffid(),timesheetStaff.getDate());
        if(t1 != null){
            return timesheetStaffService.update(timesheetStaff);
        }else{
            return null;
        }
    }

    @DeleteMapping("/{staffid}")
    @RolesAllowed("admin")
    public String delete(@PathVariable String staffid){
         timesheetStaffService.delete(staffid);
         return "Đã xóa timesheet của: "+staffid;
    }

    @DeleteMapping("/{staffid}/{date}")
    @RolesAllowed("admin")
    public String deleteState(@PathVariable String staffid,@PathVariable String date){
        timesheetStaffService.delete(staffid, date);
        return "Đã xóa thông tin: "+staffid+" tại date: "+date;
    }

    @PostMapping("/import")
    @RolesAllowed("admin")
    public String handle(@RequestParam("file") MultipartFile filepath) throws IOException, JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        String result = "";
        if(filepath.getContentType().equals("application/vnd.ms-excel") || filepath.getContentType().equals("text/csv")){
            File fileToImport = new File(filepath.getOriginalFilename());
            OutputStream outputStream = new FileOutputStream(fileToImport);
            IOUtils.copy(filepath.getInputStream(), outputStream);
            outputStream.flush();
            JobExecution jobExecution = jobLauncher.run(job, new JobParametersBuilder()
                    .addString("fullPathFileName", fileToImport.getAbsolutePath())
                    .addString("number",UUID.randomUUID().toString(), true)
                    .toJobParameters());
            outputStream.close();
            Files.delete(Path.of(fileToImport.getAbsolutePath()));
            result = jobExecution.getStatus().toString();
        }else{
            result = "Không hỗ trợ loại file này, vui lòng nhập file đúng định dạng";
        }
        return  result;
    }

    @GetMapping("/export")
    @RolesAllowed("admin")
    public String handle2(@RequestParam("namefile") String namefile) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        long v = ThreadLocalRandom.current().nextLong(1000);
        JobExecution jobExecution = jobLauncher.run(jobexport, new JobParametersBuilder()
                .addString("namefile", namefile+"_"+v, true)
                .toJobParameters());
        return jobExecution.getStatus().toString();
    }

}
