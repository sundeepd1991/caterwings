/**
 * 
 */
package com.caterwings.productdemo.exception;

/**
 * @author Sundeep D
 * 
 * This class handles runtime exceptions related to repository
 *
 */
public class RepositoryException extends RuntimeException {

	public static final long serialVersionUID = -6492084210808668195L;

	public RepositoryException() {
		super();

	}

	public RepositoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);

	}

	public RepositoryException(String message) {
		super(message);

	}

	public RepositoryException(Throwable cause) {
		super(cause);

	}

}
