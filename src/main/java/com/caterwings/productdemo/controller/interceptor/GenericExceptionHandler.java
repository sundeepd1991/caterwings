/**
 * 
 */
package com.caterwings.productdemo.controller.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.caterwings.productdemo.exception.RepositoryException;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Sundeep D
 * 
 * This Class handles all the generic exceptions that could occur during run time
 *
 */
@ControllerAdvice
@ApiIgnore
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = RepositoryException.class)
	public String handleRepositoryException() {
		return "Unable to process request at repository level.";
	}

	@ExceptionHandler(value = Exception.class)
	public String handleAllExceptions(Exception ex) {
		return String.format("Unable to process request.{}", ex.getMessage());
	}
}
