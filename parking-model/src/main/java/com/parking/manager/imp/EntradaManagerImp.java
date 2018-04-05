package com.parking.manager.imp;

import java.util.Collection;
import java.util.List;

import com.parking.dao.EntradaDAO;
import com.parking.dao.VehiculoDAO;
import com.parking.manager.EntradaManager;
import com.parking.model.Entrada;
import com.parking.model.Metodos;
import com.parking.model.Salida;
import com.parking.model.Vehiculo;

public class EntradaManagerImp implements EntradaManager {
	private static final int MAX_PLAZAS = 20;

	private EntradaDAO entradaDAO;
	private VehiculoDAO vehiculoDAO;

	public EntradaManagerImp() {
	}

	public EntradaManagerImp(EntradaDAO entradaDAO, VehiculoDAO vehiculoDAO) {
		super();
		this.entradaDAO = entradaDAO;
		this.vehiculoDAO = vehiculoDAO;
	}

	public EntradaDAO getEntradaDAO() {
		return entradaDAO;
	}

	public void setEntradaDAO(EntradaDAO entradaDAO) {
		this.entradaDAO = entradaDAO;
	}

	public VehiculoDAO getVehiculoDAO() {
		return vehiculoDAO;
	}

	public void setVehiculoDAO(VehiculoDAO vehiculoDAO) {
		this.vehiculoDAO = vehiculoDAO;
	}

	@Override
	public List<Entrada> listar() {
		return entradaDAO.listar();
	}

	@Override
	public Integer contarMatriculas(String matricula) {
		return this.entradaDAO.contarMatriculas(matricula);
	}

	@Override
	public String agregar(String matricula, String marca, String color, Integer idVehiculo) {
		String mensaje = null;
		int n = this.entradaDAO.contarMatriculas(matricula);
		Entrada entrada;

		if (entradaDAO.listar().size() <= MAX_PLAZAS) {
			if (n != 0) {
				mensaje = "Ya existe un vehiculo con esa matricula";
			} else {
				Vehiculo v = this.vehiculoDAO.getVehiculoById(idVehiculo);
				entrada = new Entrada(matricula, marca, color, Metodos.getHoraActual(), v);
				System.out.println(entrada.toString());

				this.entradaDAO.insertarEntrada(entrada);

				mensaje = "Entrada insertada correctamente";
			}
		} else {
			System.out.println("Lo sentimos, el parking esta completo");
		}

		return mensaje;
	}

	@Override
	public String modificar(String matriculaBuscar, String matriculaNueva, String marca, String color,
			Integer idVehiculo) {
		String mensaje = null;

		Integer n = this.entradaDAO.contarMatriculas(matriculaBuscar);

		if (n == 0) {
			mensaje = "No hay ninguna entrada con esa matricula";
		} else {
			Entrada entrada = this.entradaDAO.recuperarEntrada(matriculaBuscar);
			entrada.setMatricula(matriculaNueva);
			entrada.setMarca(marca);
			entrada.setColor(color);
			entrada.setVehiculo(this.vehiculoDAO.getVehiculoById(idVehiculo));

			this.entradaDAO.modificarEntrada(entrada);

			mensaje = "Entrada modificado";
		}

		return mensaje;
	}

	@Override
	public String eliminar(String matricula) {
		String mensaje = null;
		Integer n = this.entradaDAO.contarMatriculas(matricula);

		if (n == 0) {
			mensaje = "No hay ninguna entrada con esa matricula";
		} else {
			Entrada entrada = this.entradaDAO.recuperarEntrada(matricula);
			this.entradaDAO.eliminarEntrada(entrada);

			mensaje = "Entrada eliminada";
		}

		return mensaje;
	}

	@Override
	public Entrada getEntrada(String matricula) {
		return this.entradaDAO.recuperarEntrada(matricula);
	}

	@Override
	public void deleteAll(Collection<Entrada> entrada) {
		this.entradaDAO.removeAll(entrada);

	}

	@Override
	public void retirarVehiculo(String matricula) {
		Entrada entrada = this.entradaDAO.recuperarEntrada(matricula);

		Double importe;

		// Si el vehiculo estuvo menos de una hora se le cobrara la hora completa en
		// funcion del tipo de vehiculo
		if (Metodos.restarFechas(entrada.getHora_entrada(), Metodos.getHoraActual()) < 3600000) {
			importe = entrada.getVehiculo().getTarifa();
		} else {
			importe = (Metodos.restarFechas(entrada.getHora_entrada(), Metodos.getHoraActual())
					* entrada.getVehiculo().getTarifa());
		}

		Salida salida = new Salida(entrada.getMatricula(), entrada.getMarca(), entrada.getColor(),
				entrada.getHora_entrada(), Metodos.getHoraActual(), entrada.getVehiculo(), importe);
		System.out.println(salida.toString());

		this.entradaDAO.retirarVehiculo(entrada, salida);
	}

	@Override
	public Integer getPlazasTotales() {
		return MAX_PLAZAS;
	}

	@Override
	public Integer getPlazasDisponibles() {
		return (this.getPlazasTotales() - this.getPlazasOcupadas());
	}

	@Override
	public Integer getPlazasOcupadas() {
		return this.entradaDAO.cantidadVehiculos();
	}

	@Override
	public Entrada getEntradaById(Integer id) {
		return this.entradaDAO.getEntradaById(id);
	}

}
