package com.sinensia.flashware.backend.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nombre;
	private String descripcion;
	private Date fechaAlta;
	private Double precio;
	private Boolean descatalogado;
	private Categoria categoria;
	
	public Producto() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getDescatalogado() {
		return descatalogado;
	}

	public void setDescatalogado(Boolean descatalogado) {
		this.descatalogado = descatalogado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaAlta="
				+ fechaAlta + ", precio=" + precio + ", descatalogado=" + descatalogado + ", categoria=" + categoria
				+ "]";
	}

}
