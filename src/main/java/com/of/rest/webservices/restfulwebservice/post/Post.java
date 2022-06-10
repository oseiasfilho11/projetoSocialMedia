package com.of.rest.webservices.restfulwebservice.post;

import java.util.Date;

import com.of.rest.webservices.restfulwebservice.user.User;

public class Post {

	private String message;
	private Date timepost;
	private User user;

	public Post(String message, User user) {
		timepost = new Date();
		this.message = message;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimepost() {
		return timepost;
	}

	public void setTimepost(Date timepost) {
		this.timepost = timepost;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
