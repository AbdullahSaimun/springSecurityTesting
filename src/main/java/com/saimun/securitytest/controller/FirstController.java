package com.saimun.securitytest.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
	@GetMapping(value = "/")
	public String fistMethod(HttpServletRequest request, HttpServletResponse response) {
		return "This is my first controller message and request is " +
				request.getSession().getId() +
				" and response status is  " +
				response.getStatus();
	}
}
