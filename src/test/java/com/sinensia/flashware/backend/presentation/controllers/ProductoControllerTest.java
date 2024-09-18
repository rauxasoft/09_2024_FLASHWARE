package com.sinensia.flashware.backend.presentation.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Producto;
import com.sinensia.flashware.backend.business.services.ProductoServices;
import com.sinensia.flashware.backend.presentation.config.HttpErrorResponse;

@WebMvcTest(ProductoController.class)
class ProductoControllerTest {

	@Autowired
	private MockMvc miniPostman;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private ProductoServices productoServices;
	
	private Producto producto1;
	private Producto producto2;
	private List<Producto> productos;
	
	@BeforeEach
	void init() {
		initObjects();
	}
	
	@Test
	void pedimos_producto_por_codigo() throws Exception {
		
		when(productoServices.read(1000L)).thenReturn(Optional.of(producto1));
		
		MvcResult respuesta = miniPostman.perform(get("/productos/1000").contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();
		
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String productoJSON = objectMapper.writeValueAsString(producto1);
				
		assertThat(responseBody).isEqualToIgnoringWhitespace(productoJSON);
		
	}
	
	@Test
	void pedimos_producto_por_codigo_inexistente() throws Exception {
		
		when(productoServices.read(1000L)).thenReturn(Optional.empty());
		
		MvcResult respuesta = miniPostman.perform(get("/productos/1000").contentType("application/json"))
									.andExpect(status().isNotFound())
									.andReturn();
	
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String httpErrorResponseJSON = objectMapper.writeValueAsString(new HttpErrorResponse("No existe el producto 1000"));
				
		assertThat(responseBody).isEqualToIgnoringWhitespace(httpErrorResponseJSON);
		
	}
	
	@Test
	void pedimos_todos_los_productos() throws Exception {
	
		when(productoServices.getAll()).thenReturn(productos);
	
		MvcResult respuesta = miniPostman.perform(get("/productos").contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();
		
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String productosJSON = objectMapper.writeValueAsString(productos);
				
		assertThat(responseBody).isEqualToIgnoringWhitespace(productosJSON);
	}
	
	@Test
	void pedimos_productos_entre_rango_precios() throws Exception {
		
		when(productoServices.getBetweenPriceRange(10.0, 20.0)).thenReturn(productos);
		
		MvcResult respuesta = miniPostman.perform(get("/productos")
													.param("min", "10.0")
													.param("max", "20.0")
													.contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();
								
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String productosJSON = objectMapper.writeValueAsString(productos);
				
		assertThat(responseBody).isEqualToIgnoringWhitespace(productosJSON);
		
	}
	
	@Test
	void creamos_producto_ok() throws Exception {
		
		producto1.setCodigo(null);
		
		String requestBody = objectMapper.writeValueAsString(producto1);
		
		when(productoServices.create(producto1)).thenReturn(32L);
		
		miniPostman.perform(post("/productos").contentType("application/json").content(requestBody))
								.andExpect(status().isCreated())
								.andExpect(header().string("Location", "http://localhost/productos/32"));
		
	}
	
	@Test
	void creamos_producto_con_codigo_NOT_NULL() throws Exception {
		
		when(productoServices.create(producto1)).thenThrow(new BusinessException("El producto debe tener codigo NULL", true));
		
		String requestBody = objectMapper.writeValueAsString(producto1);
		
		MvcResult respuesta = miniPostman.perform(post("/productos").contentType("application/json").content(requestBody))
													.andExpect(status().isBadRequest())
													.andReturn();
		
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String httpErrorResponseJSON = objectMapper.writeValueAsString(new HttpErrorResponse("El producto debe tener codigo NULL"));
				
		assertThat(responseBody).isEqualToIgnoringWhitespace(httpErrorResponseJSON);
		
	}
	
	@Test
	void actualizamos_producto_ok() throws Exception {
		
		String requestBody = objectMapper.writeValueAsString(producto1);
		
		miniPostman.perform(put("/productos/1000").contentType("application/json").content(requestBody))
							.andExpect(status().isNoContent());
		
		verify(productoServices, times(1)).update(producto1);
		
	}
	
	@Test
	void actualizamos_producto_NO_EXISTENTE() throws Exception {
		
		doThrow(new BusinessException("El producto con codigo 1000 no existe.", true)).when(productoServices).update(producto1);
		
		String requestBody = objectMapper.writeValueAsString(producto1);
		
		MvcResult respuesta = miniPostman.perform(put("/productos/1000").contentType("application/json").content(requestBody))
							.andExpect(status().isBadRequest())
							.andReturn();
		
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String httpErrorResponseJSON = objectMapper.writeValueAsString(new HttpErrorResponse("El producto con codigo 1000 no existe."));
				
		assertThat(responseBody).isEqualToIgnoringWhitespace(httpErrorResponseJSON);
		
	}
	
	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************
	
	private void initObjects() {
		
		producto1 = new Producto();
		producto2 = new Producto();
		
		producto1.setCodigo(1000L);
		producto2.setCodigo(2000L);
		
		productos = Arrays.asList(producto1, producto2);
	}
	
	
}
