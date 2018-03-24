package com.parking.dao;

import java.util.List;

import com.parking.model.Vehiculo;

public interface VehiculoDAO extends GenericoDAO<Vehiculo, Integer> {

	public List<Vehiculo> listar();
	public Vehiculo getVehiculoById(Integer id);
	public Vehiculo getVehiculoByTipo(String tipoVehiculo);
	public Vehiculo getVehiculoByTarifa(double tarifa);
	public void insertarVehiculo(Vehiculo vehiculo);
	public void eliminarVehiculo(Vehiculo vehiculo);
	public Integer comprobarVehiculo(String tipoVehiculo);
	public Vehiculo getVehiculo(String tipoVehiculo);
	
}
