package com.sinensia.flashware.backend.business.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Categoria;
import com.sinensia.flashware.backend.business.model.Producto;
import com.sinensia.flashware.backend.business.services.ProductoServices;

@Service
public class ProductoServicesImpl implements ProductoServices{

	private final TreeMap<Long, Producto> PRODUCTOS_DB = new TreeMap<>();
	
	public ProductoServicesImpl() {
		initObjects();
	}
	
	@Override
	public Long create(Producto producto) throws BusinessException {
		
		if(producto.getCodigo() != null) {
			throw new BusinessException("El código del producto ha de ser NULL", true);
		}

		producto.setCodigo(PRODUCTOS_DB.size() > 0 ? PRODUCTOS_DB.lastKey() +1 : 1);
		
		PRODUCTOS_DB.put(producto.getCodigo(), producto);
		
		return producto.getCodigo();
	}

	@Override
	public Optional<Producto> read(Long codigo) {
		return Optional.ofNullable(PRODUCTOS_DB.get(codigo));
	}

	@Override
	public void update(Producto producto) throws BusinessException {
		
		Long codigo = producto.getCodigo();
		
		if(!PRODUCTOS_DB.containsKey(codigo)) {
			throw new BusinessException("El producto " + codigo + " no existe. No se puede actualizar", true);
		}
		
		PRODUCTOS_DB.replace(codigo, producto);
		
	}

	@Override
	public void delete(Long codigo) throws BusinessException {
		
		if(!PRODUCTOS_DB.containsKey(codigo)) {
			throw new BusinessException("El producto " + codigo + " no existe. No se puede eliminar", true);
		}
		
		PRODUCTOS_DB.remove(codigo);
		
	}

	@Override
	public List<Producto> getAll() {
		return new ArrayList<>(PRODUCTOS_DB.values());
	}
		
	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		return PRODUCTOS_DB.values().stream()
				.filter(x -> x.getPrecio() >= min && x.getPrecio() <= max)
				.toList();	
	}

	@Override
	public List<Producto> getByCategoria(Categoria categoria) {

		return PRODUCTOS_DB.values().stream()
				.filter(x -> x.getCategoria() == categoria)
				.toList();
	}

	@Override
	public int getNumeroTotalProductos() {
		return PRODUCTOS_DB.size();
	}

	@Override
	public int getNumeroTotalProductosByCategoria(Categoria categoria) {
	
		return (int) PRODUCTOS_DB.values().stream()
				.filter(x -> x.getCategoria() == categoria)
				.count();
	}

	@Override
	public void incrementarPrecio(List<Producto> productos, double porcentaje) {
		
		productos.stream().forEach(x -> {
			
			Producto producto = PRODUCTOS_DB.get(x.getCodigo());
			
			double precio = producto.getPrecio();
	
			producto.setPrecio(precio + (precio * porcentaje / 100));
			
		});	
	}

	@Override
	public void incrementarPrecio(Long[] idProductos, double porcentaje) {
		
		Arrays.stream(idProductos).forEach(x -> {
			
			Producto producto = PRODUCTOS_DB.get(x);
			
			double precio = producto.getPrecio();
	
			producto.setPrecio(precio + (precio * porcentaje / 100));
			
		});	
	}

	@Override
	public Map<Categoria, Integer> getEstadisticaNumeroProductos() {
	
		Map<Categoria, Integer> estadistica = new HashMap<>();
		
		for(Categoria categoria: Categoria.values()) {
			estadistica.put(categoria, 0);
		}
		
		for(Producto producto: PRODUCTOS_DB.values()) {
			
			Categoria categoria = producto.getCategoria();
			Integer numeroProductos = estadistica.get(categoria);
			
			estadistica.replace(categoria, ++numeroProductos);
		}
		
		return estadistica;
	}
	
	@Override
	public Map<Categoria, Double> getEstadisticaPrecioMedioProductos() {

		Map<Categoria, Double> preciosAcumuladosMap = new HashMap<>();
		Map<Categoria, Integer> numeroProductosMap = new HashMap<>();
		Map<Categoria, Double> estadistica = new HashMap<>();
		
		for(Categoria categoria: Categoria.values()) {
			preciosAcumuladosMap.put(categoria, null);
			numeroProductosMap.put(categoria, 0);
		}
		
		for(Producto producto: PRODUCTOS_DB.values()) {
			
			Categoria categoria = producto.getCategoria();
	
			numeroProductosMap.replace(categoria, numeroProductosMap.get(categoria) + 1);
			Double precioAcumulado = preciosAcumuladosMap.get(categoria);
			preciosAcumuladosMap.replace(categoria, (precioAcumulado == null) ? producto.getPrecio() : precioAcumulado + producto.getPrecio());
			
		}
		
		for(Categoria categoria: Categoria.values()) {
			
			int numeroProductos = numeroProductosMap.get(categoria);
			Double precioAcumulado = preciosAcumuladosMap.get(categoria);
			
			estadistica.put(categoria, (numeroProductos == 0) ? null : precioAcumulado / numeroProductos);
			
		}
		
		return estadistica;
	}
	
	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************
	
	private void initObjects() {
		
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		Producto p3 = new Producto();
		Producto p4 = new Producto();
		Producto p5= new Producto();
		Producto p6 = new Producto();
		Producto p7 = new Producto();
		
		Date fecha1 = null;
		Date fecha2 = null;
		Date fecha3 = null;
		Date fecha4 = null;
		Date fecha5 = null;
		Date fecha6 = null;
		Date fecha7 = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			fecha1 = sdf.parse("01/11/2021");
			fecha2 = sdf.parse("05/11/2021");
			fecha3 = sdf.parse("05/11/2021");
			fecha4 = sdf.parse("06/11/2021");
			fecha5 = sdf.parse("08/11/2021");
			fecha6 = sdf.parse("08/11/2021");
			fecha7 = sdf.parse("11/11/2021");
			
		} catch (ParseException e) {
			
		}
		
		p1.setCodigo(100L);
		p1.setNombre("Alfombrilla Mouse R.Madrid");
		p1.setDescripcion("Fantástica alfombrilla...");
		p1.setCategoria(Categoria.CONSUMIBLE);
		p1.setPrecio(2.0);
		p1.setFechaAlta(fecha1);
		p1.setDescatalogado(true);
		
		p2.setCodigo(101L);
		p2.setNombre("Alfombrilla Mouse F.C.Barcelona");
		p2.setDescripcion("Fantástica alfombrilla...");
		p2.setCategoria(Categoria.CONSUMIBLE);
		p2.setPrecio(27.0);
		p2.setFechaAlta(fecha2);
		p2.setDescatalogado(false);
		
		p3.setCodigo(102L);
		p3.setNombre("Ordenador Epson D40");
		p3.setDescripcion("Fantástico ordenador...");
		p3.setCategoria(Categoria.HARDWARE);
		p3.setPrecio(560.0);
		p3.setFechaAlta(fecha3);
		p3.setDescatalogado(false);
		
		p4.setCodigo(103L);
		p4.setNombre("ContaNerd Deluxe");
		p4.setDescripcion("Fantástico programa de contabilidad...");
		p4.setCategoria(Categoria.SOFTWARE);
		p4.setPrecio(44.0);
		p4.setFechaAlta(fecha4);
		p4.setDescatalogado(true);
		
		p5.setCodigo(104L);
		p5.setNombre("Impresora Pluxton F14");
		p5.setDescripcion("Fantástic impresora...");
		p5.setCategoria(Categoria.HARDWARE);
		p5.setPrecio(140.0);
		p5.setFechaAlta(fecha5);
		p5.setDescatalogado(false);
		
		p6.setCodigo(105L);
		p6.setNombre("Cartucho impresora Pluxton Negro 2R");
		p6.setDescripcion("Fantástico cartucho...");
		p6.setCategoria(Categoria.CONSUMIBLE);
		p6.setPrecio(17.0);
		p6.setFechaAlta(fecha6);
		p6.setDescatalogado(false);
		
		p7.setCodigo(106L);
		p7.setNombre("Antivirus Caarsperky");
		p7.setDescripcion("Fantástico antivirus...");
		p7.setCategoria(Categoria.SOFTWARE);
		p7.setPrecio(18.0);
		p7.setFechaAlta(fecha7);
		p7.setDescatalogado(false);
		
		PRODUCTOS_DB.put(p1.getCodigo(), p1);
		PRODUCTOS_DB.put(p2.getCodigo(), p2);
		PRODUCTOS_DB.put(p3.getCodigo(), p3);
		PRODUCTOS_DB.put(p4.getCodigo(), p4);
		PRODUCTOS_DB.put(p5.getCodigo(), p5);
		PRODUCTOS_DB.put(p6.getCodigo(), p6);
		PRODUCTOS_DB.put(p7.getCodigo(), p7);
		
	}
	
}
