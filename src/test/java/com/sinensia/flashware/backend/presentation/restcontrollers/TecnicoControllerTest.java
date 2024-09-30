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

import com.sinensia.flashware.backend.business.model.Tecnico;
import com.sinensia.flashware.backend.business.services.TecnicoServices;

@WebMvcTest(TecnicoController.class)
class TecnicoControllerTest extends AbstractControllerTest {
	
	@MockBean
	private TecnicoServices tecnicoServices;
	
	private Tecnico tecnico1;
	private Tecnico tecnico2;
	private List<Tecnico> tecnicos;
	
	@BeforeEach
	void init() {
		initObjects();
	}
	
	@Test
	void pedimos_todos_los_tecnicos() throws Exception {
	
		when(tecnicoServices.getAll()).thenReturn(tecnicos);
	
		MvcResult mvcResult = mockMvc.perform(get("/tecnicos").contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();
		
		testResponseBody(mvcResult, tecnicos);
	}
	
	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************

	private void initObjects() {
		
		tecnico1 = new Tecnico();
		tecnico2 = new Tecnico();
		
		tecnicos = Arrays.asList(tecnico1, tecnico2);

	}
	
}
