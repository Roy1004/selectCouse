package com.book.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "selected_a", catalog = "selectcourse")
public class SelectedA implements java.io.Serializable {

	
	private SelectedAId id;

	

	public SelectedA() {
	}

	
	public SelectedA(SelectedAId id) {
		this.id = id;
	}


	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "sid", column = @Column(name = "sid", nullable = false, length = 20)),
			@AttributeOverride(name = "sname", column = @Column(name = "sname", nullable = false, length = 10)),
			@AttributeOverride(name = "cid", column = @Column(name = "cid", nullable = false, length = 10)),
			@AttributeOverride(name = "cname", column = @Column(name = "cname", nullable = false, length = 20)),
			@AttributeOverride(name = "ctime", column = @Column(name = "ctime", nullable = false, length = 20)),
			@AttributeOverride(name = "tid", column = @Column(name = "tid", nullable = false, length = 20)),
			@AttributeOverride(name = "mark1", column = @Column(name = "mark_1")),
			@AttributeOverride(name = "year", column = @Column(name = "year", nullable = false, length = 20)),
			@AttributeOverride(name = "semester", column = @Column(name = "semester", nullable = false, length = 10)) })
	public SelectedAId getId() {
		return this.id;
	}

	public void setId(SelectedAId id) {
		this.id = id;
	}

}