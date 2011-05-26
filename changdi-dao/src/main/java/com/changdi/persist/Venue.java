package com.changdi.persist;

import java.sql.Timestamp;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Venue {
	private long id;
	private String name;
	private String description;
	private Timestamp createAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("description", this.description)
				.append("name", this.name).append("createAt", this.createAt)
				.append("id", this.id).toString();
	}
}
