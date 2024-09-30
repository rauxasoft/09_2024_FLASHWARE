package com.sinensia.flashware.backend.business.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Pedido;
import com.sinensia.flashware.backend.business.services.PedidoServices;
import com.sinensia.flashware.backend.integration.model.PedidoPL;
import com.sinensia.flashware.backend.integration.repositories.PedidoPLRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoServicesImpl implements PedidoServices {

	private final PedidoPLRepository pedidoPLRepository;
	private final DozerBeanMapper mapper;
	
	public PedidoServicesImpl(PedidoPLRepository pedidoPLRepository, DozerBeanMapper mapper) {
		this.pedidoPLRepository = pedidoPLRepository;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public Long create(Pedido pedido) throws BusinessException {
		
		if(pedido.getNumero() != null) {
			throw new BusinessException("El código del pedido ha de ser NULL", true);
		}
		
		Long numero = System.currentTimeMillis();
		pedido.setNumero(numero);
		
		PedidoPL pedidoPL = mapper.map(pedido, PedidoPL.class);
		
		pedidoPLRepository.save(pedidoPL);
		
		return numero;
	}

	@Override
	public Optional<Pedido> read(Long numero) {
		return pedidoPLRepository.findById(numero).map(x -> mapper.map(x, Pedido.class));
	}

	@Override
	@Transactional
	public void update(Pedido pedido) throws BusinessException {

		Long numero = pedido.getNumero();
		
		boolean existe = pedidoPLRepository.existsById(numero);
		
		if(!existe) {
			throw new BusinessException("El pedido " + numero + " no existe. No se puede actualizar.", true);
		}
		
		pedidoPLRepository.save(mapper.map(pedido, PedidoPL.class));
		
	}

	@Override
	@Transactional
	public void delete(Long numero) throws BusinessException {

		boolean existe = pedidoPLRepository.existsById(numero);
		
		if(!existe) {
			throw new BusinessException("El pedido " + numero + " no existe. No se puede eliminar.", true);
		}
		
		pedidoPLRepository.deleteById(numero);
		
	}

	@Override
	public List<Pedido> getAll() {
		return convertListFromI2B(pedidoPLRepository.findAll());
	}

	@Override
	public List<Pedido> getBetweenDates(Date desde, Date hasta) {
		return convertListFromI2B(pedidoPLRepository.findByFechaHoraBetweenOrderByFechaHora(desde, hasta));
	}
		
	@Override
	public List<Pedido> getByEstablecimiento(Long idEstablecimiento) {
		return convertListFromI2B(pedidoPLRepository.findByEstablecimientoId(idEstablecimiento));
	}

	@Override
	public int getNumeroTotalPedidos() {
		return (int) pedidoPLRepository.count();
	}

	@Override
	public int getNumeroTotalPedidosByEstablecimiento(Long idEstablecimiento) {
		return (int) pedidoPLRepository.contarNumeroPedidosPorEstablecimiento(idEstablecimiento);
	}
	
	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************
		
	private List<Pedido> convertListFromI2B(List<PedidoPL> pedidosPL){
		return pedidosPL.stream().map(x -> mapper.map(x, Pedido.class)).toList();
	}

}
