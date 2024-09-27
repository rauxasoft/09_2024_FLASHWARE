package com.sinensia.flashware.backend.business.services.impl_BK;

public class PedidoServicesImpl {

	/*
	private final PedidoPLRepository pedidoRepository;
	
	public PedidoServicesImpl(PedidoPLRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	@Override
	@Transactional
	public Long create(Pedido pedido) throws BusinessException {
		
		if(pedido.getNumero() != null) {
			throw new BusinessException("El código del pedido ha de ser NULL", true);
		}
		
		Long numero = System.currentTimeMillis();
		pedido.setNumero(numero);
		
		pedidoRepository.save(pedido);
		
		return numero;
	}

	@Override
	public Optional<Pedido> read(Long numero) {
		return pedidoRepository.findById(numero);
	}

	@Override
	@Transactional
	public void update(Pedido pedido) throws BusinessException {
		
		Long numero = pedido.getNumero();
		
		boolean existe = pedidoRepository.existsById(numero);
		
		if(!existe) {
			throw new BusinessException("El pedido " + numero + " no existe. No se puede actualizar.", true);
		}
		
		pedidoRepository.save(pedido);
		
	}

	@Override
	@Transactional
	public void delete(Long numero) throws BusinessException {
		boolean existe = pedidoRepository.existsById(numero);
		
		if(!existe) {
			throw new BusinessException("El pedido " + numero + " no existe. No se puede eliminar.", true);
		}
		
		pedidoRepository.deleteById(numero);
	
	}

	@Override
	public List<Pedido> getAll() {
		return pedidoRepository.findAll();
	}

	@Override
	public List<Pedido> getBetweenDates(Date desde, Date hasta) {
		return pedidoRepository.findByFechaHoraBetweenOrderByFechaHora(desde, hasta);
	}

	@Override
	public List<Pedido> getByEstablecimiento(Long idEstablecimiento) {
		return pedidoRepository.findByEstablecimientoId(idEstablecimiento);
	}

	@Override
	public int getNumeroTotalPedidos() {
		return (int) pedidoRepository.count();
	}

	@Override
	public int getNumeroTotalPedidosByEstablecimiento(Long idEstablecimiento) {
		return (int) pedidoRepository.contarNumeroPedidosPorEstablecimiento(idEstablecimiento);
	}

*/
}
