package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TeacherCourseId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TeacherCourseId implements java.io.Serializable {

	// Fields

	private String cid;
	private String cname;
	private String tid;
	private String tname;
	private String year;
	private String semester;

	// Constructors

	/** default constructor */
	public TeacherCourseId() {
	}

	/** full constructor */
	public TeacherCourseId(String cid, String cname, String tid, String tname,
			String year, String semester) {
		this.cid = cid;
		this.cname = cname;
		this.tid = tid;
		this.tname = tname;
		this.year = year;
		this.semester = semester;
	}

	// Property accessors

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

	@Column(name = "tid", nullable = false, length = 20)
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
		if (!(other instanceof TeacherCourseId))
			return false;
		TeacherCourseId castOther = (TeacherCourseId) other;

		return ((this.getCid() == castOther.getCid()) || (this.getCid() != null
				&& castOther.getCid() != null && this.getCid().equals(
				castOther.getCid())))
				&& ((this.getCname() == castOther.getCname()) || (this
						.getCname() != null && castOther.getCname() != null && this
						.getCname().equals(castOther.getCname())))
				&& ((this.getTid() == castOther.getTid()) || (this.getTid() != null
						&& castOther.getTid() != null && this.getTid().equals(
						castOther.getTid())))
				&& ((this.getTname() == castOther.getTname()) || (this
						.getTname() != null && castOther.getTname() != null && this
						.getTname().equals(castOther.getTname())))
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
				+ (getCid() == null ? 0 : this.getCid().hashCode());
		result = 37 * result
				+ (getCname() == null ? 0 : this.getCname().hashCode());
		result = 37 * result
				+ (getTid() == null ? 0 : this.getTid().hashCode());
		result = 37 * result
				+ (getTname() == null ? 0 : this.getTname().hashCode());
		result = 37 * result
				+ (getYear() == null ? 0 : this.getYear().hashCode());
		result = 37 * result
				+ (getSemester() == null ? 0 : this.getSemester().hashCode());
		return result;
	}

}