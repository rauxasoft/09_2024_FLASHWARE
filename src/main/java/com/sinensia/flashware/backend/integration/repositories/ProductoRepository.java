package com.sinensia.flashware.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.flashware.backend.business.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
