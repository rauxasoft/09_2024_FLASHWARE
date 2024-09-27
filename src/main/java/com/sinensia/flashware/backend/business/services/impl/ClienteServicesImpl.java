package com.sinensia.flashware.backend.business.services.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Cliente;
import com.sinensia.flashware.backend.business.services.ClienteServices;
import com.sinensia.flashware.backend.integration.model.ClientePL;
import com.sinensia.flashware.backend.integration.repositories.ClientePLRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServicesImpl implements ClienteServices{

	private final ClientePLRepository clientePLRepository;
	private final DozerBeanMapper mapper;
	
	public ClienteServicesImpl(ClientePLRepository clientePLRepository, DozerBeanMapper mapper) {
		this.clientePLRepository = clientePLRepository;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public Long create(Cliente cliente) throws BusinessException {
		
		if(cliente.getId() != null) {
			throw new BusinessException("El ID del cliente ha de ser NULL", true);
		}
		
		Long id = System.currentTimeMillis();
		cliente.setId(id);
		
		ClientePL clientePL = mapper.map(cliente, ClientePL.class);
		
		clientePLRepository.save(clientePL);
		
		return id;
	}

	@Override
	public List<Cliente> getAll() {
		
		List<ClientePL> clientesPL = clientePLRepository.findAll();
	
		return clientesPL.stream().map(x -> mapper.map(x, Cliente.class)).toList();
	}
	
	

}
