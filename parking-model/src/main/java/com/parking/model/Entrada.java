package com.parking.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Entrada implements Serializable {

	private static final long serialVersionUID = 2L;

	private Integer id_entrada;
	private String matricula;
	private String marca;
	private String color;
	private Timestamp hora_entrada;
	private Vehiculo vehiculo;

	public Entrada() {
	}

	public Entrada(String matricula, String marca, String color, Timestamp hora_entrada, Vehiculo vehiculo) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
		this.hora_entrada = hora_entrada;
		this.vehiculo = vehiculo;
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

	public Timestamp getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(Timestamp hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "Entrada [id_entrada=" + id_entrada + ", matricula=" + matricula + ", marca=" + marca + ", color="
				+ color + ", hora_entrada=" + hora_entrada + ", vehiculo=" + vehiculo + "]";
	}

}
