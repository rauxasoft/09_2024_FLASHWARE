package com.sinensia.flashware.backend.business.services.impl_BK;

public class ClienteServicesImpl{

	/*
	private final ClientePLRepository clienteRepository;
	
	public ClienteServicesImpl(ClientePLRepository clienteRepository) {
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
	
*/
}
