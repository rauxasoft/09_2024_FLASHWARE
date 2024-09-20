package com.sinensia.flashware.backend.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.flashware.backend.business.services.ProductoServices;

@Controller
@RequestMapping("/app")
public class AppProductosController {

	@Autowired
	private ProductoServices productoServices;
	
	@GetMapping("/listado-productos")
	public ModelAndView getListaProductos(ModelAndView mav) {
		
		mav.addObject("productos", productoServices.getAll());
		mav.setViewName("listado-productos");
		
		return mav;
	}
}
