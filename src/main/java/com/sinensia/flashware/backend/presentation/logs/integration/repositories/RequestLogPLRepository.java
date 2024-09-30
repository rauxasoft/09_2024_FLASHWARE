package com.sinensia.flashware.backend.presentation.logs.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinensia.flashware.backend.presentation.logs.model.RequestLogPL;

public interface RequestLogPLRepository extends JpaRepository<RequestLogPL, Long>{

}
