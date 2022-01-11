package com.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    @RolesAllowed("admin")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/detail/{staffid}")
    @RolesAllowed("admin")
    public Employee getDetail(@PathVariable int staffid){
        return employeeService.findById(staffid);
    }

    @GetMapping("/deleted")
    @RolesAllowed("admin")
    public List<Employee> getDeleted(){
        return employeeService.getDeleted();
    }

    @GetMapping("/notdeleted")
    @RolesAllowed("admin")
    public List<Employee> getNotDeleted(){
        return employeeService.getNotDeleted();
    }

    @GetMapping("/list/{fullName}/{birthDate}")
    @RolesAllowed("admin")
    public List<Employee> getListByNameAndBirthDate(@PathVariable String fullName, @PathVariable Date birthDate){
        return employeeService.getListByFullNameAndBirthDate(fullName,birthDate);
    }

    @GetMapping("/find")
    @RolesAllowed("admin")
    public List<Employee> getEmployees(@RequestParam(required = false) String keyword) {
        return employeeService.getEmployee(keyword);
    }


    @PostMapping()
    @RolesAllowed("admin")
    public Employee add(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @PutMapping()
    @RolesAllowed("admin")
    public Employee update(@RequestBody Employee employee){
        return employeeService.add(employee);
    }

    @DeleteMapping("/{staffid}")
    @RolesAllowed("admin")
    public Employee delete(@PathVariable int staffid){
        Employee employee = employeeService.findById(staffid);
        employee.setDeleted(0);
        employeeService.add(employee);
        return employeeService.findById(staffid);
    }


}
