package com.sinensia.flashware.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.flashware.backend.business.model.Establecimiento;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {

	@Query("SELECT e FROM Establecimiento e WHERE TRANSLATE(UPPER(e.nombre), 'ÁÉÍÓÚÀÈÌÒÙ', 'AEIOUAEIOU') LIKE UPPER(CONCAT('%', :nombre, '%'))")
	List<Establecimiento> findByNombreLikeIgnoreCase(String nombre);
}
