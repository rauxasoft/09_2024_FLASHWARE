package com.sinensia.flashware.backend.business.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ESTABLECIMIENTOS")
public class Establecimiento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	private String nombre;
	
	@Embedded
	@AttributeOverrides({@AttributeOverride(name="codigoPostal", column=@Column(name="C_POSTAL"))})
	private Direccion direccion;
	
	@Embedded
	private DatosContacto datosContacto;
	
	public Establecimiento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public DatosContacto getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(DatosContacto datosContacto) {
		this.datosContacto = datosContacto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		Establecimiento other = (Establecimiento) obj;
		return Objects.equals(id, other.id);
	}
	
}
