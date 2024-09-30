package com.sinensia.flashware.backend.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Establecimiento;
import com.sinensia.flashware.backend.business.services.EstablecimientoServices;
import com.sinensia.flashware.backend.integration.model.EstablecimientoPL;
import com.sinensia.flashware.backend.integration.repositories.EstablecimientoPLRepository;

import jakarta.transaction.Transactional;

@Service
public class EstablecimientoServicesImpl implements EstablecimientoServices{

	private final EstablecimientoPLRepository establecimientoPLRepository;
	private final DozerBeanMapper mapper;
	
	public EstablecimientoServicesImpl(EstablecimientoPLRepository establecimientoPLRepository, DozerBeanMapper mapper) {
		this.establecimientoPLRepository = establecimientoPLRepository;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public Long create(Establecimiento establecimiento) throws BusinessException {
		
		if(establecimiento.getId() != null) {
			throw new BusinessException("El ID del establecimiento ha de ser NULL", true);
		}
		
		Long id = System.currentTimeMillis();
		establecimiento.setId(id);
		
		EstablecimientoPL establecimientoPL = mapper.map(establecimiento, EstablecimientoPL.class);
		
		establecimientoPLRepository.save(establecimientoPL);
		
		return id;
	}

	@Override
	public Optional<Establecimiento> read(Long id) {
		return establecimientoPLRepository.findById(id).map(x -> mapper.map(x, Establecimiento.class));
	}

	@Override
	@Transactional
	public void update(Establecimiento establecimiento) throws BusinessException {

		Long id = establecimiento.getId();
		
		boolean existe = establecimientoPLRepository.existsById(id);
		
		if(!existe) {
			throw new BusinessException("El establecimiento " + id + " no existe. No se puede actualizar.", true);
		}
		
		establecimientoPLRepository.save(mapper.map(establecimiento, EstablecimientoPL.class));
		
	}

	@Override
	public List<Establecimiento> getAll() {
		return convertListFromI2B(establecimientoPLRepository.findAll());
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
	
	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************
		
	private List<Establecimiento> convertListFromI2B(List<EstablecimientoPL> establecimientosPL){
		return establecimientosPL.stream().map(x -> mapper.map(x, Establecimiento.class)).toList();
	}

}
