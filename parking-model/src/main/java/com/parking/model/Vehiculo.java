package com.parking.model;

import java.io.Serializable;

public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id_vehiculo;
	private String tipo;
	private Double tarifa;

	public Vehiculo() {
	}

	public Vehiculo(String tipo, Double tarifa) {
		super();
		this.tipo = tipo;
		this.tarifa = tarifa;
	}

	public Integer getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(Integer id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	@Override
	public String toString() {
		return "Vehiculo [id_vehiculo=" + id_vehiculo + ", tipo=" + tipo + ", tarifa=" + tarifa + "]";
	}

}
