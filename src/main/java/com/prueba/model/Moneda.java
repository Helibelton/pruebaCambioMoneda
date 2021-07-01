package com.prueba.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monedas")
public class Moneda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "monedaorigen")
	private String monedaorigen;
	
	@Column(name = "monedadestino")
	private String monedadestino;
	
	@Column(name = "cambio")
	private BigDecimal cambio;
	
	@Column(name = "montoinicial")
	private BigDecimal montoinicial;
	
	@Column(name = "montofinal")
	private BigDecimal montofinal;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMonedaorigen() {
		return monedaorigen;
	}

	public void setMonedaorigen(String monedaorigen) {
		this.monedaorigen = monedaorigen;
	}

	public String getMonedadestino() {
		return monedadestino;
	}

	public void setMonedadestino(String monedadestino) {
		this.monedadestino = monedadestino;
	}

	public BigDecimal getCambio() {
		return cambio;
	}

	public void setCambio(BigDecimal cambio) {
		this.cambio = cambio;
	}

	public BigDecimal getMontoinicial() {
		return montoinicial;
	}

	public void setMontoinicial(BigDecimal montoinicial) {
		this.montoinicial = montoinicial;
	}

	public BigDecimal getMontofinal() {
		return montofinal;
	}

	public void setMontofinal(BigDecimal montofinal) {
		this.montofinal = montofinal;
	}
	

}
