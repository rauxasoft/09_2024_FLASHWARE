package com.sinensia.flashware.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.flashware.backend.business.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
