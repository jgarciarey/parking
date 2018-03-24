package com.parking.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Salida implements Serializable {

	private static final long serialVersionUID = 3L;

	private Integer id_salida;
	private String matricula;
	private String marca;
	private String color;
	private Timestamp hora_entrada;
	private Timestamp hora_salida;
	private Vehiculo vehiculo;
	private double importe;

	public Salida() {
	}

	public Salida(String matricula, String marca, String color, Timestamp hora_entrada, Timestamp hora_salida,
			Vehiculo vehiculo, double importe) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.color = color;
		this.hora_entrada = hora_entrada;
		this.hora_salida = hora_salida;
		this.vehiculo = vehiculo;
		this.importe = importe;
	}

	public Integer getId_salida() {
		return id_salida;
	}

	public void setId_salida(Integer id_salida) {
		this.id_salida = id_salida;
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

	public Timestamp getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(Timestamp hora_salida) {
		this.hora_salida = hora_salida;
	}

	public Vehiculo getId_vehiculo() {
		return vehiculo;
	}

	public void setId_vehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "Salida [id_salida=" + id_salida + ", matricula=" + matricula + ", marca=" + marca + ", color=" + color
				+ ", hora_entrada=" + hora_entrada + ", hora_salida=" + hora_salida + ", vehiculo=" + vehiculo
				+ ", importe=" + importe + "]";
	}

}
