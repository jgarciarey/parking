package com.parking.dao.imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.parking.dao.VehiculoDAO;
import com.parking.model.Entrada;
import com.parking.model.Vehiculo;

public class HibernateVehiculoDAO extends HibernateDaoSupport implements VehiculoDAO {

	// PROPIEDADES
	private static final long serialVersionUID = 001L;

	// CONSTRUCTOR
	public HibernateVehiculoDAO() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> listar() {
		List<Vehiculo> listar = (List<Vehiculo>) this.getHibernateTemplate().find("from Vehiculo order by id_vehiculo");
		return listar;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vehiculo getVehiculoById(Integer id) {
		List<Vehiculo> lista = (List<Vehiculo>) this.getHibernateTemplate()
				.find("from Vehiculo where id_vehiculo = " + id);

		if (lista.size() == 1 && lista != null) {
			return lista.get(0);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vehiculo getVehiculoByTipo(String tipoVehiculo) {
		List<Vehiculo> lista = (List<Vehiculo>) this.getHibernateTemplate()
				.find("from Vehiculo where tipo = " + tipoVehiculo);

		if (lista.size() == 1 && lista != null) {
			return lista.get(0);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Vehiculo getVehiculoByTarifa(double tarifa) {
		List<Vehiculo> lista = (List<Vehiculo>) this.getHibernateTemplate()
				.find("from Vehiculo where tarifa = " + tarifa);

		if (lista.size() == 1 && lista != null) {
			return lista.get(0);
		}

		return null;
	}

	@Override
	public void insertarVehiculo(Vehiculo vehiculo) {
		this.getHibernateTemplate().save(vehiculo);
	}

	@Override
	public Integer comprobarVehiculo(String tipoVehiculo) {
		@SuppressWarnings("unchecked")
		Long n = ((List<Long>) this.getHibernateTemplate()
				.find("select count(*) from Vehiculo where tipo='" + tipoVehiculo + "'")).get(0);
		return Integer.valueOf(n.intValue());
	}

	@Override
	public void eliminarVehiculo(Vehiculo vehiculo) {
		this.getHibernateTemplate().delete(vehiculo);
	}

	@Override
	public Vehiculo getVehiculo(String tipoVehiculo) {
		@SuppressWarnings("unchecked")
		List<Vehiculo> lista = ((List<Vehiculo>) this.getHibernateTemplate()
				.find("from Vehiculo where tipo='" + tipoVehiculo + "'"));
		if (lista.size() == 1 && lista != null) {
			return lista.get(0);
		}

		return null;
	}

}
