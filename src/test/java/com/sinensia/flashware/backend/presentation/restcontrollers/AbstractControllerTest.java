package com.sinensia.flashware.backend.presentation.restcontrollers;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractControllerTest {

	@Autowired
	protected MockMvc mockMvc;
	
	@Autowired
	protected ObjectMapper objectMapper;
	
	protected void testResponseBody(MvcResult mvcResult, Object object) throws Exception {
		
		String responseBody = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String objetoJSON = objectMapper.writeValueAsString(object);
		
		assertThat(responseBody).isEqualToIgnoringWhitespace(objetoJSON);
		
	}

}
