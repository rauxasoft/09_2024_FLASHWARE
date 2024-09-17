package com.sinensia.flashware.backend.business.config;

public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;

	private final boolean problemaArgumentos;
	
	public BusinessException(String mensaje, boolean problemaArgumentos) {
		super(mensaje);
		this.problemaArgumentos = problemaArgumentos;
	}

	public boolean isProblemaArgumentos() {
		return problemaArgumentos;
	}

}
