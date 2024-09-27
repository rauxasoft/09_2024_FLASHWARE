package com.sinensia.flashware.backend.business.services.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Tecnico;
import com.sinensia.flashware.backend.business.services.TecnicoServices;
import com.sinensia.flashware.backend.integration.model.TecnicoPL;
import com.sinensia.flashware.backend.integration.repositories.TecnicoPLRepository;

import jakarta.transaction.Transactional;

@Service
public class TecnicoServicesImpl implements TecnicoServices{

	private final TecnicoPLRepository tecnicoPLRepository;
	private final DozerBeanMapper mapper;
	
	public TecnicoServicesImpl(TecnicoPLRepository tecnicoPLRepository, DozerBeanMapper mapper) {
		this.tecnicoPLRepository = tecnicoPLRepository;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public Long create(Tecnico tecnico) throws BusinessException {
		
		if(tecnico.getId() != null) {
			throw new BusinessException("El ID del tecnico ha de ser NULL", true);
		}
		
		Long id = System.currentTimeMillis();
		tecnico.setId(id);
		
		TecnicoPL tecnicoPL = mapper.map(tecnico, TecnicoPL.class);
		
		tecnicoPLRepository.save(tecnicoPL);
		
		return id;
	}

	@Override
	public List<Tecnico> getAll() {
		
		List<TecnicoPL> tecnicosPL = tecnicoPLRepository.findAll();
		
		return tecnicosPL.stream().map(x -> mapper.map(x, Tecnico.class)).toList();
	}
	
}
