package com.sinensia.flashware.backend.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.flashware.backend.business.services.ProductoServices;
import com.sinensia.flashware.backend.integration.repositories.ProductoPLRepository;

@RestController
@RequestMapping("/pruebas")
public class BorrameOtraVezController {

	@Autowired
	private ProductoPLRepository productoPLRepository;
	
	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/4")
	public Object prueba4() {
		return productoServices.getEstadisticaPrecioMedioProductos();
	}
	
	@GetMapping("/3")
	public Object prueba3() {
		return productoServices.getEstadisticaNumeroProductos();
	}
	
	@GetMapping("/2")
	public Object prueba2() {
		return productoPLRepository.getEstadisticaPreciosmedios();
	}
	
	@GetMapping("/1")
	public Object prueba1() {
		return productoPLRepository.getEstadisticaNumeroProductos();
	}
	
	
}
