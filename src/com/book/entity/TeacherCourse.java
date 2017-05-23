package com.book.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "teacher_course", catalog = "selectcourse")
public class TeacherCourse implements java.io.Serializable {

	

	private TeacherCourseId id;

	

	
	public TeacherCourse() {
	}

	
	public TeacherCourse(TeacherCourseId id) {
		this.id = id;
	}

	
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "cid", column = @Column(name = "cid", nullable = false, length = 10)),
			@AttributeOverride(name = "cname", column = @Column(name = "cname", nullable = false, length = 20)),
			@AttributeOverride(name = "tid", column = @Column(name = "tid", nullable = false, length = 20)),
			@AttributeOverride(name = "tname", column = @Column(name = "tname", nullable = false, length = 10)),
			@AttributeOverride(name = "year", column = @Column(name = "year", nullable = false, length = 20)),
			@AttributeOverride(name = "semester", column = @Column(name = "semester", nullable = false, length = 10)) })
	public TeacherCourseId getId() {
		return this.id;
	}

	public void setId(TeacherCourseId id) {
		this.id = id;
	}

}