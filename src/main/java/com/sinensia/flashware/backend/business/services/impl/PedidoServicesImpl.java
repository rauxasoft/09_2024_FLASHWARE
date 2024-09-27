package com.sinensia.flashware.backend.business.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Pedido;
import com.sinensia.flashware.backend.business.services.PedidoServices;
import com.sinensia.flashware.backend.integration.repositories.PedidoPLRepository;

@Service
public class PedidoServicesImpl implements PedidoServices {

	private final PedidoPLRepository pedidoPLRepository;
	
	public PedidoServicesImpl(PedidoPLRepository pedidoPLRepository) {
		this.pedidoPLRepository = pedidoPLRepository;
	}

	@Override
	public Long create(Pedido pedido) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pedido> read(Long numero) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Pedido pedido) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long numero) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> getBetweenDates(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> getByEstablecimiento(Long idEstablecimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumeroTotalPedidos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumeroTotalPedidosByEstablecimiento(Long idEstablecimiento) {
		// TODO Auto-generated method stub
		return 0;
	}

}
