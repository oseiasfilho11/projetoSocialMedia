package com.of.rest.webservices.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.of.rest.webservices.restfulwebservice.post.Post;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int userCount = 3;

	private static List<Post> postsUser1 = new ArrayList<>();

	private static List<Post> postsUser2 = new ArrayList<>();

	static {
		postsUser1.add(new Post("Bom dia", null));
		postsUser1.add(new Post("Tudo bem", null));
	}

	static {
		postsUser2.add(new Post("Hoje esta um lindo dia", null));
		postsUser2.add(new Post("Eu ja estou indo", null));
	}
	static {
		users.add(new User(1, "Adam", new Date(), postsUser1));
		users.add(new User(2, "Eve", new Date(), postsUser2));
		users.add(new User(3, "Jack", new Date(), null));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}

		return null;
	}

}
