package com.book.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Sortcourse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sortcourse", catalog = "selectcourse")
public class Sortcourse implements java.io.Serializable {

	// Fields

	private SortcourseId id;

	// Constructors

	/** default constructor */
	public Sortcourse() {
	}

	/** full constructor */
	public Sortcourse(SortcourseId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "xb", column = @Column(name = "xb", nullable = false, length = 20)),
			@AttributeOverride(name = "week", column = @Column(name = "week", nullable = false, length = 10)),
			@AttributeOverride(name = "class_", column = @Column(name = "class", nullable = false, length = 10)),
			@AttributeOverride(name = "year", column = @Column(name = "year", nullable = false, length = 20)),
			@AttributeOverride(name = "semester", column = @Column(name = "semester", nullable = false, length = 10)) })
	public SortcourseId getId() {
		return this.id;
	}

	public void setId(SortcourseId id) {
		this.id = id;
	}

}