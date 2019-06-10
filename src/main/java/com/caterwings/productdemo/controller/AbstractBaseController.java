/**
 * 
 */
package com.caterwings.productdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Sundeep D
 *
 */
public class AbstractBaseController {

	public <T> ResponseEntity<T> response(T t, HttpStatus httpStatus) {
		return new ResponseEntity<T>(t, httpStatus);
	}

}
