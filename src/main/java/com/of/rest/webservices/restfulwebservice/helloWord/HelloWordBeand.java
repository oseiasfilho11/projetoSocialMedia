package com.of.rest.webservices.restfulwebservice.helloWord;

public class HelloWordBeand {

	private String message;
	
	public HelloWordBeand(String message) {
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
	@Override
	public String toString() {
		return "HelloWordBeand [message=" + message + "]";
	}
	
	

}
