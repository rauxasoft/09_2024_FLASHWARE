package com.sinensia.flashware.backend.presentation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.flashware.backend.business.model.Pedido;
import com.sinensia.flashware.backend.business.services.PedidoServices;
import com.sinensia.flashware.backend.presentation.config.PresentationException;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoServices pedidoServices;
	
	@GetMapping("/{numero}")
	public Pedido read(@PathVariable Long numero) {
		
		Optional<Pedido> optional = pedidoServices.read(numero);
		
		if(optional.isEmpty()) {
			throw new PresentationException("No existe el pedido " +  numero, HttpStatus.NOT_FOUND);
		}
		
		return optional.get();
	}
	
}
