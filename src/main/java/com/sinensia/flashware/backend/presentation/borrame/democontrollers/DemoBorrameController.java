package com.sinensia.flashware.backend.presentation.borrame.democontrollers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.flashware.backend.business.model.Categoria;
import com.sinensia.flashware.backend.business.model.Establecimiento;
import com.sinensia.flashware.backend.business.model.Pedido;
import com.sinensia.flashware.backend.business.model.Producto;
import com.sinensia.flashware.backend.business.services.PedidoServices;
import com.sinensia.flashware.backend.business.services.ProductoServices;
import com.sinensia.flashware.backend.integration.repositories.EstablecimientoRepository;
import com.sinensia.flashware.backend.integration.repositories.ProductoRepository;

@RestController
@RequestMapping("/pruebas")
public class DemoBorrameController {

	@Autowired
	private PedidoServices pedidoServices;
	
	@Autowired
	private ProductoServices productoServices;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private EstablecimientoRepository establecimientoRepository;
	
	@GetMapping("/7")
	public List<Establecimiento> prueba7(){
		return establecimientoRepository.findByNombreLikeIgnoreCase("%guAda%");
	}
	
	@GetMapping("/6")
	public List<Pedido> prueba6(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") Date desde, 
							    @RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") Date hasta){
		return pedidoServices.getBetweenDates(desde, hasta);
	}
	
	@GetMapping("/5")
	public List<Pedido> prueba5(@RequestParam Long id){
		return pedidoServices.getByEstablecimiento(id);
	}

	@GetMapping("/3")
	public List<Producto> prueba3(@RequestParam Categoria categoria){
	
		System.out.println("categoria: " + categoria);
		
		return productoServices.getByCategoria(categoria);
	}
	
	@GetMapping("/4")
	public Object prueba4(@RequestParam Categoria categoria){
		
		System.out.println("categoria: " + categoria);
		
		return productoRepository.findByCategoria(categoria);
	}
	
	
	
	@GetMapping("/1")
	public List<Producto> prueba1(@RequestParam Double min, 
			                      @RequestParam Double max){
		
		System.out.println("min: " + min);
		System.out.println("max: " + max);
		
		return productoServices.getBetweenPriceRange(min, max);
	}
	
	@GetMapping("/2")
	public Object prueba2(@RequestParam Double min, Double max){
		
		System.out.println("min: " + min);
		System.out.println("max: " + max);
		
		return productoRepository.findByPrecioBetweenOrderByPrecioDesc(min, max);
	}
	
	
	
}
