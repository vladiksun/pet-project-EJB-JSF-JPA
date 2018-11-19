package com.testTask.utils;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 * Application-scoped CDI bean for storing constant values objects.
 * Serves as filter options holder for datatable primefaces object.
 * 
 * @author Vladislav Bondarchuk
 * 
 */
@Named("constantValuesHolder")
@ApplicationScoped
public class ConstantValuesHolder {

	private static final long serialVersionUID = -3068333669859836249L;

        private ArrayList<String> groupNumbers = new ArrayList();
        private ArrayList<String> scholarshipType = new ArrayList();
        private ArrayList<String> faculty = new ArrayList();
        
        private SelectItem[] scholarshipTypeOptions;
        private SelectItem[] groupNumbersOptions;
        private SelectItem[] facultyOptions;

    public ConstantValuesHolder() {
        groupNumbers.add("1");
        groupNumbers.add("2");
        groupNumbers.add("3");
        groupNumbers.add("4");
        
        scholarshipType.add("HIGH");
        scholarshipType.add("LOW");
        
        faculty.add("Faculty of Ecomomics");
        faculty.add("Faculty of Metall Treatment");
        faculty.add("Faculty of Philosophy");

        scholarshipTypeOptions = createFilterOptions(scholarshipType);
        groupNumbersOptions = createFilterOptions(groupNumbers);
        facultyOptions = createFilterOptions(faculty);
    }

    public ArrayList<String> getGroupNumbers() {
        return groupNumbers;
    }

    public void setGroupNumbers(ArrayList<String> groupNumbers) {
        this.groupNumbers = groupNumbers;
    }

    public ArrayList<String> getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(ArrayList<String> scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public ArrayList<String> getFaculty() {
        return faculty;
    }

    public void setFaculty(ArrayList<String> faculty) {
        this.faculty = faculty;
    }

    public SelectItem[] getScholarshipTypeOptions() {
        return scholarshipTypeOptions;
    }

    public SelectItem[] getGroupNumbersOptions() {
        return groupNumbersOptions;
    }

    public SelectItem[] getFacultyOptions() {
        return facultyOptions;
    }
    
    
    /**
	 * Returns A List of SelectItem objects as array for further use in filtering mechanism from PrimeFaces
	 * 
	 * @return A List of SelectItem objects.
	 */
    private SelectItem[] createFilterOptions(ArrayList<String> data)  {  
        SelectItem[] options = new SelectItem[data.size() + 1];  
  
        options[0] = new SelectItem("", "Select");  
        for(int i = 0; i < data.size(); i++) {  
            options[i + 1] = new SelectItem(data.get(i), data.get(i));  
        }  
        return options;  
    }     
}
