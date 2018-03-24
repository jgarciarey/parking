package com.parking.dao;


import java.util.Collection;
import java.util.List;

import com.parking.model.Entrada;
import com.parking.model.Salida;
import com.parking.model.Vehiculo;

public interface EntradaDAO extends GenericoDAO<Entrada, Integer> {
	public List<Entrada> listar();
	
	public Vehiculo getVehiculoByMatricula(String matricula);
	public Entrada getEntradaById(Integer id);
	
	public void insertarEntrada(Entrada entrada);
	public void eliminarEntrada(Entrada entrada);
	public void removeAll(Collection<Entrada> entrada);
	public void modificarEntrada(Entrada entrada);
	
	public void retirarVehiculo(Entrada entrada, Salida salida);
	
	public Integer idMax();
	public Integer contarMatriculas(String matricula);
	public Integer cantidadVehiculos();
	
	public Entrada recuperarEntrada(String matricula);
}
