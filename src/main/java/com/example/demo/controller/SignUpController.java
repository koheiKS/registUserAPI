package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.SignUpForm;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {

	@GetMapping
	public SignUpForm greeting() {
		return new SignUpForm();
	}
}
