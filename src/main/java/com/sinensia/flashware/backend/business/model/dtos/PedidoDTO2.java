package com.sinensia.flashware.backend.business.model.dtos;

import java.io.Serializable;

public class PedidoDTO2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String fecha;           // 25/09/2023
	private String hora;            // 09:46
	private String tecnico;         // "Martínez Quesada, José"
	private String establecimiento; // "FlashWare La Vaguada (Madrid)" <- se añade la población
	private String estado;	        // "NUEVO"
	private Integer numeroLineas;
	private Double importe;			// Opcional!
	
	public PedidoDTO2() {
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getNumeroLineas() {
		return numeroLineas;
	}

	public void setNumeroLineas(Integer numeroLineas) {
		this.numeroLineas = numeroLineas;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

}
