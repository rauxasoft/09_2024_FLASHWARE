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
	public void doSomething(JoinPoint joinPoint) {
		
		String methodName = joinPoint.getSignature().getName();
		
		// TODO 1.- Mostrar el nombre de la clase. Por ejemplo PedidoController
		// TODO 2.- Mostrar el argumento. Por ejemplo para GET/ pedidos/1233 ---> mostrar 1233
		
		logger.info("Presentation layer: {}", methodName);
	}
	
	// TODO 3.- Crear intercepción también para los métodos de las implementaciones de business
}
