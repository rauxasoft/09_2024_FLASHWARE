package com.sinensia.flashware.backend.business.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Categoria;
import com.sinensia.flashware.backend.business.model.Producto;

public interface ProductoServices {

	/**
	 * Si el código no es null lanza BusinessException
	 * 
	 * Crea un codigo de forma automática y correlativa
	 * 
	 */
	Long create(Producto producto) throws BusinessException;								
	
	Optional<Producto> read(Long codigo);						
	
	/**
	 * Si el producto no existe lanza BusinessException
	 * 
	 */
	void update(Producto producto) throws BusinessException;								
	
	/**
	 * Si el codigo no existe lanza BusinessException
	 * 
	 */
	void delete(Long codigo) throws BusinessException;									
	
	List<Producto> getAll();
	
	/**
	 * Incluye los extremos 
	 *
	 */
	List<Producto> getBetweenPriceRange(double min, double max);
	
	List<Producto> getByCategoria(Categoria categoria);
	
	int getNumeroTotalProductos();
	
	int getNumeroTotalProductosByCategoria(Categoria categoria);
	
	/**
	 * Por ejemplo, para aumentar un 20% el porcentaje = 20.0
	 * 
	 */
	void incrementarPrecio(List<Producto> productos, double porcentaje);
	
	/**
	 * Por ejemplo, para aumentar un 20% el porcentaje = 20.0
	 * 
	 */
	void incrementarPrecio(Long[] idProductos, double porcentaje);
	
	Map<Categoria, Integer> getEstadisticaNumeroProductos();
	
	/**
	 * Si una categoria no tiene productos su valor será NULL
	 *
	 */
	Map<Categoria, Double> getEstadisticaPrecioMedioProductos();
	
}
