package com.jvcdp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class Blogpost implements Serializable{


	public Blogpost(String id, String name, String category, String comments,
			String description, Date lastUpdated) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.comments = comments;
		this.description = description;
		this.lastUpdated = lastUpdated;
	}

	String id = java.util.UUID.randomUUID().toString();
	String name;
	String category;
	String comments;
	String description;

	Date lastUpdated;

	public Blogpost() { }

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blogpost other = (Blogpost) obj;
		if (description == null)
		{
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Blogpost [id=" + id + ", name=" + name + ", description=" + description + ", name=" + name + "]";
	}
}
