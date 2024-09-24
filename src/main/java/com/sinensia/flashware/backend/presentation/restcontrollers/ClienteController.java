package com.sinensia.flashware.backend.presentation.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.flashware.backend.business.model.Cliente;
import com.sinensia.flashware.backend.business.services.ClienteServices;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteServices clienteServices;
	
	public ClienteController(ClienteServices clienteServices) {
		this.clienteServices = clienteServices;
	}
	
	@GetMapping
	public List<Cliente> getAll(){
		return clienteServices.getAll();
	}
}
