package com.sinensia.flashware.backend.business.model;

import java.io.Serializable;

public class LineaDetallePedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Producto producto;
	private int cantidad; 
	private double precio;
	
	public LineaDetallePedido() {
	
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
		
}
