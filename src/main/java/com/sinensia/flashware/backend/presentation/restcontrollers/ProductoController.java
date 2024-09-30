package com.sinensia.flashware.backend.presentation.restcontrollers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Producto;
import com.sinensia.flashware.backend.business.model.dtos.ProductoDTO1;
import com.sinensia.flashware.backend.business.model.dtos.ProductoDTO2;
import com.sinensia.flashware.backend.business.services.ProductoServices;
import com.sinensia.flashware.backend.presentation.config.PresentationException;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/{codigo}")
	public Producto getByCodigo(@PathVariable Long codigo) {
		
		Optional<Producto> optional = productoServices.read(codigo);
		
		if(optional.isEmpty()) {
			throw new PresentationException("No existe el producto " +  codigo, HttpStatus.NOT_FOUND);
		}
		
		return optional.get();
		
	}
	
	@GetMapping
	public List<Producto> getProductos(@RequestParam(required = false) Double min, 
									   @RequestParam(required = false) Double max){
		
		List<Producto> productos = null;
		
		if(min != null && max != null) {
			productos = productoServices.getBetweenPriceRange(min, max);
		} else {
			productos = productoServices.getAll();
		}
		
		return productos;
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto producto, UriComponentsBuilder ucb) throws BusinessException{
		
		Long codigo = productoServices.create(producto);
		
		URI uri = ucb.path("/productos/{codigo}").build(codigo); // http://localhost:8080/productos/89333

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Producto producto, @PathVariable Long codigo) throws BusinessException {
		producto.setCodigo(codigo);
		productoServices.update(producto);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codigo) throws BusinessException {
		productoServices.delete(codigo);
	}
	
	// ************************************************************************
	//
	// DTOs
	//
	// ************************************************************************
	
	@GetMapping("/productoDTO1")
	public List<ProductoDTO1> getAllProductoDTO1(){
		return productoServices.getAllProductoDTO1();
	}
	
	@GetMapping("/productoDTO2")
	public List<ProductoDTO2> getAllProductoDTO2(){
		return productoServices.getAllProductoDTO2();
	}
	
}
