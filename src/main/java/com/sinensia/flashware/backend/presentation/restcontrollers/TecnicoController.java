package com.sinensia.flashware.backend.presentation.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.flashware.backend.business.model.Tecnico;
import com.sinensia.flashware.backend.business.services.TecnicoServices;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

	@Autowired
	private TecnicoServices tecnicoServices;
	
	@GetMapping
	public List<Tecnico> getAll(){
		return tecnicoServices.getAll();
	}
	
}
