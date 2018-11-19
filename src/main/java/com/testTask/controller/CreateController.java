package com.testTask.controller;

import com.testTask.entity.Groups;
import com.testTask.entity.Student;
import com.testTask.service.TableService;
import com.testTask.utils.Credentials;
import javax.inject.Inject;
import javax.inject.Named;
/**
 * Controller class for student creation page
 * 
 * Injection according to new JSF 2.0
 * http://www.mkyong.com/jsf2/injecting-managed-beans-in-jsf-2-0/
 * 
 * @author Vladislav Bondarchuk"
 */
@Named
@javax.faces.view.ViewScoped
public class CreateController extends AbstractController {

   private static final long serialVersionUID = -6710063228036238767L;

   @Inject
   TableService tableService;

   Credentials credentials = new Credentials();
   
   Student newstudent;

    /**
     * Method for student data creation. Broadcasts the message if creation is successfull.
     * Otherwise in case of exception broadcasts error message.
     */
    public String createStudent() {
        try {
            Groups group = tableService.findGroups(credentials.getGroupnumber(), credentials.getFaculty());
            newstudent = new Student();
            newstudent.setFirstname(credentials.getFirstname());
            newstudent.setLastname(credentials.getLastname());
            newstudent.setMiddlename(credentials.getMiddlename());
            newstudent.setScholarshiptype(credentials.getScholarshiptype());
            newstudent.setEntrydate(credentials.getEntrydate());
            newstudent.setGroup(group);
            
            tableService.saveStudent(newstudent);
            
            credentials.setEntrydate(null);
            credentials.setFirstname(null);
            credentials.setMiddlename(null);
            credentials.setLastname(null);
            credentials.setFaculty(null);
            credentials.setScholarshiptype(null);
            credentials.setGroupnumber(null);
            addInfoMessage("broadcast.message_create");
            
            
        } catch (Exception e) {
            addErrorMessage("Error happend during persistence operation");
        }
        return null;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
    
    
}
