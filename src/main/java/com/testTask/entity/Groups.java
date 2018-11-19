package com.testTask.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the <code>groups<code> database table.
 * @author Vladislav Bondarchuk
 * 
 */
@Entity

@NamedQueries({
		@NamedQuery(name="Groups.findAll", query="SELECT g FROM Groups g"),
                @NamedQuery(name="Groups.findByGroupNumberAndFaculty", query="SELECT g FROM Groups g where g.groupnumber=?1 and g.faculty=?2")})

public class Groups implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String faculty;

	private String groupnumber;

	//bi-directional many-to-one association to Student - optional, uncomment to set active and change logic
//	@OneToMany(cascade = CascadeType.ALL,mappedBy="group")
//	private Set<Student> students;

	public Groups() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFaculty() {
		return this.faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getGroupnumber() {
		return this.groupnumber;
	}

	public void setGroupnumber(String groupnumber) {
		this.groupnumber = groupnumber;
	}

//	public Set<Student> getStudents() {
//		return this.students;
//	}
//
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}

//	public Student addStudent(Student student) {
//		getStudents().add(student);
//		student.setGroups(this);
//
//		return student;
//	}
//
//	public Student removeStudent(Student student) {
//		getStudents().remove(student);
//		student.setGroups(null);
//
//		return student;
//	}

    public Groups(String faculty, String groupnumber) {
        this.faculty = faculty;
        this.groupnumber = groupnumber;
    }

}