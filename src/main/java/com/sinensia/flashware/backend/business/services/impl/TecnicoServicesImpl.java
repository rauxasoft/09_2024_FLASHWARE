package com.sinensia.flashware.backend.business.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Tecnico;
import com.sinensia.flashware.backend.business.services.TecnicoServices;
import com.sinensia.flashware.backend.integration.repositories.TecnicoRepository;

import jakarta.transaction.Transactional;

@Service
public class TecnicoServicesImpl implements TecnicoServices{

	private final TecnicoRepository tecnicoRepository;
	
	public TecnicoServicesImpl(TecnicoRepository tecnicoRepository) {
		this.tecnicoRepository = tecnicoRepository;
	}
	
	@Override
	@Transactional
	public Long create(Tecnico tecnico) throws BusinessException {
		
		if(tecnico.getId() != null) {
			throw new BusinessException("El ID del técnico ha de ser NULL", true);
		}
		
		Long id = System.currentTimeMillis();
		tecnico.setId(id);
		
		tecnicoRepository.save(tecnico);
		
		return id;
		
	}

	@Override
	public List<Tecnico> getAll() {
		return tecnicoRepository.findAll();
	}

}
