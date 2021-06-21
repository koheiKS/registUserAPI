package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.example.demo.annotation.Confirm;

// confirmとの一致を確認するバリデーター
public class ConfirmValidator implements ConstraintValidator<Confirm, Object> {

	private String field;

    private String confirmField;

    private String message;

    public void initialize(Confirm constraintAnnotation) {
        field = constraintAnnotation.field();
        confirmField = "confirm" + StringUtils.capitalize(field);
        message = constraintAnnotation.message();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        Object fieldValue = beanWrapper.getPropertyValue(field);
        Object confirmFieldValue = beanWrapper.getPropertyValue(confirmField);
        boolean isMatched = ObjectUtils.nullSafeEquals(fieldValue, confirmFieldValue);
        if (isMatched) {
            return true;
        } else {
        	context.disableDefaultConstraintViolation();
        	context.buildConstraintViolationWithTemplate(message).addPropertyNode(field).addConstraintViolation();
            return false;
        }
    }
}
