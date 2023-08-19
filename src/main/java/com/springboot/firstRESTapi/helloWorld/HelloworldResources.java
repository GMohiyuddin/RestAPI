package com.springboot.firstRESTapi.helloWorld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldResources {

	@RequestMapping("/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}

	@RequestMapping("/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	@RequestMapping("/hello-world-path-param/{name}")
	public HelloWorldBean HelloWorldPathParam(@PathVariable String name) {
		return new HelloWorldBean("Hello World, " + name);
	}

	@RequestMapping("/hello-world-path-param/{name}/message/{message}")
	public HelloWorldBean HelloWorldMultiplePathParam(@PathVariable String name, @PathVariable String message) {
		return new HelloWorldBean("Hello " + name + "," + message);
	}
}
