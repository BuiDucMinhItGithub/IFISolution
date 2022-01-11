package com.employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query("select u from Employee u where u.fullName like %:fullName% and u.birthDate = :birthDate")
    List<Employee> getListByFullNameAndBirthDate(String fullName, Date birthDate);

    @Query("SELECT s FROM Employee s WHERE s.address LIKE %?1%"
            + " OR s.fullName LIKE %?1%")
    List<Employee> search(String keyword);

    List<Employee> findByDeleted(int number);

}
