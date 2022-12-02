package com.ejercicio.prueba_back_end.components;

import java.sql.Date;

public interface LUTILSCOMPONENT {
	/**
	 * @param fecha
	 * @return true si es menor, false si es mayor
	 */
	public boolean validaFecha(Date fecha);
	/**
	 * Compara una fecha de inicio con una de fin
	 * @param inicio
	 * @param Fin
	 * @return true si fecha inicial es menor, false si fecha fin es mayor
	 */
	public boolean comparaFechas(Date inicio,Date Fin);
	/**
	 * @param fecha
	 * @return
	 */
	public Date aumentaDia(Date fecha);
}
