package com.pruebas.example;

import java.util.Scanner;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.parking.manager.EntradaManager;
import com.pruebas.common.BaseIntegrationTest;

public class ManagerEntradaTest extends BaseIntegrationTest {

	static Scanner in = new Scanner(System.in);

	@Autowired
	private EntradaManager entradaManager;

	String matricula = null;

//	@Test
	public void TestListar() {
		String marca = entradaManager.listar().get(1).getMarca();
		System.out.println("marca: " + marca);
	}

	// @Test
	public void TestListarEntradas() {
		System.out.println("Vehiculos dentro del parking:");

		for (int i = 0; i < entradaManager.listar().size(); i++) {
			System.out.println("ID -> " + entradaManager.listar().get(i).getId_entrada() + " / "
					+ entradaManager.listar().get(i).getMatricula() + " / Hora entrada -> "
					+ entradaManager.listar().get(i).getHora_entrada() + " / "
					+ entradaManager.listar().get(i).getId_vehiculo().getTipo());
		}
	}

	//@Test
	public void TestInsertarEntrada() {
		System.out.println(this.entradaManager.agregar("1111", "Audi", "Azul", 1));
		System.out.println(this.entradaManager.agregar("2222", "Volvo", "Blanco", 1));
		System.out.println(this.entradaManager.agregar("3333", "Mercedes", "Negro", 1));
		
		System.out.println(this.entradaManager.agregar("4444", "Suzuki", "Azul", 2));
		System.out.println(this.entradaManager.agregar("5555", "Honda", "Blanco", 2));
		System.out.println(this.entradaManager.agregar("6666", "Kawasaki", "Negro", 2));
	}

	// @Test
	public void TestModificarEntrada() {
		System.out.println("Introduce la matricula de la entrada a modificar: ");
		matricula = in.nextLine();

		System.out.println(this.entradaManager.modificar(matricula, "4132HGN", "Seat", "Blanco", 1));

	}

	// @Test
	public void TestEliminarEntrada() {
		System.out.println("Introduce la matricula de la entrada a eliminar: ");
		matricula = in.nextLine();

		System.out.println(this.entradaManager.eliminar(matricula));
		TestListarEntradas();
	}

	// @Test
	public void getEntrada() {
		System.out.println("Matricula del vehiculo: ");
		matricula = in.nextLine();

		if (entradaManager.contarMatriculas(matricula) == 0) {
			System.out.println("No existe ningun vehiculo con matricula: " + matricula);
		} else {
			System.out.println("La matricula: " + matricula + " se corresponde con un "
					+ entradaManager.getEntrada(matricula).getMarca());
		}
	}

//	@Test
	public void deleteAll() {
		System.out.println("borrando");
		entradaManager.deleteAll(entradaManager.listar());
	}

		@Test
	public void retirarVehiculo() {
		System.out.println("Matricula: ");
		matricula = in.nextLine();

		if (entradaManager.contarMatriculas(matricula) == 0) {
			System.out.println("No existe ningun vehiculo con matricula: " + matricula);
		} else {
			entradaManager.retirarVehiculo(matricula);
			System.out.println("Vehiculo retirado correctamente");
		}

	}
}
