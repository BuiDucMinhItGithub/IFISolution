package com.timesheetstaff;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "timesheet")
public class TimesheetStaff {
    @Id
    private String id;
    @Field(value = "staffid")
    private String staffid;
    @Field(value = "date")
    private String date;
    @Field(value = "checkin")
    private String checkin;
    @Field(value = "checkout")
    private String checkout;

    public TimesheetStaff(String id, String staffid, String date, String checkin, String checkout) {
        this.id = id;
        this.staffid = staffid;
        this.date = date;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public TimesheetStaff() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    //
//    public TimesheetStaff() {
//    }
//
//    public TimesheetStaff(String id, String staffid, String date, String time) {
//        this.id = id;
//        this.staffid = staffid;
//        this.date = date;
//        this.time = time;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getStaffid() {
//        return staffid;
//    }
//
//    public void setStaffid(String staffid) {
//        this.staffid = staffid;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }

    //    public TimesheetStaff(String id, String staffid, String date, String checkin, String checkout) {
//        this.id = id;
//        this.staffid = staffid;
//        this.date = date;
//        this.checkin = checkin;
//        this.checkout = checkout;
//    }
//
//    public TimesheetStaff(String staffid, String date, String checkin, String checkout) {
//        this.staffid = staffid;
//        this.date = date;
//        this.checkin = checkin;
//        this.checkout = checkout;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getStaffid() {
//        return staffid;
//    }
//
//    public void setStaffid(String staffid) {
//        this.staffid = staffid;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getCheckin() {
//        return checkin;
//    }
//
//    public void setCheckin(String checkin) {
//        this.checkin = checkin;
//    }
//
//    public String getCheckout() {
//        return checkout;
//    }
//
//    public void setCheckout(String checkout) {
//        this.checkout = checkout;
//    }
//
//    public boolean hasBeenProcessed() {
//        return false;
//    }
//
//    public void setProcessed(boolean b) {
//    }
}
