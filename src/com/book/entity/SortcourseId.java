package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class SortcourseId implements java.io.Serializable {

	

	private String xb;
	private String week;
	private String class_;
	private String year;
	private String semester;

	

	
	public SortcourseId() {
	}

	
	public SortcourseId(String xb, String week, String class_, String year,
			String semester) {
		this.xb = xb;
		this.week = week;
		this.class_ = class_;
		this.year = year;
		this.semester = semester;
	}

	

	@Column(name = "xb", nullable = false, length = 20)
	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	@Column(name = "week", nullable = false, length = 10)
	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@Column(name = "class", nullable = false, length = 10)
	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
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
		if (!(other instanceof SortcourseId))
			return false;
		SortcourseId castOther = (SortcourseId) other;

		return ((this.getXb() == castOther.getXb()) || (this.getXb() != null
				&& castOther.getXb() != null && this.getXb().equals(
				castOther.getXb())))
				&& ((this.getWeek() == castOther.getWeek()) || (this.getWeek() != null
						&& castOther.getWeek() != null && this.getWeek()
						.equals(castOther.getWeek())))
				&& ((this.getClass_() == castOther.getClass_()) || (this
						.getClass_() != null && castOther.getClass_() != null && this
						.getClass_().equals(castOther.getClass_())))
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

		result = 37 * result + (getXb() == null ? 0 : this.getXb().hashCode());
		result = 37 * result
				+ (getWeek() == null ? 0 : this.getWeek().hashCode());
		result = 37 * result
				+ (getClass_() == null ? 0 : this.getClass_().hashCode());
		result = 37 * result
				+ (getYear() == null ? 0 : this.getYear().hashCode());
		result = 37 * result
				+ (getSemester() == null ? 0 : this.getSemester().hashCode());
		return result;
	}

}