package com.sinensia.flashware.backend.business.services.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Categoria;
import com.sinensia.flashware.backend.business.model.Producto;
import com.sinensia.flashware.backend.business.services.ProductoServices;
import com.sinensia.flashware.backend.integration.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Primary
public class ProductoServicesImpl implements ProductoServices{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	@Transactional
	public Long create(Producto producto) throws BusinessException {
		
		if(producto.getCodigo() != null) {
			throw new BusinessException("El código del producto ha de ser NULL", true);
		}
		
		Long codigo = System.currentTimeMillis();
		producto.setCodigo(codigo);
		
		productoRepository.save(producto);
		
		return codigo;
	}

	@Override
	public Optional<Producto> read(Long codigo) {
		return productoRepository.findById(codigo);
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
		return productoRepository.findAll();
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

}
