package com.elektra.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="fibonacci")
public class FibonacciModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;
	
	private Integer parametrosInicio;
	
	private Integer parametrosFinal;
	
	@Column(name = "resultado", nullable = false, length = 8000)
	private String resultado;
	
	private Date fecha;

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getParametrosInicio() {
		return parametrosInicio;
	}

	public void setParametrosInicio(Integer parametrosInicio) {
		this.parametrosInicio = parametrosInicio;
	}

	public Integer getParametrosFinal() {
		return parametrosFinal;
	}

	public void setParametrosFinal(Integer parametrosFinal) {
		this.parametrosFinal = parametrosFinal;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "FibonacciModel [id=" + id + ", parametrosInicio=" + parametrosInicio + ", parametrosFinal="
				+ parametrosFinal + ", resultado=" + resultado + ", fecha=" + fecha + "]";
	}



}
