package com.todo.rest.webservice.restwebservice.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "Hello World!!";
	}
	
	@GetMapping(path="/helloworld-bean")
	public HelloWorldBean helloWorldBean() {
		//throw new RuntimeException("Error has occured");
		return new HelloWorldBean("Hello World!! My World");
	}
	@GetMapping(path="/helloworld-bean/path-variabe/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World!!, %s", name));
	}
}
