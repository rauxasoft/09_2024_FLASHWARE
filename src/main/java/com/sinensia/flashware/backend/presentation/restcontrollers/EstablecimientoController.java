package com.sinensia.flashware.backend.presentation.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.flashware.backend.business.model.Establecimiento;
import com.sinensia.flashware.backend.business.services.EstablecimientoServices;
import com.sinensia.flashware.backend.presentation.config.PresentationException;

@RestController
@RequestMapping("/establecimientos")
public class EstablecimientoController {

	@Autowired
	private EstablecimientoServices establecimientoServices;
	
	@GetMapping
	public List<Establecimiento> getAll(){
		return establecimientoServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Establecimiento read(@PathVariable Long id) {
		
		Optional<Establecimiento> optional = establecimientoServices.read(id);
		
		if(optional.isEmpty()) {
			throw new PresentationException("No existe el establecimiento " +  id, HttpStatus.NOT_FOUND);
		}
		
		return optional.get();
	}
}
