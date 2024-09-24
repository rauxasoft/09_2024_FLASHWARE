package com.sinensia.flashware.backend.presentation.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sinensia.flashware.backend.business.model.Pedido;
import com.sinensia.flashware.backend.business.services.PedidoServices;

@Controller
@RequestMapping("/app")
public class AppPedidoController {
	
	private final PedidoServices pedidoServices;
	
	public AppPedidoController(PedidoServices pedidoServices) {
		this.pedidoServices = pedidoServices;
	}

	@GetMapping("/listado-pedidos")
	public ModelAndView getListaPedidos(ModelAndView mav) {
	
		mav.addObject("pedidos", pedidoServices.getAll());
		mav.setViewName("listado-pedidos");
		
		return mav;
	}
	
	@GetMapping("/pedido")
	public ModelAndView getPedido(ModelAndView mav,@RequestParam("numero")  Long numero) {
	
		Optional<Pedido> optional = pedidoServices.read(numero);
		
		if(optional.isPresent()) {
			mav.addObject("pedido", optional.get());
			mav.setViewName("pedido");
		} else {
			mav.addObject("mensaje", "No existe el pedido " + numero);
			mav.setViewName("pagina-error");
		}
		
		return mav;
	}
	
}
