package com.sinensia.flashware.backend.business.services;

import java.util.List;

import com.sinensia.flashware.backend.business.model.Tecnico;
import com.sinensia.flashware.backend.business.services.config.BusinessException;

public interface TecnicoServices {

	/**
	 * Si el id no es null lanza BusinessException
	 * 
	 * Crea un id de forma automática y correlativa
	 * 
	 */
	Long create(Tecnico tecnico) throws BusinessException;
	
	List<Tecnico> getAll();
	
}
