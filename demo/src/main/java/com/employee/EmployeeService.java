package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee add(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getDeleted(){
        return employeeRepository.findByDeleted(0);
    }

    public List<Employee> getNotDeleted(){
        return employeeRepository.findByDeleted(1);
    }

    public Employee findById(int id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getListByFullNameAndBirthDate(String fullName, Date birthDate){
        return employeeRepository.getListByFullNameAndBirthDate(fullName, birthDate);
    }

    public List<Employee> getEmployee(String keyword) {
        if (keyword != null) {
            return employeeRepository.search(keyword);
        }
        return (List<Employee>) employeeRepository.findAll();
    }


}
