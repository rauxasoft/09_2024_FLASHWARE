package com.sinensia.flashware.backend.business.services;

import java.util.List;

import com.sinensia.flashware.backend.business.model.Tecnico;

public interface TecnicoServices {

	/**
	 * Si el id no es null lanza IllegalStateException
	 * 
	 * Crea un id de forma automática y correlativa
	 * 
	 */
	Long create(Tecnico tecnico);
	
	List<Tecnico> getAll();
	
}
