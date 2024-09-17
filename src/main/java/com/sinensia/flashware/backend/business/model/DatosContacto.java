package com.sinensia.flashware.backend.business.model;

import java.io.Serializable;

public class DatosContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String telefonoMovil;
	private String telefonoFijo;
	private String email;
	
	public DatosContacto() {
		
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
