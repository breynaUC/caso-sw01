package com.example.wsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

	@GetMapping("/")
	String mensaje() {
		return "Mi primer API 2021";
	}
}
