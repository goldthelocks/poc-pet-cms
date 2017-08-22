/**
 * 
 */
package com.poc.pet.cms.app.controller;

import org.springframework.http.HttpStatus;

/**
 * @author eotayde
 *
 */
public class CustomApiResponse {

	private String message;

	/**
	 * @param httpStatus
	 * @param message
	 */
	public CustomApiResponse(String message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
