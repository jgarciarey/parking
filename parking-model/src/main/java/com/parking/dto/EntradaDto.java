package com.parking.dto;

import java.io.Serializable;

public class EntradaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7960351321616925757L;
	private Integer id_entrada;
	private String matricula;
	private String marca;
	private String color;
	private Integer vehiculo;

	public EntradaDto() {
	}

	public Integer getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(Integer id_entrada) {
		this.id_entrada = id_entrada;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Integer vehiculo) {
		this.vehiculo = vehiculo;
	}

}
