package com.pruebas.example;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.parking.manager.VehiculoManager;
import com.parking.model.Vehiculo;
import com.pruebas.common.BaseIntegrationTest;

public class VehiculoTest extends BaseIntegrationTest {

	static Scanner in = new Scanner(System.in);

	@Autowired
	private VehiculoManager vehiculoManager;

	private Integer id;
	private String tipoVehiculo;
	private double tarifa;

//	 @Test
	public void TestListarVehiculos() {
		System.out.println("Tipos de vehiculos:");

//		for (int i = 0; i < vehiculoManager.listar().size(); i++) {
//			System.out.println("ID -> " + vehiculoManager.listar().get(i).getId_vehiculo() + " / "
//					+ vehiculoManager.listar().get(i).getTipo() + " / Tarifa -> "
//					+ vehiculoManager.listar().get(i).getTarifa() + " €");
//		}
		
		for (Vehiculo v : vehiculoManager.listar()) {
			System.out.println(v.getTipo());
		}
	}

	// @Test
	public void getVehiculoById() {
		System.out.println("ID del vehiculo: ");
		id = in.nextInt();

		System.out.println("Tipo de vehiculo para id: " + id + ": " + vehiculoManager.getVehiculoById(id).getTipo());
	}
	
	@Test
	public void insertarVehiculo() {
		this.vehiculoManager.insertarVehiculo("camion", 3.0);
	}
	
//	@Test
	public void eliminarVehiculo() {
		System.out.println("Tipo de vehiculo: ");
		tipoVehiculo = in.nextLine();
		
		this.vehiculoManager.eliminarVehiculo(tipoVehiculo);
	}

}
