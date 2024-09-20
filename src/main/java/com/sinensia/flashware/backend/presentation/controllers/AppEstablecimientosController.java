package com.sinensia.flashware.backend.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/formulario-alta-establecimiento")
	public String getFormularioAlta(Model model) {
		
		model.addAttribute("establecimiento", new Establecimiento());
		
		return "formulario-alta-establecimiento";
	}
	
	@PostMapping("/crear-establecimiento")
	public String crearEstablecimiento(@ModelAttribute("establecimiento") Establecimiento establecimiento) {
		
		System.out.println("Vamos a crear el establecimiento: " +  establecimiento);
		
		return "formulario-alta-establecimiento";
	}
}
