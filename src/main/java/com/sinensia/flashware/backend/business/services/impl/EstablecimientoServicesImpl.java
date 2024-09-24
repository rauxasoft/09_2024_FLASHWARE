package com.sinensia.flashware.backend.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Establecimiento;
import com.sinensia.flashware.backend.business.services.EstablecimientoServices;
import com.sinensia.flashware.backend.integration.repositories.EstablecimientoRepository;

@Service
@Primary
public class EstablecimientoServicesImpl implements EstablecimientoServices{

	@Autowired
	private EstablecimientoRepository establecimientoRepository;
	
	@Override
	public Long create(Establecimiento establecimiento) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Establecimiento> read(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Establecimiento establecimiento) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Establecimiento> getAll() {
		return establecimientoRepository.findAll();
	}

	@Override
	public List<Establecimiento> getByNombreLike(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Establecimiento> getByPoblacionLike(String poblacion) {
		// TODO Auto-generated method stub
		return null;
	}

}
