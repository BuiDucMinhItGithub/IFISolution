package com.timesheetstaff;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@EnableBatchProcessing
@Configuration
public class TimesheetStaffService {
    @Autowired
    TimesheetStaffRepository timesheetStaffRepository;
    @Autowired
    JobLauncher jobLauncher;
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    public List<TimesheetStaff> getAll(){return timesheetStaffRepository.findAll();}

    public List<TimesheetStaff> getByStaffId(String id){
        return timesheetStaffRepository.findByStaffid(id);
    }

    public TimesheetStaff getDetailByStaffIdAndDate(String staffid, String date){return timesheetStaffRepository.findDetailByStaffidAndDate(staffid, date);}

    public List<TimesheetStaff> getAllByStaffIdAndDate(String staffid, String date,String month){return timesheetStaffRepository.findAllByStaffidAndDate(staffid, date,month);}

    public TimesheetStaff update(TimesheetStaff timesheetStaff){ return timesheetStaffRepository.save(timesheetStaff);}

    public String delete(String staffid, String date){
        TimesheetStaff t1 = timesheetStaffRepository.findDetailByStaffidAndDate(staffid,date);
        if(t1 != null){
            timesheetStaffRepository.delete(t1);
            return "Xóa thành công";
        }else{
            return null;
        }
    }

    public String delete(String staffid){
        return timesheetStaffRepository.deleteAllByStaffid(staffid);
    }
}
