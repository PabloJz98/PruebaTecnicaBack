package com.ejercicio.prueba_back_end.components;

import java.sql.Date;
import java.time.ZonedDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ejercicio.prueba_back_end.service.EMPLOYEESERVMPL;

@Component
public class UTILSCOMPONENT implements LUTILSCOMPONENT{

	private static Logger log = LoggerFactory.getLogger(EMPLOYEESERVMPL.class);
	@Override
	public boolean validaFecha(Date fecha) {
		if( ZonedDateTime.now().getYear() == (fecha.getYear() +1900)) {
			if((fecha.getMonth() +1) < ZonedDateTime.now().getMonthValue() ) {
				return true;
			}else {
				if(ZonedDateTime.now().getMonthValue() == (fecha.getMonth() +1)) {
					if(fecha.getDate() <= ZonedDateTime.now().getDayOfMonth()) {
						return true;
					}else {
						log.info("Dia mayor");
						return false;
					}
				}else {
					log.info("Mes mayor");
					return false;
				}
			}
		}else {
			if((fecha.getYear() +1900) < ZonedDateTime.now().getYear() ) {
				return true;
			}else {
				log.info("Anio mayor");
				return false;
			}
		}
	}
	@Override
	public boolean comparaFechas(Date inicio, Date Fin) {
		if( (Fin.getYear() +1900) == (inicio.getYear() +1900)) {
			if((inicio.getMonth() +1) <(Fin.getMonth() +1) ) {
				return true;
			}else {
				if((Fin.getMonth() +1) == (inicio.getMonth() +1)) {
					if(inicio.getDate() <= Fin.getDate()) {
						return true;
					}else {
						log.info("Dia mayor");
						return false;
					}
				}else {
					log.info("Mes mayor");
					return false;
				}
			}
		}else {
			if((inicio.getYear() +1900) <(Fin.getYear() +1900)) {
				return true;
			}else {
				log.info("Anio mayor");
				return false;
			}
		}
	}
	@Override
	public Date aumentaDia(Date fecha) {
		fecha.setDate(fecha.getDate()+1);
		 return fecha;
	}
	
}
