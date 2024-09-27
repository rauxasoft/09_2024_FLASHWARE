package com.sinensia.flashware.backend.integration.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.flashware.backend.integration.model.PedidoPL;

public interface PedidoPLRepository extends JpaRepository<PedidoPL, Long> {

	List<PedidoPL> findByEstablecimientoId(Long id);
	
	List<PedidoPL> findByFechaHoraBetweenOrderByFechaHora(Date desde, Date hasta);
	
	@Query("SELECT COUNT(p) FROM PedidoPL p WHERE p.establecimiento.id = :idEstablecimiento")
	long contarNumeroPedidosPorEstablecimiento(Long idEstablecimiento);

}
