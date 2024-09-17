package com.sinensia.flashware.backend.presentation.config;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.sinensia.flashware.backend.business.config.BusinessException;

@ControllerAdvice
public class GestorCentralizadoExcepciones extends ResponseEntityExceptionHandler{

	// ************************************************************************************************************************
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> gestionarException(Exception ex, WebRequest request){
			
			HttpErrorResponse httpErrorResponse = new HttpErrorResponse("Ha habido un problema en el servidor.");
			
			return handleExceptionInternal(ex, httpErrorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
		}
	
	// ************************************************************************************************************************
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessExceptions(BusinessException ex, WebRequest request) {
			
		HttpStatus httpStatus = ex.isProblemaArgumentos() ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
		String mensaje = ex.isProblemaArgumentos() ? ex.getMessage() : "Ha habido un problema en el servidor";
		
		HttpErrorResponse httpErrorResponse = new HttpErrorResponse(mensaje);
		
		return handleExceptionInternal(ex, httpErrorResponse, new HttpHeaders(), httpStatus, request);
	}
	
	// ************************************************************************************************************************
	
	@ExceptionHandler(PresentationException.class)
	public ResponseEntity<?> handlePresentationException(PresentationException ex, WebRequest request){
		
		HttpErrorResponse httpErrorResponse = new HttpErrorResponse(ex.getMessage());
		
		return handleExceptionInternal(ex, httpErrorResponse, new HttpHeaders(), ex.getHttpStatus(), request);
	}
	
	// ************************************************************************************************************************
	
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Object valorEntrante = ex.getValue();
		String tipoEntrante = valorEntrante != null ? valorEntrante.getClass().getName() : null;
		String tipoRequerido = ex.getRequiredType() != null ? ex.getRequiredType().getName() : null;
	
		HttpErrorResponse httpErrorResponse = new HttpErrorResponse("Ha llegado el valor " + valorEntrante + " de tipo " + tipoEntrante + ". Se requeria una parámeto de tipo " + tipoRequerido);
		
		return handleExceptionInternal(ex, httpErrorResponse, headers, HttpStatus.BAD_REQUEST, request);
	
	}
	
	// ************************************************************************************************************************
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		HttpErrorResponse httpErrorResponse = new HttpErrorResponse("No se ha podido parsear el objeto JSON");
		
		return handleExceptionInternal(ex, httpErrorResponse, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	// ************************************************************************************************************************

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		HttpErrorResponse httpErrorResponse = new HttpErrorResponse("No se soporta el método " + ex.getMethod() + " para la petición.");
		
		return handleExceptionInternal(ex, httpErrorResponse, headers, HttpStatus.METHOD_NOT_ALLOWED, request);
	}
	
	// ************************************************************************************************************************

	@Override
	protected ResponseEntity<Object> handleNoResourceFoundException(NoResourceFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		HttpErrorResponse httpErrorResponse = new HttpErrorResponse("El recurso " + ex.getResourcePath() + " no se encuentra.");
		
		return handleExceptionInternal(ex, httpErrorResponse, headers, HttpStatus.NOT_FOUND, request);
	}
	
}
