package com.testTask.utils;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


/**
 * CDI-managed bean in request scope to collect user credentials.
 *
 * @author Vladislav Bondarchuk
 * 
 */
@Named("credentials")
@RequestScoped
public class Credentials {

	private String firstname;
        private String middlename;
        private String lastname;
        private Date entrydate;
        private String scholarshiptype;
        private String groupnumber;
        private String faculty;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public String getScholarshiptype() {
        return scholarshiptype;
    }

    public void setScholarshiptype(String scholarshiptype) {
        this.scholarshiptype = scholarshiptype;
    }

    public String getGroupnumber() {
        return groupnumber;
    }

    public void setGroupnumber(String groupnumber) {
        this.groupnumber = groupnumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

}
