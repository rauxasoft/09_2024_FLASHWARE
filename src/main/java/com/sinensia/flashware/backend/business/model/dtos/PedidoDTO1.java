package com.sinensia.flashware.backend.business.model.dtos;

import java.io.Serializable;

public class PedidoDTO1 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String fecha;     // 25/09/2023
	private String hora;      // 09:46
	private String trimestre; // 1T, 2T, ..
	private String tecnico;   // "Martínez Quesada, José"
	private String estado;	  // "NUEVO"
	
	public PedidoDTO1(Long codigo, String fecha, String hora, String trimestre, String tecnico, String estado) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.hora = hora;
		this.trimestre = trimestre;
		this.tecnico = tecnico;
		this.estado = estado;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}

	public String getTrimestre() {
		return trimestre;
	}

	public String getTecnico() {
		return tecnico;
	}

	public String getEstado() {
		return estado;
	}

}
