package com.sinensia.flashware.backend.integration.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.flashware.backend.business.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByEstablecimientoId(Long id);
	
	List<Pedido> findByFechaHoraBetweenOrderByFechaHora(Date desde, Date hasta);
	
	@Query("SELECT COUNT(p) FROM Pedido p WHERE p.establecimiento.id = :idEstablecimiento")
	long contarNumeroPedidosPorEstablecimiento(Long idEstablecimiento);
	
}
