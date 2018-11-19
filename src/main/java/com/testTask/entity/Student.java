package com.testTask.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the <code>student<code> database table.
 * @author Vladislav Bondarchuk
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date entrydate;

	private String firstname;

	private String lastname;

	private String middlename;

	private String scholarshiptype;

	//bi-directional many-to-one association to Group - optional, uncomment to set active
//	@ManyToOne(cascade = CascadeType.ALL)
        @ManyToOne
	@JoinColumn(name="id_group")
	private Groups group;

	public Student() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEntrydate() {
		return this.entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getScholarshiptype() {
		return this.scholarshiptype;
	}

	public void setScholarshiptype(String scholarshiptype) {
		this.scholarshiptype = scholarshiptype;
	}

	public Groups getGroup() {
		return this.group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}

    public Student(Date entrydate, String firstname, String lastname, String middlename, String scholarshiptype, Groups group) {
        this.entrydate = entrydate;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.scholarshiptype = scholarshiptype;
        this.group = group;
    }

}