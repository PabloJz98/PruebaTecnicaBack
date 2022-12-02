package com.ejercicio.prueba_back_end.service;

import com.ejercicio.prueba_back_end.DTO.ADDEMPLOYEEDTO;
import com.ejercicio.prueba_back_end.DTO.EMPLOYEEPOSITIONDTO;
import com.ejercicio.prueba_back_end.DTO.EMPLOYEEWORKEDHOURSDTO;
import com.ejercicio.prueba_back_end.DTO.PAYMENTSDTO;
import com.ejercicio.prueba_back_end.VIRTUAL.ADDEMPLOYEEWORKEDHOURSV;
import com.ejercicio.prueba_back_end.VIRTUAL.ADDEMPLOYEEV;
import com.ejercicio.prueba_back_end.VIRTUAL.WORKEDHOURSV;
import com.ejercicio.prueba_back_end.VIRTUAL.POSITIONV;

public interface EMPLOYEESERV {
	/**
	 * @param empleado
	 * @return
	 */
	public ADDEMPLOYEEDTO agregaEmpleado(ADDEMPLOYEEV empleado);
	/**
	 * @param horas
	 * @return
	 */
	public ADDEMPLOYEEDTO agregaHrsTrbj(ADDEMPLOYEEWORKEDHOURSV horas);
	/**
	 * @param puesto
	 * @return
	 */
	public EMPLOYEEPOSITIONDTO obtieneEmpleadosPuesto(POSITIONV puesto);
	/**
	 * @param hrs
	 * @return
	 */
	public EMPLOYEEWORKEDHOURSDTO totalHorsTrbjEmpl(WORKEDHOURSV hrs);
	/**
	 * @param hrs
	 * @return
	 */
	public PAYMENTSDTO totalPagoEmpl(WORKEDHOURSV hrs);
}