package com.sinensia.flashware.backend.integration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="PEDIDOS")
public class PedidoPL implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long numero;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;
	
	@Enumerated(EnumType.STRING)
//	@Column(name="ESTADO")
	private EstadoPedidoPL estado;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private ClientePL cliente;
	
	@ManyToOne
	@JoinColumn(name="ID_TECNICO")
	private TecnicoPL tecnico;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTABLECIMIENTO")
	private EstablecimientoPL establecimiento;
	
	@ElementCollection
	@JoinTable(name="LINEAS_PEDIDO", joinColumns = @JoinColumn(name="NUMERO_PEDIDO"))
	private List<LineaDetallePedidoPL> lineas;
	
	private String observaciones;
	
	public PedidoPL() {
		
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public EstadoPedidoPL getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedidoPL estado) {
		this.estado = estado;
	}

	public ClientePL getCliente() {
		return cliente;
	}

	public void setCliente(ClientePL cliente) {
		this.cliente = cliente;
	}

	public TecnicoPL getTecnico() {
		return tecnico;
	}

	public void setTecnico(TecnicoPL tecnico) {
		this.tecnico = tecnico;
	}

	public EstablecimientoPL getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(EstablecimientoPL establecimiento) {
		this.establecimiento = establecimiento;
	}

	public List<LineaDetallePedidoPL> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaDetallePedidoPL> lineas) {
		this.lineas = lineas;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
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
		PedidoPL other = (PedidoPL) obj;
		return Objects.equals(numero, other.numero);
	}
	
}
