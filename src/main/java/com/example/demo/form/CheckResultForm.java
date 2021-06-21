package com.example.demo.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class CheckResultForm {

	private Map<String, List<String>> errorMessages = new HashMap<String, List<String>>();

	private boolean isOk;
}
