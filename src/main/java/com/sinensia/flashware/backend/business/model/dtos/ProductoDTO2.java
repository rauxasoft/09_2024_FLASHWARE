package com.sinensia.flashware.backend.business.model.dtos;

import java.io.Serializable;

public class ProductoDTO2 implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String anyo;
	private String nombre;
	
	/**
	 * Nos devuelve la descripción recortada a 30 caracteres.
	 * Si la descripción supera los 30 caracteres, el recorte nos muestra puntos suspensivos. 
	 * 
	 * Ejemplo:
	 * 
	 * "Fantástica funda de algodón para guardar tus cartuchos de tinta"
	 * 
	 * vendría devuelto como:
	 * 
	 * "Fantástica funda de algodón pa..."
	 * 
	 */
	private String descripcion;
	
	private double precio;
	
	/**
	 * Es el precio + IVA
	 * 
	 * El IVA es el 21% y es como la constante de gravitación universal
	 */
	private double precioMasIVA;

	public ProductoDTO2(Long codigo, String anyo, String nombre, String descripcion, double precio,
			double precioMasIVA) {
		this.codigo = codigo;
		this.anyo = anyo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.precioMasIVA = precioMasIVA;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getAnyo() {
		return anyo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public double getPrecioMasIVA() {
		return precioMasIVA;
	}
	
}
