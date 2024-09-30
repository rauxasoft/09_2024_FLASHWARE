package com.sinensia.flashware.backend.presentation.restcontrollers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;

import com.sinensia.flashware.backend.business.model.Establecimiento;
import com.sinensia.flashware.backend.business.services.EstablecimientoServices;

@WebMvcTest(EstablecimientoController.class)
class EstablecimientoControllerTest extends AbstractControllerTest{

	@MockBean
	private EstablecimientoServices establecimientoServices;
	
	private Establecimiento establecimiento1;
	private Establecimiento establecimiento2;
	private List<Establecimiento> establecimientos;
	
	@BeforeEach
	void init() {
		initObjects();
	}
	
	@Test
	void pedimos_todos_los_establecimientos() throws Exception {
	
		when(establecimientoServices.getAll()).thenReturn(establecimientos);
	
		MvcResult mvcResult = mockMvc.perform(get("/establecimientos").contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();
		
		testResponseBody(mvcResult, establecimientos);
	
	}
	
	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************

	private void initObjects() {
		
		establecimiento1 = new Establecimiento();
		establecimiento2 = new Establecimiento();
		
		establecimiento1.setId(1L);
		establecimiento2.setId(2L);
		
		establecimientos = Arrays.asList(establecimiento1, establecimiento2);
		
	}

}
