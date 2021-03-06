package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SelectedBId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class SelectedBId implements java.io.Serializable {

	// Fields

	private String sid;
	private String sname;
	private String cid;
	private String cname;
	private String ctime;
	private String tid;
	private Integer mark2;
	private String year;
	private String semester;

	// Constructors

	/** default constructor */
	public SelectedBId() {
	}

	/** minimal constructor */
	public SelectedBId(String sid, String sname, String cid, String cname,
			String ctime, String tid, String year, String semester) {
		this.sid = sid;
		this.sname = sname;
		this.cid = cid;
		this.cname = cname;
		this.ctime = ctime;
		this.tid = tid;
		this.year = year;
		this.semester = semester;
	}

	/** full constructor */
	public SelectedBId(String sid, String sname, String cid, String cname,
			String ctime, String tid, Integer mark2, String year,
			String semester) {
		this.sid = sid;
		this.sname = sname;
		this.cid = cid;
		this.cname = cname;
		this.ctime = ctime;
		this.tid = tid;
		this.mark2 = mark2;
		this.year = year;
		this.semester = semester;
	}

	// Property accessors

	@Column(name = "sid", nullable = false, length = 20)
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

	@Column(name = "cid", nullable = false, length = 10)
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

	@Column(name = "ctime", nullable = false, length = 20)
	public String getCtime() {
		return this.ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	@Column(name = "tid", nullable = false, length = 20)
	public String getTid() {
		return this.tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	@Column(name = "mark_2")
	public Integer getMark2() {
		return this.mark2;
	}

	public void setMark2(Integer mark2) {
		this.mark2 = mark2;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SelectedBId))
			return false;
		SelectedBId castOther = (SelectedBId) other;

		return ((this.getSid() == castOther.getSid()) || (this.getSid() != null
				&& castOther.getSid() != null && this.getSid().equals(
				castOther.getSid())))
				&& ((this.getSname() == castOther.getSname()) || (this
						.getSname() != null && castOther.getSname() != null && this
						.getSname().equals(castOther.getSname())))
				&& ((this.getCid() == castOther.getCid()) || (this.getCid() != null
						&& castOther.getCid() != null && this.getCid().equals(
						castOther.getCid())))
				&& ((this.getCname() == castOther.getCname()) || (this
						.getCname() != null && castOther.getCname() != null && this
						.getCname().equals(castOther.getCname())))
				&& ((this.getCtime() == castOther.getCtime()) || (this
						.getCtime() != null && castOther.getCtime() != null && this
						.getCtime().equals(castOther.getCtime())))
				&& ((this.getTid() == castOther.getTid()) || (this.getTid() != null
						&& castOther.getTid() != null && this.getTid().equals(
						castOther.getTid())))
				&& ((this.getMark2() == castOther.getMark2()) || (this
						.getMark2() != null && castOther.getMark2() != null && this
						.getMark2().equals(castOther.getMark2())))
				&& ((this.getYear() == castOther.getYear()) || (this.getYear() != null
						&& castOther.getYear() != null && this.getYear()
						.equals(castOther.getYear())))
				&& ((this.getSemester() == castOther.getSemester()) || (this
						.getSemester() != null
						&& castOther.getSemester() != null && this
						.getSemester().equals(castOther.getSemester())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSid() == null ? 0 : this.getSid().hashCode());
		result = 37 * result
				+ (getSname() == null ? 0 : this.getSname().hashCode());
		result = 37 * result
				+ (getCid() == null ? 0 : this.getCid().hashCode());
		result = 37 * result
				+ (getCname() == null ? 0 : this.getCname().hashCode());
		result = 37 * result
				+ (getCtime() == null ? 0 : this.getCtime().hashCode());
		result = 37 * result
				+ (getTid() == null ? 0 : this.getTid().hashCode());
		result = 37 * result
				+ (getMark2() == null ? 0 : this.getMark2().hashCode());
		result = 37 * result
				+ (getYear() == null ? 0 : this.getYear().hashCode());
		result = 37 * result
				+ (getSemester() == null ? 0 : this.getSemester().hashCode());
		return result;
	}

}