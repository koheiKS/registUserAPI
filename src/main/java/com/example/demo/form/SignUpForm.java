package com.example.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.demo.annotation.Confirm;
import com.example.demo.annotation.Unique;

import lombok.Data;

@Data
@Confirm(field="password")
@Unique(field="email", repositoryName="UserRepository")
public class SignUpForm {

	@NotEmpty
	@Size(min = 1, max = 30)
	private String name;

	@NotEmpty
	@Size(min = 5, max = 255)
	@Pattern(regexp = "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$")
	private String email;

	@NotEmpty
	@Size(min = 8, max = 30)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;

	@NotEmpty
	@Size(min = 8, max = 30)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String confirmPassword;

	public SignUpForm() {
		this.name = "";
		this.email = "";
		this.password = "";
		this.confirmPassword = "";
	}
}
