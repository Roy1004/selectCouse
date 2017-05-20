package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MessageId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class MessageId implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String message;
	private String status;

	// Constructors

	/** default constructor */
	public MessageId() {
	}

	/** minimal constructor */
	public MessageId(String name, String message, String status) {
		this.name = name;
		this.message = message;
		this.status = status;
	}

	/** full constructor */
	public MessageId(String id, String name, String message, String status) {
		this.id = id;
		this.name = name;
		this.message = message;
		this.status = status;
	}

	// Property accessors

	@Column(name = "id", length = 20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "message", nullable = false, length = 400)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "status", nullable = false, length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MessageId))
			return false;
		MessageId castOther = (MessageId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getMessage() == castOther.getMessage()) || (this
						.getMessage() != null && castOther.getMessage() != null && this
						.getMessage().equals(castOther.getMessage())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getMessage() == null ? 0 : this.getMessage().hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		return result;
	}

}