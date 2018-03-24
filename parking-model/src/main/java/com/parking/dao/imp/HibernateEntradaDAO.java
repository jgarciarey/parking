package com.parking.dao.imp;

import java.util.Collection;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.parking.dao.EntradaDAO;
import com.parking.model.Entrada;
import com.parking.model.Salida;
import com.parking.model.Vehiculo;

public class HibernateEntradaDAO extends HibernateDaoSupport implements EntradaDAO {

	private static final long serialVersionUID = 002L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Entrada> listar() {
		return (List<Entrada>) this.getHibernateTemplate().find("from Entrada order by id_entrada");
	}

	@Override
	public void insertarEntrada(Entrada entrada) {
		this.getHibernateTemplate().save(entrada);
	}

	@Override
	public void eliminarEntrada(Entrada entrada) {
		this.getHibernateTemplate().delete(entrada);
	}

	@Override
	public void modificarEntrada(Entrada entrada) {
		this.getHibernateTemplate().update(entrada);
	}

	@Override
	public void retirarVehiculo(Entrada entrada, Salida salida) {
		this.getHibernateTemplate().save(salida);
		this.getHibernateTemplate().delete(entrada);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer idMax() {
		Integer idMaximo = ((List<Integer>) this.getHibernateTemplate().find("select max(id_entrada) from Entrada"))
				.get(0);
		return idMaximo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer contarMatriculas(String matricula) {
		Long n = ((List<Long>) this.getHibernateTemplate()
				.find("select count(*) from Entrada where matricula='" + matricula + "'")).get(0);
		return Integer.valueOf(n.intValue());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Entrada recuperarEntrada(String matricula) {
		List<Entrada> lista = ((List<Entrada>) this.getHibernateTemplate()
				.find("from Entrada where matricula='" + matricula + "'"));
		if (lista.size() == 1 && lista != null) {
			return lista.get(0);
		}

		return null;
	}

	public Vehiculo getVehiculoByMatricula(String matricula) {
		@SuppressWarnings("unchecked")
		List<Vehiculo> lista = (List<Vehiculo>) this.getHibernateTemplate()
				.find("from Entrada where matricula='" + matricula + "'");

		if (lista.size() == 1 && lista != null) {
			return lista.get(0);
		}
		return null;
	}

	public Entrada getEntradaById(Integer id) {
		@SuppressWarnings("unchecked")
		List<Entrada> lista = (List<Entrada>) this.getHibernateTemplate()
				.find("from Entrada where id_vehiculo='" + id + "'");

		if (lista.size() == 1 && lista != null) {
			return lista.get(0);
		}
		return null;
	}

	@Override
	public void removeAll(Collection<Entrada> entrada) {
		this.getHibernateTemplate().deleteAll(entrada);

	}

	@Override
	public Integer cantidadVehiculos() {
		Long cantidad = (Long) this.getHibernateTemplate().find("select count(*) from Entrada").get(0);
		return Integer.valueOf(cantidad.intValue());
	}

}
