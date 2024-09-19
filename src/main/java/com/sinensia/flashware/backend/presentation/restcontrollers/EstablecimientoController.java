package com.sinensia.flashware.backend.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.flashware.backend.business.model.Establecimiento;
import com.sinensia.flashware.backend.business.services.EstablecimientoServices;

@RestController
@RequestMapping("/establecimientos")
public class EstablecimientoController {

	@Autowired
	private EstablecimientoServices establecimientoServices;
	
	@GetMapping
	public List<Establecimiento> getAll(){
		return establecimientoServices.getAll();
	}
}
