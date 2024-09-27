package com.sinensia.flashware.backend.integration.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CLI")
public class ClientePL extends PersonaPL {
	private static final long serialVersionUID = 1L;

}
