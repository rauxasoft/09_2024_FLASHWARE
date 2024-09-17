package com.sinensia.flashware.backend.business.services;

import java.util.List;
import java.util.Optional;

import com.sinensia.flashware.backend.business.model.Establecimiento;

public interface EstablecimientoServices {
	
	/**
	 * Si el ID no es null lanza IllegalStateException
	 * 
	 * Crea un ID de forma automática y correlativa
	 * 
	 */
	Long create(Establecimiento establecimiento);
	
	Optional<Establecimiento> read(Long id);						// R
	
	/**
	 * Si el establecimiento no existe lanza IllegalStateException
	 * 
	 */
	void update(Establecimiento establecimiento);
	
	List<Establecimiento> getAll();
	
	/**
	 * 
	 * La busqueda es ignore-case y ignore-accent
	 * 
	 */
	List<Establecimiento> getByNombreLike(String nombre);
	
	/**
	 * 
	 * La busqueda es ignore-case y ignore-accent
	 * 
	 */
	List<Establecimiento> getByPoblacionLike(String poblacion);
	
}
