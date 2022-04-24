package com.of.rest.webservices.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

	//@RequestMapping(method = RequestMethod.GET, path = "/hello-word") - duas formas de fazer, requestmapping ou getmapping, no requestmapping tem-se que especificar o metodo http.  
	@GetMapping(path = "/hello-word")
	public String helloWord() {
		return "Hello Word";
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/hello-word-bean")
	public HelloWordBeand helloWordBean() {
		return new HelloWordBeand("Hello World");
	}
}
