package com.sinensia.flashware.backend.business.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CLI")
public class Cliente extends Persona {
	private static final long serialVersionUID = 1L;

}
