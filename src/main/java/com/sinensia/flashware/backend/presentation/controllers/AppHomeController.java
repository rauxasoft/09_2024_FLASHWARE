package com.sinensia.flashware.backend.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.flashware.backend.business.services.ProductoServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app")
public class AppHomeController {

	@Autowired
	private ProductoServices productoServices;
	
	// GET    http://10.250.9.1:8080/app/home
	
	@GetMapping("/home")
	public ModelAndView getPaginaHome(HttpServletRequest request, ModelAndView mav) {
		
		int numeroProductos = productoServices.getNumeroTotalProductos();
		String ip = request.getRemoteAddr();
		
		System.out.println("Hay " + numeroProductos + " productos! (petición realizada por " + ip + ")");
		
		mav.addObject("numeroProductos", numeroProductos);
		mav.setViewName("home");
		
		return mav;
	}
	
}
