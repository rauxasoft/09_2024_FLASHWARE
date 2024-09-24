package com.sinensia.flashware.backend.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
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
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long numero;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ESTADO")
	private EstadoPedido estado;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="ID_TECNICO")
	private Tecnico tecnico;
	
	@ManyToOne
	@JoinColumn(name="ID_ESTABLECIMIENTO")
	private Establecimiento establecimiento;
	
	@ElementCollection
	@JoinTable(name="LINEAS_PEDIDO", joinColumns = @JoinColumn(name="NUMERO_PEDIDO"))
	private List<LineaDetallePedido> lineas;
	
	private String observaciones;
	
	public Pedido() {
		
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

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}

	public List<LineaDetallePedido> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaDetallePedido> lineas) {
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
		Pedido other = (Pedido) obj;
		return Objects.equals(numero, other.numero);
	}
	
}
