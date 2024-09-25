package com.sinensia.flashware.backend.business.model.dtos;

import java.io.Serializable;

public class ProductoDTO1 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	/**
	 * Incluye el nombre del producto y la categoría
	 * 
	 * Ejemplo: "Impresora Laser Epson D20 (HARDWARE)"
	 */
	private String nombre; 
	
	private double precio;
	
	public ProductoDTO1(Long codigo, String nombre, double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

}
