package com.parking.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase Metodos
 * Contiene funciones utiles para el desarrollo
 * @author Julen
 *
 */
public class Metodos {

	public static Timestamp getHoraActual() {
		Date ahora = new Date();
		SimpleDateFormat formatoHora = new SimpleDateFormat(
				"dd-M-yyyy HH:mm:ss");
		formatoHora.format(ahora);

		Timestamp horaActual = new Timestamp(ahora.getTime());

		return horaActual;
	}
	
	/**
	 * Resta dos fechas (timestamp) y las convierta a milisegundos (long)
	 * @param fechaEntrada hora de entrada (Timestamp)
	 * @param fechaSalida hora de salida (Timestamp)
	 * @return horas en milisegundos (Long)
	 * 
	 */
	public static Double restarFechas(Timestamp fechaEntrada, Timestamp fechaSalida) {
		long diferenciaMilisegundos = (fechaSalida.getTime() - fechaEntrada.getTime());
		
		Long horas = (diferenciaMilisegundos / (1000 * 60 * 60));
		return horas.doubleValue();
	}
}
