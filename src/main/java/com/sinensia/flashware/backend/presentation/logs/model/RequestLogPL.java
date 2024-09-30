package com.sinensia.flashware.backend.presentation.logs.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="REQUEST_LOGS")
public class RequestLogPL implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHora;
	
	@Column(name="REMOTE_IP")
	private String remoteIP;
	
	private String requestPath;
	private String requestMethod;
	private int responseStatusCode;
	private long elapsedTime;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFechaHora() {
		return fechaHora;
	}
	
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public String getRemoteIP() {
		return remoteIP;
	}
	
	public void setRemoteIP(String remoteIP) {
		this.remoteIP = remoteIP;
	}
	
	public String getRequestPath() {
		return requestPath;
	}
	
	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}
	
	public String getRequestMethod() {
		return requestMethod;
	}
	
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	
	public int getResponseStatusCode() {
		return responseStatusCode;
	}
	
	public void setResponseStatusCode(int responseStatusCode) {
		this.responseStatusCode = responseStatusCode;
	}
	
	public long getElapsedTime() {
		return elapsedTime;
	}
	
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
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
		RequestLogPL other = (RequestLogPL) obj;
		return Objects.equals(id, other.id);
	}

}
