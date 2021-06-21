package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.entity.UserEntity;
import com.example.demo.form.CheckResultForm;
import com.example.demo.form.SignUpForm;
import com.example.demo.repository.UserRepository;

@Service
public class SignUpService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	EncryptionService encryptionService;

	public CheckResultForm checkSignUpForm(BindingResult result) {
		CheckResultForm checkResultForm = new CheckResultForm();
		checkResultForm.setErrorMessages(this.getErrorMessages(result));
		checkResultForm.setOk(this.canPassValidation(result));
		return checkResultForm;
	}

	// エラーメッセージを全て取得
	private Map<String, List<String>> getErrorMessages(BindingResult result) {
		Map<String, List<String>> errorMessages = new HashMap<String, List<String>>();
		for (FieldError fieldError : result.getFieldErrors()) {
			if (errorMessages.containsKey(fieldError.getField())) {
				this.addErrorMessageToExistingField(errorMessages, fieldError);
			} else {
				this.addErrorMessageToNewField(errorMessages, fieldError);
			}
		}
		return errorMessages;
	}

	// 新たなフィールドにエラーメッセージを追加する
	private void addErrorMessageToNewField(Map<String, List<String>> errorMessages, FieldError fieldError) {
		List<String> fieldErrorMessage = new ArrayList<String>();
		fieldErrorMessage.add(fieldError.getDefaultMessage());
		errorMessages.put(fieldError.getField(), fieldErrorMessage);
	}

	// 既にエラーメッセージがあるフィールドに、エラーメッセージを追加する
	private void addErrorMessageToExistingField(Map<String, List<String>> errorMessages, FieldError fieldError) {
		errorMessages.get(fieldError.getField()).add(fieldError.getDefaultMessage());
	}

	private boolean canPassValidation(BindingResult result) {
		if (result.getFieldErrors().size() > 0) {
			return false;
		}
		return true;
	}

	public void saveUserData(SignUpForm signUpForm) {
		UserEntity user = this.setUserData(signUpForm);
		userRepository.saveAndFlush(user);
	}

	private UserEntity setUserData(SignUpForm signUpForm) {
		UserEntity user = new UserEntity();
		user.setName(signUpForm.getName());
		user.setEmail(signUpForm.getEmail());
		String encryptedPassword = encryptionService.encrypt(signUpForm.getPassword());
		user.setPassword(encryptedPassword);
		return user;
	}
}
