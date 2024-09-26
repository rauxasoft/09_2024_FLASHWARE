package com.sinensia.flashware.backend.business.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Pedido;

public interface PedidoServices {

	/**
	 * Si el número no es null lanza BusinessException
	 * 
	 * Crea un número de forma automática y correlativa
	 * 
	 */
	Long create(Pedido pedido) throws BusinessException;								
	
	Optional<Pedido> read(Long numero);						
	
	/**
	 * Si el pedido no existe lanza BusinessException
	 * 
	 */
	void update(Pedido pedido) throws BusinessException;								
	
	/**
	 * Si el número no existe lanza BusinessException
	 * 
	 */
	void delete(Long numero) throws BusinessException;									
	
	List<Pedido> getAll();
	
	/**
	 * Incluye los extremos 
	 *
	 */
	List<Pedido> getBetweenDates(Date desde, Date hasta);
	
	List<Pedido> getByEstablecimiento(Long idEstablecimiento);
	
	int getNumeroTotalPedidos();
	
	int getNumeroTotalPedidosByEstablecimiento(Long idEstablecimiento);
}
