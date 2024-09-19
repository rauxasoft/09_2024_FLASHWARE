package com.sinensia.flashware.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.flashware.backend.business.model.Establecimiento;
import com.sinensia.flashware.backend.business.services.EstablecimientoServices;

@Controller
@RequestMapping("/app")
public class AppEstablecimientosController {

	@Autowired
	private EstablecimientoServices establecimientoServices;
	
	@GetMapping("/listado-establecimientos")
	public ModelAndView getListaEstablecimientos(ModelAndView mav) {
		
		List<Establecimiento> establecimientos = establecimientoServices.getAll();
		
		mav.addObject("establecimientos", establecimientos);
		mav.setViewName("listado-establecimientos");
		
		return mav;
	}
}
