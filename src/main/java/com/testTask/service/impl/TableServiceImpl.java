package com.testTask.service.impl;

import com.testTask.entity.Groups;
import com.testTask.entity.Student;
import com.testTask.service.TableService;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 * Groups service implementation ejb class
 * 
 */
@Named("groupService")
@Stateless
public class TableServiceImpl extends AbstractService implements TableService {

/**
 * {@inheritDoc}
*/
    @Override
    public Groups findGroups(String groupnumber, String faculty) {
        TypedQuery<Groups> query = em.createNamedQuery("Groups.findByGroupNumberAndFaculty",Groups.class);
		query.setParameter(1, groupnumber);
		query.setParameter(2, faculty);
		List<Groups> groups = query.getResultList();
		if (!groups.isEmpty()) {
			return groups.get(0);
		}
		return null;
    }
    
/**
 * {@inheritDoc}
*/
    @Override
    public List<Student> listStudents() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> student = query.from(Student.class);
        query.select(student);
        return em.createQuery(query).getResultList();
    }

/**
 * {@inheritDoc}
*/
    @Override
    public Student saveStudent(Student newstudent) {
        Student savedstudent = newstudent;
            em.persist(newstudent);
            return savedstudent;
        
    }
  
/**
 * {@inheritDoc}
*/
    @Override
    public List<Groups> getGroups() {
        TypedQuery<Groups> query = em.createNamedQuery("Groups.findAll",Groups.class);
		List<Groups> groups = query.getResultList();
		return groups;
    }
       
/**
 * {@inheritDoc}
*/
    @Override
    public void deleteStudent(Long id){
        Student student = em.find(Student.class,id);
        em.remove(student);
    }

    
/**
 * {@inheritDoc}
*/
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void updateStudent(Student student_to_update) {

        Student student = em.find(Student.class,student_to_update.getId());
        if (!student.getFirstname().equals(student_to_update.getFirstname())){
            student.setFirstname(student_to_update.getFirstname());
        }
        else if (!student.getEntrydate().equals(student_to_update.getEntrydate())){
            student.setEntrydate(student_to_update.getEntrydate());
        }
        else if (!student.getLastname().equals(student_to_update.getLastname())){
            student.setLastname(student_to_update.getLastname());
        }
        else if (!student.getMiddlename().equals(student_to_update.getMiddlename())){
            student.setMiddlename(student_to_update.getMiddlename());
        }
        else if (!student.getScholarshiptype().equals(student_to_update.getScholarshiptype())){
            student.setScholarshiptype(student_to_update.getScholarshiptype());
        }
        else if (!student.getGroup().getFaculty().equals(student_to_update.getGroup().getFaculty()) || 
                 !student.getGroup().getGroupnumber().equals(student_to_update.getGroup().getGroupnumber())){
            Groups group = findGroups(student_to_update.getGroup().getGroupnumber(), student_to_update.getGroup().getFaculty());
            student.setGroup(group);
        }
        em.merge(student);
    }
    

	
}
