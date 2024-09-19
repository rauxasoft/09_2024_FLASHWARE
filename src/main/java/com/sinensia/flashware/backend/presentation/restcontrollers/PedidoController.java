package com.sinensia.flashware.backend.presentation.restcontrollers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Pedido;
import com.sinensia.flashware.backend.business.services.PedidoServices;
import com.sinensia.flashware.backend.presentation.config.PresentationException;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private  PedidoServices pedidoServices;

	@GetMapping("/{numero}")
	public Pedido read(@PathVariable Long numero) {
		
		Optional<Pedido> optional = pedidoServices.read(numero);
		
		if(optional.isEmpty()) {
			throw new PresentationException("No existe el pedido " +  numero, HttpStatus.NOT_FOUND);
		}
		
		return optional.get();
	}
	
	@GetMapping
	public List<Pedido> getPedidos(){	
		return pedidoServices.getAll();
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pedido pedido, UriComponentsBuilder ucb) throws BusinessException{
		
		Long numero = pedidoServices.create(pedido);
		
		URI uri = ucb.path("/pedidos/{numero}").build(numero);

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{numero}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Pedido pedido, @PathVariable Long numero) throws BusinessException {
		pedido.setNumero(numero);
		pedidoServices.update(pedido);
	}
	
	@DeleteMapping("/{numero}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long numero) throws BusinessException {
		pedidoServices.delete(numero);	
	}

}
