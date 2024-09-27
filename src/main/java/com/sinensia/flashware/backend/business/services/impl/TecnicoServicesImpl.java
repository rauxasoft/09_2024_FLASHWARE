package com.sinensia.flashware.backend.business.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Tecnico;
import com.sinensia.flashware.backend.business.services.TecnicoServices;
import com.sinensia.flashware.backend.integration.repositories.TecnicoPLRepository;

@Service
public class TecnicoServicesImpl implements TecnicoServices{

	private final TecnicoPLRepository tecnicoPLRepository;
	
	public TecnicoServicesImpl(TecnicoPLRepository tecnicoPLRepository) {
		this.tecnicoPLRepository = tecnicoPLRepository;
	}

	@Override
	public Long create(Tecnico tecnico) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tecnico> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
