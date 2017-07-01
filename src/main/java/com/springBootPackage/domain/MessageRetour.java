package com.springBootPackage.domain;

public class MessageRetour {
	private String message;

	public MessageRetour() {
	}

	public MessageRetour(String message) {
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
		return "MessageRetour [message=" + message + "]";
	}

}
