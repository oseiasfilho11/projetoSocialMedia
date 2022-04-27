package com.of.rest.webservices.restfulwebservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	UserDaoService userService;

	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<User> retriveAllUsers() {
		return userService.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User retriveUser(@PathVariable int id) {
		return userService.findOne(id);
	}

	//@RequestMapping(method = RequestMethod.POST, path = "/users") <- usando o requestmapping
	@PostMapping(path = "/users")
	public void createUser(@RequestBody User user) {
		User userSaved = userService.save(user);
	}
}
