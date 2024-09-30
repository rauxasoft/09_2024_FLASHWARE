package com.sinensia.flashware.backend.presentation.logs.filter;

import java.io.IOException;
import java.util.Date;

import org.springframework.context.annotation.Configuration;

import com.sinensia.flashware.backend.presentation.logs.integration.repositories.RequestLogPLRepository;
import com.sinensia.flashware.backend.presentation.logs.model.RequestLogPL;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class FiltroAuditor implements Filter {

	private final RequestLogPLRepository requestLogPLRepository;
	
	public FiltroAuditor(RequestLogPLRepository requestLogPLRepository) {
		this.requestLogPLRepository = requestLogPLRepository;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException  {
		
		Long id = System.currentTimeMillis();
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servleResponse = (HttpServletResponse) response;
		
		chain.doFilter(request, response);
		
		RequestLogPL requestLogPL = new RequestLogPL();
		requestLogPL.setId(id);
		requestLogPL.setFechaHora(new Date(id));
		requestLogPL.setRemoteIP(servletRequest.getRemoteAddr());
		requestLogPL.setRequestMethod(servletRequest.getMethod());
		requestLogPL.setRequestPath(servletRequest.getServletPath());
		requestLogPL.setResponseStatusCode(servleResponse.getStatus());
		requestLogPL.setElapsedTime(System.currentTimeMillis() - id);
		
		requestLogPLRepository.save(requestLogPL);

	}	
}
