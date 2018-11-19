package com.testTask.utils;

import com.testTask.entity.Groups;
import com.testTask.entity.Student;
import com.testTask.service.TableService;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Singleton test data class generator for database. Automatically drops and creates the test database records.
 * For development use only.
 * @author Vladislav Bondarchuk
 * Uncomment to activate and change persistent unit settings
 */
@Singleton
@Startup
public class TestDataGenerator {
    @PersistenceContext(unitName = "hbm")
    EntityManager em;
    
    @Inject
    ConstantValuesHolder constantValuesHolder;  
    
    @Inject
    TableService tableService;

    @PostConstruct
    public void insert() {
     
    // insert unchanged list of groups 
    for (int i = 0; i <=3; i++){
        for (int j = 0; j <=2; j++){
           em.persist(new Groups(constantValuesHolder.getFaculty().get(j), constantValuesHolder.getGroupNumbers().get(i)));

        }
    } 
    Groups group1 = tableService.findGroups("1", "Faculty of Ecomomics");
    Groups group2 = tableService.findGroups("2", "Faculty of Metall Treatment");
    Groups group3 = tableService.findGroups("3", "Faculty of Philosophy");
    Student teststudent1 = new Student(new Date(2014-1900, 3, 15),"Андрей","Лермонтов", "Владимирович", 
                                constantValuesHolder.getScholarshipType().get(0), group1);
    Student teststudent2 = new Student(new Date(2014-1900, 2, 20),"Сергей","Гоголь", "Петрович", 
                                constantValuesHolder.getScholarshipType().get(0), group2);
    Student teststudent3 = new Student(new Date(2014-1900, 2, 20),"Павел","Симонов", "Олегович", 
                                constantValuesHolder.getScholarshipType().get(0), group3);
    Student teststudent4 = new Student(new Date(2014-1900, 2, 20),"Jhon","Chase", null, 
                                constantValuesHolder.getScholarshipType().get(0), group3);
    Student teststudent5 = new Student(new Date(2014-1900, 2, 20),"Ирина","Пушкина", "Игоревна", 
                                constantValuesHolder.getScholarshipType().get(0), group1);
    Student teststudent6 = new Student(new Date(2014-1900, 2, 20),"Никита","Достоевский", "Петрович", 
                                constantValuesHolder.getScholarshipType().get(0), group3);
   
    em.persist(teststudent1);
    em.persist(teststudent2);
    em.persist(teststudent3);
    em.persist(teststudent4);
    em.persist(teststudent5);
    em.persist(teststudent6);
       
    }
}
