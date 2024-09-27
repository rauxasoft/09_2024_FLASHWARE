package com.sinensia.flashware.backend.business.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Categoria;
import com.sinensia.flashware.backend.business.model.Producto;
import com.sinensia.flashware.backend.business.model.dtos.ProductoDTO1;
import com.sinensia.flashware.backend.business.model.dtos.ProductoDTO2;
import com.sinensia.flashware.backend.business.services.ProductoServices;
import com.sinensia.flashware.backend.integration.model.CategoriaPL;
import com.sinensia.flashware.backend.integration.model.ProductoPL;
import com.sinensia.flashware.backend.integration.repositories.ProductoPLRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoServicesImpl implements ProductoServices{

	private final ProductoPLRepository productoPLRepository;
	private final DozerBeanMapper mapper;
	
	public ProductoServicesImpl(ProductoPLRepository productoPLRepository, DozerBeanMapper mapper) {
		this.productoPLRepository = productoPLRepository;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public Long create(Producto producto) throws BusinessException {
		
		if(producto.getCodigo() != null) {
			throw new BusinessException("El código del producto ha de ser NULL", true);
		}
		
		Long codigo = System.currentTimeMillis();
		producto.setCodigo(codigo);
		
		productoPLRepository.save(mapper.map(producto, ProductoPL.class));
		
		return codigo;
	}

	@Override
	public Optional<Producto> read(Long codigo) {
		return productoPLRepository.findById(codigo).map(x -> mapper.map(x, Producto.class));
	}

	@Override
	@Transactional
	public void update(Producto producto) throws BusinessException {

		Long codigo = producto.getCodigo();
		
		boolean existe = productoPLRepository.existsById(codigo);
		
		if(!existe) {
			throw new BusinessException("El producto " + codigo + " no existe. No se puede actualizar.", true);
		}
		
		productoPLRepository.save(mapper.map(producto, ProductoPL.class));
		
	}
	
	@Override
	@Transactional
	public void delete(Long codigo) throws BusinessException {

		boolean existe = productoPLRepository.existsById(codigo);
		
		if(!existe) {
			throw new BusinessException("El producto " + codigo + " no existe. No se puede actualizar", true);	
		}
		
		productoPLRepository.deleteById(codigo);
		
	}

	@Override
	public List<Producto> getAll() {
		return convertListFromI2B(productoPLRepository.findAll());
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		return convertListFromI2B(productoPLRepository.findByPrecioBetweenOrderByPrecioDesc(min, max));
	}

	@Override
	public List<Producto> getByCategoria(Categoria categoria) {
		return convertListFromI2B(productoPLRepository.findByCategoria(CategoriaPL.valueOf(categoria.name())));
	}

	@Override
	public int getNumeroTotalProductos() {
		return (int) productoPLRepository.count();
	}

	@Override
	public int getNumeroTotalProductosByCategoria(Categoria categoria) {
		return (int) productoPLRepository.contarNumeroProductosPorCategoria(mapper.map(categoria, CategoriaPL.class));
	}

	@Override
	@Transactional
	public void incrementarPrecio(List<Producto> productos, double porcentaje) {
		
		List<ProductoPL> productosPL = productos.stream().map(x -> mapper.map(x, ProductoPL.class)).toList();
		
		productoPLRepository.incrementarPrecio(productosPL, porcentaje);
		
	}

	@Override
	@Transactional
	public void incrementarPrecio(Long[] idProductos, double porcentaje) {
		productoPLRepository.incrementarPrecio(idProductos, porcentaje);
	}

	@Override
	public Map<Categoria, Integer> getEstadisticaNumeroProductos() {
		
		List<Object[]> resultados = productoPLRepository.getEstadisticaNumeroProductos();
		
		Map<Categoria, Integer> estadistica = new HashMap<>();
		
		Arrays.stream(Categoria.values()).forEach(x -> estadistica.put(x, 0));
		
		resultados.stream().forEach(x -> {
			
			CategoriaPL categoriaPL = (CategoriaPL) x[0];
			
			Categoria categoria = Categoria.valueOf(categoriaPL.name());
			estadistica.replace(categoria, ((Long) x[1]).intValue());
			
		});
		
		return estadistica;
	}

	@Override
	public Map<Categoria, Double> getEstadisticaPrecioMedioProductos() {
		
		List<Object[]> resultados = productoPLRepository.getEstadisticaPreciosmedios();
		
		Map<Categoria, Double> estadistica = new HashMap<>();
		
		Arrays.stream(Categoria.values()).forEach(x -> estadistica.put(x, null));
		
		resultados.stream().forEach(x -> {
			
			CategoriaPL categoriaPL = (CategoriaPL) x[0];
			
			Categoria categoria = Categoria.valueOf(categoriaPL.name());
			estadistica.replace(categoria, (Double) x[1]);
			
		});
		
		return estadistica;
	}

	@Override
	public List<ProductoDTO1> getAllProductoDTO1() {

		List<Object[]> resultados = productoPLRepository.findProductoDTO1();
		
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
	public List<ProductoDTO2> getAllProductoDTO2() {
		return productoPLRepository.findProductoDTO2();
	}
	
	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************
	
	private List<Producto> convertListFromI2B(List<ProductoPL> productosPL){
		return productosPL.stream().map(x -> mapper.map(x, Producto.class)).toList();
	}

}
