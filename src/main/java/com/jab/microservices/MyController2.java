package com.jab.microservices;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MyController2 {

	@Autowired
	private final MyService service;
	
	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		return service.greet();
	}

}
