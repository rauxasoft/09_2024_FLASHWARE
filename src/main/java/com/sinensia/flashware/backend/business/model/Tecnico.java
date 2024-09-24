package com.sinensia.flashware.backend.business.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TEC")
public class Tecnico extends Persona {
	private static final long serialVersionUID = 1L;

}
