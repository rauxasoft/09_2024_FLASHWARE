package com.sinensia.flashware.backend.business.services;

import java.util.List;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Cliente;

public interface ClienteServices {

	/**
	 * Si el id no es null lanza BusinessException
	 * 
	 * Crea un id de forma automática y correlativa
	 * 
	 */
	Long create(Cliente cliente) throws BusinessException;
	
	List<Cliente> getAll();
}
