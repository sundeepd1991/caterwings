/**
 * 
 */
package com.caterwings.productdemo.exception;

/**
 * @author Sundeep D
 * 
 * This class handles the runtime exceptions related to Product service
 *
 */
public class ProductServiceException extends RuntimeException {

	private static final long serialVersionUID = 5637163858757827552L;

	public ProductServiceException() {
		super();

	}

	public ProductServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ProductServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public ProductServiceException(String message) {
		super(message);

	}

	public ProductServiceException(Throwable cause) {
		super(cause);

	}

}
