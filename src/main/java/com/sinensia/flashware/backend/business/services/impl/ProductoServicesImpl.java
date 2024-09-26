package com.sinensia.flashware.backend.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Categoria;
import com.sinensia.flashware.backend.business.model.Producto;
import com.sinensia.flashware.backend.business.model.dtos.ProductoDTO1;
import com.sinensia.flashware.backend.business.model.dtos.ProductoDTO2;
import com.sinensia.flashware.backend.business.services.ProductoServices;
import com.sinensia.flashware.backend.integration.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
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
	@Transactional
	public void update(Producto producto) throws BusinessException {
		
		Long codigo = producto.getCodigo();
		
		boolean existe = productoRepository.existsById(codigo);
		
		if(!existe) {
			throw new BusinessException("El producto " + codigo + " no existe. No se puede actualizar.", true);
		}
		
		productoRepository.save(producto);
		
	}

	@Override
	@Transactional
	public void delete(Long codigo) throws BusinessException {
		
		boolean existe = productoRepository.existsById(codigo);
		
		if(!existe) {
			throw new BusinessException("El producto " + codigo + " no existe. No se puede actualizar", true);	
		}
		
		productoRepository.deleteById(codigo);
	}

	@Override
	public List<Producto> getAll() {		
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		return productoRepository.findByPrecioBetweenOrderByPrecioDesc(min, max);
	}

	@Override
	public List<Producto> getByCategoria(Categoria categoria) {
		return productoRepository.findByCategoria(categoria);
	}

	@Override
	public int getNumeroTotalProductos() {
		return (int) productoRepository.count();
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
		
		List<Object[]> resultados = productoRepository.findProductoDTO1();
		
		List<ProductoDTO1> productosDTO1 = new ArrayList<>();
		
		for(Object[] fila: resultados) {
			Long codigo = (Long) fila[0];
			String nombre = (String) fila[1];
			Double precio = (Double) fila[2];
			productosDTO1.add(new ProductoDTO1(codigo, nombre, precio));
		}
		
		return productosDTO1;
	}
	
	@Override
	public List<ProductoDTO2> getAllProductoDTO2(){
		return productoRepository.findProductoDTO2();
	}

}
