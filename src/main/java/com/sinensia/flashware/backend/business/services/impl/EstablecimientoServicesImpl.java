package com.sinensia.flashware.backend.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Establecimiento;
import com.sinensia.flashware.backend.business.services.EstablecimientoServices;
import com.sinensia.flashware.backend.integration.repositories.EstablecimientoPLRepository;

@Service
public class EstablecimientoServicesImpl implements EstablecimientoServices{

	private final EstablecimientoPLRepository establecimientoPLRepository;
	
	public EstablecimientoServicesImpl(EstablecimientoPLRepository establecimientoPLRepository) {
		this.establecimientoPLRepository = establecimientoPLRepository;
	}

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
		// TODO Auto-generated method stub
		return null;
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
