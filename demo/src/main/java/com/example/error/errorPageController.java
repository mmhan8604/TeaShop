package com.example.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.aop.loginException;

@ControllerAdvice
public class errorPageController {
	@ExceptionHandler(loginException.class)
	String loginError(loginException ex) {
		return "loginError";
	}

}
