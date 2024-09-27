package com.sinensia.flashware.backend.business.services.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Categoria;
import com.sinensia.flashware.backend.business.model.Producto;
import com.sinensia.flashware.backend.business.model.dtos.ProductoDTO1;
import com.sinensia.flashware.backend.business.model.dtos.ProductoDTO2;
import com.sinensia.flashware.backend.business.services.ProductoServices;
import com.sinensia.flashware.backend.integration.repositories.ProductoPLRepository;

@Service
public class ProductoServicesImpl implements ProductoServices{

	private final ProductoPLRepository productoPLRepository;
	
	public ProductoServicesImpl(ProductoPLRepository productoPLRepository) {
		this.productoPLRepository = productoPLRepository;
	}

	@Override
	public Long create(Producto producto) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Producto> read(Long codigo) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Producto producto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long codigo) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> getByCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumeroTotalProductos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumeroTotalProductosByCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void incrementarPrecio(List<Producto> productos, double porcentaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementarPrecio(Long[] idProductos, double porcentaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Categoria, Integer> getEstadisticaNumeroProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Categoria, Double> getEstadisticaPrecioMedioProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDTO1> getAllProductoDTO1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDTO2> getAllProductoDTO2() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
