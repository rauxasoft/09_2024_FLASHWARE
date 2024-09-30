package com.sinensia.flashware.backend.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LogAspectConfig {
	
	private Logger logger = LoggerFactory.getLogger(LogAspectConfig.class);

	@Before(value="execution(* com.sinensia.flashware.backend.presentation.restcontrollers.*.*(..))")
	public void logPresentationLayer(JoinPoint joinPoint) {
		crearLog(joinPoint);
	}
	
	@Before(value="execution(* com.sinensia.flashware.backend.business.services.impl.*.*(..))")
	public void logBusinessLayer(JoinPoint joinPoint) {
		crearLog(joinPoint);	
	}
	
	// ******************************************************************
	//
	// Private Methods
	//
	// ******************************************************************
	
	private void crearLog(JoinPoint joinPoint) {
		
		String nombreClase = joinPoint.getTarget().getClass().getSimpleName();
		String nombreMetodo = joinPoint.getSignature().getName();
		Object[] argumentos = joinPoint.getArgs();
		
		StringBuilder sb = new StringBuilder();
		
		for(Object argumento: argumentos) {
			sb.append(argumento + " ");
		}
	
		String strArgumentos = argumentos.length == 0 ? "" : " con argumentos " + sb.toString().trim();
		
		logger.info("{}: Invocado {}(){}", nombreClase, nombreMetodo, strArgumentos);
	}
}
