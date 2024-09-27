package com.sinensia.flashware.backend.integration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PRODUCTOS")
public class ProductoPL implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long codigo;
	
	private String nombre;
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	private Date fechaAlta;
	
	private Double precio;
	private Boolean descatalogado;
	
	@Enumerated(EnumType.STRING)
	private CategoriaPL categoria;
	
	public ProductoPL() {
		
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

	public CategoriaPL getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaPL categoria) {
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
		ProductoPL other = (ProductoPL) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaAlta="
				+ fechaAlta + ", precio=" + precio + ", descatalogado=" + descatalogado + ", categoria=" + categoria
				+ "]";
	}

}
