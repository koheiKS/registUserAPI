package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.form.CheckResultForm;
import com.example.demo.form.SignUpForm;
import com.example.demo.service.SignUpService;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {

	@Autowired
	SignUpService signUpService;

	@GetMapping
	public SignUpForm showSignUpForm() {
		return new SignUpForm();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CheckResultForm submitSignUpForm(@Validated @RequestBody SignUpForm SignUpForm, BindingResult result) {
		CheckResultForm checkResultForm = signUpService.checkSignUpForm(result);
		if (checkResultForm.isOk()) {
			signUpService.saveUserData(SignUpForm);
		}
		return checkResultForm;
	}
}
