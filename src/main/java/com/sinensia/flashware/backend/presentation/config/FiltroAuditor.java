package com.sinensia.flashware.backend.presentation.config;

import java.io.IOException;
import java.util.Date;

import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class FiltroAuditor implements Filter {

	// AQUI TENDREMOS QUE INYECTAR UN REPOSITORIO
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException  {
		
		Long entrada = System.currentTimeMillis();
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		
		chain.doFilter(request, response);

		Long id = System.currentTimeMillis();
		Date fechaHora = new Date();
		String ip = servletRequest.getRemoteAddr();
		String method = servletRequest.getMethod();
		String path = "/....";										// TODO
		Long elapsedTime = System.currentTimeMillis() - entrada;
		
		System.out.println("ID: " + id);
		System.out.println("Fecha Hora: " + fechaHora);
		System.out.println("IP remota: " + ip);
		System.out.println("Método HTTP: " + method);
		System.out.println("Path de la UTL: " + path);
		System.out.println("Elapsed time: " + elapsedTime);
		System.out.println("\n**********************************\n");
		

	}	
}
