package com.sinensia.flashware.backend.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.flashware.backend.business.services.ProductoServices;

@Controller
@RequestMapping("/app")
public class AppHomeController {

	@Autowired
	private ProductoServices productoServices;

	@GetMapping({"/home",""})
	public ModelAndView getPaginaHome(ModelAndView mav) {
		
		int numeroProductos = productoServices.getNumeroTotalProductos();
	
		mav.addObject("numeroProductos", numeroProductos);
		mav.setViewName("home");
		
		return mav;
	}
	
}
