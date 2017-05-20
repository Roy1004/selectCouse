package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", catalog = "selectcourse")
public class Student implements java.io.Serializable {

	// Fields

	private String sid;
	private String sname;
	private String spassword;
	private String ssex;
	private String zymc;
	private String xb;
	private String grade;
	private String bj;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String sid, String sname, String spassword, String ssex,
			String zymc, String xb, String grade, String bj) {
		this.sid = sid;
		this.sname = sname;
		this.spassword = spassword;
		this.ssex = ssex;
		this.zymc = zymc;
		this.xb = xb;
		this.grade = grade;
		this.bj = bj;
	}

	// Property accessors
	@Id
	@Column(name = "sid", unique = true, nullable = false, length = 20)
	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Column(name = "sname", nullable = false, length = 10)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "spassword", nullable = false, length = 20)
	public String getSpassword() {
		return this.spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	@Column(name = "ssex", nullable = false, length = 10)
	public String getSsex() {
		return this.ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	@Column(name = "zymc", nullable = false, length = 20)
	public String getZymc() {
		return this.zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

	@Column(name = "xb", nullable = false, length = 20)
	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	@Column(name = "grade", nullable = false, length = 10)
	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Column(name = "bj", nullable = false, length = 10)
	public String getBj() {
		return this.bj;
	}

	public void setBj(String bj) {
		this.bj = bj;
	}

}