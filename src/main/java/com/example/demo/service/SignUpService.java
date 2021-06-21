package com.example.demo.service;

import org.springframework.validation.BindingResult;

import com.example.demo.form.CheckResultForm;
import com.example.demo.form.SignUpForm;

public class SignUpService {

	public CheckResultForm checkSignUpForm(BindingResult result) {
		CheckResultForm checkResultForm = new CheckResultForm();
		return checkResultForm;
	}

	public void saveUserData(SignUpForm signUpForm) {
	}
}
