package com.book.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SelectedB entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "selected_b", catalog = "selectcourse")
public class SelectedB implements java.io.Serializable {

	// Fields

	private SelectedBId id;

	// Constructors

	/** default constructor */
	public SelectedB() {
	}

	/** full constructor */
	public SelectedB(SelectedBId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "sid", column = @Column(name = "sid", nullable = false, length = 20)),
			@AttributeOverride(name = "sname", column = @Column(name = "sname", nullable = false, length = 10)),
			@AttributeOverride(name = "cid", column = @Column(name = "cid", nullable = false, length = 10)),
			@AttributeOverride(name = "cname", column = @Column(name = "cname", nullable = false, length = 20)),
			@AttributeOverride(name = "ctime", column = @Column(name = "ctime", nullable = false, length = 20)),
			@AttributeOverride(name = "tid", column = @Column(name = "tid", nullable = false, length = 20)),
			@AttributeOverride(name = "mark2", column = @Column(name = "mark_2")),
			@AttributeOverride(name = "year", column = @Column(name = "year", nullable = false, length = 20)),
			@AttributeOverride(name = "semester", column = @Column(name = "semester", nullable = false, length = 10)) })
	public SelectedBId getId() {
		return this.id;
	}

	public void setId(SelectedBId id) {
		this.id = id;
	}

}