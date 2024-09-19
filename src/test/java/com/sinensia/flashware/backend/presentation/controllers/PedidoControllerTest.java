package com.sinensia.flashware.backend.presentation.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinensia.flashware.backend.business.model.Pedido;
import com.sinensia.flashware.backend.business.services.PedidoServices;

@WebMvcTest(PedidoController.class)
class PedidoControllerTest {

	@Autowired
	private MockMvc miniPostman;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private PedidoServices pedidoServices;
	
	private Pedido pedido1;
	private Pedido pedido2;
	
	@BeforeEach
	void init() {
		initObjects();
	}
	
	@Test
	void pedimos_pedido_por_codigo() throws Exception {
		
		when(pedidoServices.read(1L)).thenReturn(Optional.of(pedido1));
		
		MvcResult respuesta = miniPostman.perform(get("/pedidos/1").contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();
		
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String pedidoJSON = objectMapper.writeValueAsString(pedido1);
				
		assertThat(responseBody).isEqualToIgnoringWhitespace(pedidoJSON);
		
	}
	
	
	
	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************

	private void initObjects() {
		
		pedido1 = new Pedido();
		pedido2 = new Pedido();
		
		pedido1.setNumero(1L);
		pedido1.setNumero(2L);
		
	}
	
}
