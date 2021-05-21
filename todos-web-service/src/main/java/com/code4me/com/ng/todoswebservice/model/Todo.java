package com.code4me.com.ng.todoswebservice.model;

import java.util.Date;

public class Todo {
	private int id;
	private String username;
	private String description;
	private Date targetDate;
	private Boolean isDone;
	
	public Todo() {}
	
	
	public Todo(int id, String username, String description, Date targetDate, Boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	
	public Long getId() {
		return (long) id;
	}

	public String getUsername() {
		return username;
	}

	public String getDescription() {
		return description;
	}

	public Date getTargetDate() {
		return targetDate;
	}
	
	

	public void setId(int id) {
		this.id = id;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}


	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	public Boolean getIsDone() {
		return isDone;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
