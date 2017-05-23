package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "teacher", catalog = "selectcourse")
public class Teacher implements java.io.Serializable {



	private String tid;
	private String tname;
	private String tpassword;
	private String power;
	private String tsex;

	

	
	public Teacher() {
	}

	
	public Teacher(String tid, String tname, String tpassword,
			String power, String tsex) {
		this.tid = tid;
		this.tname = tname;
		this.tpassword = tpassword;
		this.power = power;
		this.tsex = tsex;
	}

	
	@Id
	@Column(name = "tid", unique = true, nullable = false, length = 20)
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	@Column(name = "tname", nullable = false, length = 10)
	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Column(name = "tpassword", nullable = false, length = 20)
	public String getTpassword() {
		return this.tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	@Column(name = "power", nullable = false, length = 10)
	public String getPower() {
		return this.power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	@Column(name = "tsex", nullable = false, length = 10)
	public String getTsex() {
		return this.tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

}