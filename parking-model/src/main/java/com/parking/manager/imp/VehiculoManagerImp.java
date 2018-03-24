package com.parking.manager.imp;

import java.util.List;

import com.parking.dao.VehiculoDAO;
import com.parking.manager.VehiculoManager;
import com.parking.model.Vehiculo;

public class VehiculoManagerImp implements VehiculoManager {

	private VehiculoDAO vehiculoDAO;

	public VehiculoManagerImp() {
	}

	public VehiculoManagerImp(VehiculoDAO vehiculoDAO) {
		super();
		this.vehiculoDAO = vehiculoDAO;
	}

	public VehiculoDAO getVehiculoDAO() {
		return vehiculoDAO;
	}

	public void setVehiculoDAO(VehiculoDAO vehiculoDAO) {
		this.vehiculoDAO = vehiculoDAO;
	}

	@Override
	public List<Vehiculo> listar() {
		return this.vehiculoDAO.listar();
	}

	@Override
	public Vehiculo getVehiculoById(Integer id) {
		return this.vehiculoDAO.getVehiculoById(id);
	}

	@Override
	public Vehiculo getVehiculoByTipo(String tipoVehiculo) {
		return this.vehiculoDAO.getVehiculoByTipo(tipoVehiculo);
	}

	@Override
	public Vehiculo getVehiculoByTarifa(double tarifa) {
		return this.getVehiculoByTarifa(tarifa);
	}

	@Override
	public void insertarVehiculo(String tipoVehiculo, double tarifa) {
		if (this.comprobarVehiculo(tipoVehiculo) != 0) {
			System.out.println("ese vehiculo ya existe");
		} else {
			this.vehiculoDAO.insertarVehiculo(new Vehiculo(tipoVehiculo, tarifa));
			System.out.println("vehiculo insertado");
		}
	}

	@Override
	public Integer comprobarVehiculo(String tipoVehiculo) {
		return this.vehiculoDAO.comprobarVehiculo(tipoVehiculo);
	}

	@Override
	public void eliminarVehiculo(String tipoVehiculo) {
		if (this.comprobarVehiculo(tipoVehiculo) != 0) {
			Vehiculo v = this.vehiculoDAO.getVehiculo(tipoVehiculo);
			this.vehiculoDAO.eliminarVehiculo(v);
		} else {
			System.out.println("no existe ningun vehiculo llamado " + tipoVehiculo);
		}
	}

	@Override
	public Vehiculo getVehiculo(String tipoVehiculo) {
		return this.vehiculoDAO.getVehiculo(tipoVehiculo);
	}

}
