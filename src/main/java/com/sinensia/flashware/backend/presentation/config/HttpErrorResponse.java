package com.sinensia.flashware.backend.presentation.config;

import java.io.Serializable;

public class HttpErrorResponse implements Serializable{
	private static final long serialVersionUID = 1L;

	private String error;
	
	public HttpErrorResponse(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

}
