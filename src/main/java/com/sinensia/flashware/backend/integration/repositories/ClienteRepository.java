package com.sinensia.flashware.backend.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.flashware.backend.business.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
