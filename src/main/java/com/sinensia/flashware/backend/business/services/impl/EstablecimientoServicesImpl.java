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

import jakarta.transaction.Transactional;

@Service
@Primary
public class EstablecimientoServicesImpl implements EstablecimientoServices{

	@Autowired
	private EstablecimientoRepository establecimientoRepository;
	
	@Override
	@Transactional
	public Long create(Establecimiento establecimiento) throws BusinessException {
		
		if(establecimiento.getId() != null) {
			throw new BusinessException("El ID del establecimiento ha de ser NULL", true);
		}
		
		Long id = System.currentTimeMillis();
		establecimiento.setId(id);
		
		establecimientoRepository.save(establecimiento);
		
		return id;
	}

	@Override
	public Optional<Establecimiento> read(Long id) {
		return establecimientoRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Establecimiento establecimiento) throws BusinessException {

		Long id = establecimiento.getId();
		
		boolean existe = establecimientoRepository.existsById(id);
		
		if(!existe) {
			throw new BusinessException("El establecimiento " + id + " no existe. No se puede actualizar.", true);
		}
		
		establecimientoRepository.save(establecimiento);
		
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
