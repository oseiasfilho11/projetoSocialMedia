package com.of.rest.webservices.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.of.rest.webservices.restfulwebservice.post.Post;

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
		User user = userService.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id - " + id);
		return user;
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userService.deleteById(id);
		if (user == null)
			throw new UserNotFoundException("id - " + id);
	}

	// @RequestMapping(method = RequestMethod.POST, path = "/users") <- usando o
	// requestmapping
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userSaved = userService.save(user);

		// Cria uma nova uri com informações da requisição feita acrescentando apenas
		// "/id" do objeto salvado e o enviado devolta na resposta.
		// No cabeçalho http esse caminho vai ser o "Location" que corresponde o caminho
		// onde o objeto se encontra
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId())
				.toUri();

		// retorna o codigo 201 que significa que um novo recurso foi criado ao
		// contrario enviaria apenas o 200
		return ResponseEntity.created(uri).build();
	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Post> retrieveUserPosts(@PathVariable int id) {
		User user = userService.findOne(id);
		List<Post> listaUser = user.getAllPosts();
		if (user == null)
			throw new UserNotFoundException("id - " + id);

		return listaUser;
	}
}
