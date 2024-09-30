package com.sinensia.flashware.backend.integration.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class DatosContactoPL implements Serializable {
	private static final long serialVersionUID = 1L;

	private String telefonoMovil;
	private String telefonoFijo;
	private String email;
	
	public DatosContactoPL() {
		
	}

	public String getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(String telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public String getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}