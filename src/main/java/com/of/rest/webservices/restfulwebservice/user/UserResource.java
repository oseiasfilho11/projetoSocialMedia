package com.of.rest.webservices.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userSaved = userService.save(user);
		
		//Cria uma nova uri com informações da requisição feita acrescentando apenas "/id" do objeto salvado e o enviado devolta na resposta.
		//No cabeçalho http esse caminho vai ser o "Location" que corresponde o caminho onde o objeto se encontra 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userSaved.getId()).toUri();	
		
		//retorna o codigo 201 que significa que um novo recurso foi criado ao contrario enviaria apenas o 200
		return ResponseEntity.created(uri).build();
	}
}
