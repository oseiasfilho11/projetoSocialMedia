package com.of.rest.webservices.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.of.rest.webservices.restfulwebservice.post.Post;

public class User {

	private Integer id;

	private String name;

	private Date birthDate;

	private List<Post> listaPosts = new ArrayList<Post>();

	protected User() {
	}

	public User(Integer id, String name, Date birthDate, List<Post> posts) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.listaPosts = posts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void addPost(Post post) {
		this.listaPosts.add(post);
	}

	public void removePost(Post post) {
		this.listaPosts.remove(post);
	}
	
	public List<Post> getAllPosts(){
		return this.listaPosts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
