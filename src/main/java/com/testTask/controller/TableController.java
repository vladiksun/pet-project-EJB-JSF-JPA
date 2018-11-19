package com.testTask.controller;

import com.testTask.entity.Groups;
import com.testTask.entity.Student;
import com.testTask.service.TableService;
import com.testTask.utils.Credentials;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Table controller class.
 * 
 * Injection according to new JSF 2.0
 * http://www.mkyong.com/jsf2/injecting-managed-beans-in-jsf-2-0/
 * 
 * @author Vladislav Bondarchuk
 */
@Named
@javax.faces.view.ViewScoped
public class TableController extends AbstractController {

	private static final long serialVersionUID = -6710063228036238737L;

        @Inject
        TableService tableService;
        
        private List<Student> students;
        private List<Student> filteredStudents;
        private Student selectedStudent;
        Credentials credentials = new Credentials();

        
        /**
	 * Returns all {@link Student} objects for use in datatable view
	 * 
	 * @return A List of Student objects.
	 */
        public List<Student> getStudents() {
            return tableService.listStudents();
        }
        
        /**
	 * Getter for list of {@link Student} objects to hold filtered values. Used by  Primeface's filtration api
         * @return A List of Student objects.
	 */
        public List<Student> getFilteredStudents() {
            return filteredStudents;
        }
        
        /**
	 * Getter for {@link Student} object to edit.
         * @return A Student object.
	 */
        public Student getSelectedStudent() {
            return selectedStudent;
        }

        public void setSelectedStudent(Student selectedStudent) {
            this.selectedStudent = selectedStudent;
        }

        public void setFilteredStudents(List<Student> filteredStudents) {
            this.filteredStudents = filteredStudents;
        }

        public Credentials getCredentials() {
            return credentials;
        }

        public void setCredentials(Credentials credentials) {
            this.credentials = credentials;
        }
        
//        public void loadCredentials(Student studenttoedit) {
//            credentials.setEntrydate(studenttoedit.getEntrydate());
//        }
   
         /**
	 * Calls {@link TableService} deleteStudent method
	 * 
	 * @param id
	 * 
	 */
        public void deleteStudent(Long id){
            tableService.deleteStudent(id);
            addInfoMessage("broadcast.message_delete");
        }
        
        /**
	 * Calls <code>TableService</code> updateStudent method
	 * 
	 * @param studenttoupdate
	 * 
	 */
        public void updateStudent (Student studenttoupdate){
            try {
                if (studenttoupdate.getId() == null){
                    throw new Exception();
                }
                else{
                     tableService.updateStudent(studenttoupdate);
                     addInfoMessage("broadcast.message_update");
                }

            } catch (Exception e) {
                addErrorMessage("Error happend during persistence");
            }
        }
         

}
