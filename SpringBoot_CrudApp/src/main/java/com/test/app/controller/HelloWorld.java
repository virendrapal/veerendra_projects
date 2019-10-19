package com.test.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@GetMapping("/hello")
	public String helloTest(){
		System.out.println("helloWorld");
		return "Hello world";
	}
}
