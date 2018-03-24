package com.parking.manager;

import java.util.Collection;
import java.util.List;

import com.parking.model.Entrada;
import com.parking.model.Vehiculo;

public interface EntradaManager {
	public List<Entrada> listar();
	public Entrada getEntrada(String matricula);
	public Entrada getEntradaById(Integer id);
	
	
	public Integer contarMatriculas(String matricula);
	public Integer getPlazasTotales();
	public Integer getPlazasDisponibles();
	public Integer getPlazasOcupadas();
	
	
	public String agregar(String matricula, String marca, String color,
			Integer idVehiculo);

	public String modificar(String matriculaBuscar, String matriculaNueva,
			String marca, String color, Integer idVehiculo);
	
	public String eliminar(String matricula);
	public void deleteAll(Collection<Entrada> entrada);
	
	public void retirarVehiculo(String matricula);

}
