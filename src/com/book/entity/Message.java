package com.book.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "selectcourse")
public class Message implements java.io.Serializable {

	// Fields

	private MessageId id;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(MessageId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", length = 20)),
			@AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, length = 10)),
			@AttributeOverride(name = "message", column = @Column(name = "message", nullable = false, length = 400)),
			@AttributeOverride(name = "status", column = @Column(name = "status", nullable = false, length = 10)) })
	public MessageId getId() {
		return this.id;
	}

	public void setId(MessageId id) {
		this.id = id;
	}

}