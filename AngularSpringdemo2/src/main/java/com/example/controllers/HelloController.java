package com.example.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/admin")
	public String admin(){
		return "jestem adminem";
	}
	
//	@RequestMapping("/user")
//	public String user(){ 
//		return "jestem Userem";
//	}
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		System.out.println(user.getName());
		return user;
	}
	
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World")	;
		return model;
	}

}
