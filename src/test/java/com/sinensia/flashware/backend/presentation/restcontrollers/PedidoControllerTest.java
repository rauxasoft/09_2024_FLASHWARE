package com.sinensia.flashware.backend.presentation.restcontrollers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MvcResult;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Pedido;
import com.sinensia.flashware.backend.business.services.PedidoServices;
import com.sinensia.flashware.backend.presentation.config.HttpErrorResponse;

@WebMvcTest(PedidoController.class)
class PedidoControllerTest extends AbstractControllerTest{
	
	@MockBean
	private PedidoServices pedidoServices;
	
	private Pedido pedido1;
	private Pedido pedido2;
	private List<Pedido> pedidos;
	
	@BeforeEach
	void init() {
		initObjects();
	}
	
	@Test
	void pedimos_pedido_por_numero() throws Exception {
		
		when(pedidoServices.read(1L)).thenReturn(Optional.of(pedido1));
		
		MvcResult respuesta = mockMvc.perform(get("/pedidos/1").contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();
		
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String pedidoJSON = objectMapper.writeValueAsString(pedido1);
				
		assertThat(responseBody).isEqualToIgnoringWhitespace(pedidoJSON);
		
	}
	
	@Test
	void pedimos_pedido_por_numero_inexistente() throws Exception {
		
		when(pedidoServices.read(1000L)).thenReturn(Optional.empty());
		
		MvcResult mvcResult = mockMvc.perform(get("/pedidos/1000").contentType("application/json"))
									.andExpect(status().isNotFound())
									.andReturn();
		
		testResponseBody(mvcResult, new HttpErrorResponse("No existe el pedido 1000"));
	}
	
	@Test
	void pedimos_todos_los_pedidos() throws Exception {
	
		when(pedidoServices.getAll()).thenReturn(pedidos);
	
		MvcResult mvcResult = mockMvc.perform(get("/pedidos").contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();

		testResponseBody(mvcResult, pedidos);
	}
	
	@Test
	void creamos_pedido_ok() throws Exception {
		
		pedido1.setNumero(null);
		
		String requestBody = objectMapper.writeValueAsString(pedido1);
		
		when(pedidoServices.create(pedido1)).thenReturn(32L);
		
		mockMvc.perform(post("/pedidos").contentType("application/json").content(requestBody))
								.andExpect(status().isCreated())
								.andExpect(header().string("Location", "http://localhost/pedidos/32"));
		
	}
	
	@Test
	void creamos_pedido_con_numero_NOT_NULL() throws Exception {
		
		when(pedidoServices.create(pedido1)).thenThrow(new BusinessException("El pedido debe tener número NULL", true));
		
		String requestBody = objectMapper.writeValueAsString(pedido1);
		
		MvcResult mvcResult = mockMvc.perform(post("/pedidos").contentType("application/json").content(requestBody))
													.andExpect(status().isBadRequest())
													.andReturn();
	
		testResponseBody(mvcResult, new HttpErrorResponse("El pedido debe tener número NULL"));
		
	}
	
	@Test
	void actualizamos_pedido_ok() throws Exception {
		
		String requestBody = objectMapper.writeValueAsString(pedido1);
		
		mockMvc.perform(put("/pedidos/1").contentType("application/json").content(requestBody))
						.andExpect(status().isNoContent());
		
		verify(pedidoServices, times(1)).update(pedido1);
		
	}
	
	@Test
	void actualizamos_pedido_NO_EXISTENTE() throws Exception {
		
		doThrow(new BusinessException("El pedido con número 1 no existe.", true)).when(pedidoServices).update(pedido1);
		
		String requestBody = objectMapper.writeValueAsString(pedido1);
		
		MvcResult mvcResult = mockMvc.perform(put("/pedidos/1").contentType("application/json").content(requestBody))
											.andExpect(status().isBadRequest())
											.andReturn();
		
		testResponseBody(mvcResult, new HttpErrorResponse("El pedido con número 1 no existe."));

	}
	
	@Test
	void eliminamos_pedido_ok() throws Exception {
		
		mockMvc.perform(delete("/pedidos/1").contentType("application/json"))
						.andExpect(status().isNoContent());
		
		verify(pedidoServices, times(1)).delete(1L);
	}
	
	@Test
	void eliminamos_pedido_NO_EXISTENTE() throws Exception {
		
		doThrow(new BusinessException("El pedido con número 1000 no existe.", true)).when(pedidoServices).delete(1000L);
		
		MvcResult mvcResult = mockMvc.perform(delete("/pedidos/1000").contentType("application/json"))
											.andExpect(status().isBadRequest())
											.andReturn();

		testResponseBody(mvcResult, new HttpErrorResponse("El pedido con número 1000 no existe."));
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
		pedido2.setNumero(2L);
		
		pedidos = Arrays.asList(pedido1, pedido2);
		
	}
	
}
