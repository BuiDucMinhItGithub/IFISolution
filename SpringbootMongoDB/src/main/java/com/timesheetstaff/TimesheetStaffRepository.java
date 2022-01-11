package com.timesheetstaff;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimesheetStaffRepository extends MongoRepository<TimesheetStaff, String> {
    List<TimesheetStaff> findByStaffid(String id);
    TimesheetStaff findDetailByStaffidAndDate(String staffid, String date);
    @Query("{staffid: ?0,date : /^?1-?2/ }")
    List<TimesheetStaff> findAllByStaffidAndDate(String staffid, String date, String month);
    String deleteAllByStaffid(String staffid);

}
