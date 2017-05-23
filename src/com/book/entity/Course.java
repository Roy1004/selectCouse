package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course", catalog = "selectcourse")
public class Course implements java.io.Serializable {

	private String cid;
	private String cname;
	private Integer total;
	private String start;
	private String end;
	private Integer selected;
	private Integer remain;
	private String place;
	private String kxnj;
	private String xbxz;
	private String year;
	private String semester;



	public Course() {
	}
	
	public Course(String cid, String cname, Integer total, String start,
			String end, Integer selected, Integer remain, String place,
			String kxnj, String xbxz, String year, String semester) {
		this.cid = cid;
		this.cname = cname;
		this.total = total;
		this.start = start;
		this.end = end;
		this.selected = selected;
		this.remain = remain;
		this.place = place;
		this.kxnj = kxnj;
		this.xbxz = xbxz;
		this.year = year;
		this.semester = semester;
	}

	
	@Id
	@Column(name = "cid", unique = true, nullable = false, length = 10)
	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Column(name = "cname", nullable = false, length = 20)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "total", nullable = false)
	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Column(name = "start", nullable = false, length = 10)
	public String getStart() {
		return this.start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	@Column(name = "end", nullable = false, length = 10)
	public String getEnd() {
		return this.end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Column(name = "selected", nullable = false)
	public Integer getSelected() {
		return this.selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	@Column(name = "remain", nullable = false)
	public Integer getRemain() {
		return this.remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}

	@Column(name = "place", nullable = false, length = 20)
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "kxnj", nullable = false, length = 10)
	public String getKxnj() {
		return this.kxnj;
	}

	public void setKxnj(String kxnj) {
		this.kxnj = kxnj;
	}

	@Column(name = "xbxz", nullable = false, length = 10)
	public String getXbxz() {
		return this.xbxz;
	}

	public void setXbxz(String xbxz) {
		this.xbxz = xbxz;
	}

	@Column(name = "year", nullable = false, length = 20)
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "semester", nullable = false, length = 10)
	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

}