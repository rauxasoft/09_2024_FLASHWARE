package com.sinensia.flashware.backend.business.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Cliente;
import com.sinensia.flashware.backend.business.services.ClienteServices;
import com.sinensia.flashware.backend.integration.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicesImpl implements ClienteServices{

	private final ClienteRepository clienteRepository;
	
	public ClienteServicesImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Override
	@Transactional
	public Long create(Cliente cliente) throws BusinessException {
		
		if(cliente.getId() != null) {
			throw new BusinessException("El ID del cliente ha de ser NULL", true);
		}
		
		Long id = System.currentTimeMillis();
		cliente.setId(id);
		
		clienteRepository.save(cliente);
		
		return id;
	}

	@Override
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}

}
