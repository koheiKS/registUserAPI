package com.example.demo.form;

import lombok.Data;

@Data
public class SignUpForm {

	private String name;

	private String email;

	private String password;

	private String confirmPassword;

	public SignUpForm() {
		this.name = "";
		this.email = "";
		this.password = "";
		this.confirmPassword = "";
	}

}
