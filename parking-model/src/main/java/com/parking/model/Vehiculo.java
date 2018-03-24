package com.parking.model;

import java.io.Serializable;

public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id_vehiculo;
	private String tipo;
	private double tarifa;

	public Vehiculo() {
	}

	public Vehiculo(String tipo, double tarifa) {
		super();
		this.tipo = tipo;
		this.tarifa = tarifa;
	}

	public int getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(int id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	@Override
	public String toString() {
		return "Vehiculo [id_vehiculo=" + id_vehiculo + ", tipo=" + tipo + ", tarifa=" + tarifa + "]";
	}

}
