package com.sinensia.flashware.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.flashware.backend.integration.model.EstablecimientoPL;

public interface EstablecimientoPLRepository extends JpaRepository<EstablecimientoPL, Long> {

	@Query("SELECT e FROM EstablecimientoPL e WHERE TRANSLATE(UPPER(e.nombre), 'ÁÉÍÓÚÀÈÌÒÙ', 'AEIOUAEIOU') LIKE UPPER(CONCAT('%', :nombre, '%'))")
	List<EstablecimientoPL> findByNombreLikeIgnoreCase(String nombre);
}
