package com.parking.manager;

import java.util.List;

import com.parking.model.Vehiculo;

public interface VehiculoManager {
	public List<Vehiculo> listar();
	public Vehiculo getVehiculoById(Integer id);
	public Vehiculo getVehiculoByTipo(String tipoVehiculo);
	public Vehiculo getVehiculoByTarifa(double tarifa);
	public void insertarVehiculo(String tipoVehiculo, double tarifa);
	public void eliminarVehiculo(String tipoVehiculo);
	public Integer comprobarVehiculo(String tipoVehiculo);
	public Vehiculo getVehiculo(String tipoVehiculo);
}
