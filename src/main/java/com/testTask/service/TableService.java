package com.testTask.service;

import com.testTask.entity.Groups;
import com.testTask.entity.Student;
import java.util.List;


/**
 * Interface for group database service.
 * 
 *  @author Vladislav Bondarchuk
 * 
 */
public interface TableService {

    /**
	 * Finds a {@link Groups} object with the given groupnumber and faculty. 
	 * 
	 * @param groupnumber
	 *            The group number.
	 * @param faculty
	 *            The faculty.
	 * @return A Groups object if found.
	 */
	public Groups findGroups(String groupnumber, String faculty);
        
        
         /**
	 * Creates a list of all {@link Student}.
	 * 
	 *
	 * @return a list of students
	 */
	public List<Student> listStudents();
        
         
        /**
	 * Creates a new {@link Student} record .
	 *
         * @param newstudent
	 * @return a student object
	 */
	public Student saveStudent(Student newstudent);
        
        
        /**
	 * Returns all {@link Groups} objects.
	 * 
	 * @return A List of Groups objects.
	 */
	public List<Groups> getGroups();
        
        
         /**
	 * Removes picked {@link  Student} record from database.
	 * @param id
	 */
        public void deleteStudent(Long id);
            
        /**
	 * Updates the {@link Student} record in database.
	 *
         * @param student_to_update
	 * 
	 */
	public void updateStudent(Student student_to_update);

    }
	

