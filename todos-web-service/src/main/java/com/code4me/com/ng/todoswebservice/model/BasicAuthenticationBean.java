package com.code4me.com.ng.todoswebservice.model;

public class BasicAuthenticationBean {
	private String message;

	public BasicAuthenticationBean() {}

	public BasicAuthenticationBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldModel [message=" + message + "]";
	}
}
