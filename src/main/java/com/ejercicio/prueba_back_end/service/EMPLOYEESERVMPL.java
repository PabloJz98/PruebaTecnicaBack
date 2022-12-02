package com.ejercicio.prueba_back_end.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicio.prueba_back_end.components.CONSTANTS;
import com.ejercicio.prueba_back_end.DTO.GENDERDTO;
import com.ejercicio.prueba_back_end.DTO.POSITIONDTO;
import com.ejercicio.prueba_back_end.DTO.ADDEMPLOYEEDTO;
import com.ejercicio.prueba_back_end.DTO.EMPLOYEEDTO;
import com.ejercicio.prueba_back_end.DTO.EMPLOYEEPOSITIONDTO;
import com.ejercicio.prueba_back_end.DTO.EMPLOYEEWORKEDHOURSDTO;
import com.ejercicio.prueba_back_end.DTO.PAYMENTSDTO;
import com.ejercicio.prueba_back_end.entity.EMPLOYEENTITY;
import com.ejercicio.prueba_back_end.entity.GENDERENTITY;
import com.ejercicio.prueba_back_end.entity.EMPLOYEEWORKEDHOURSENTITY;
import com.ejercicio.prueba_back_end.entity.JOBENTITY;
import com.ejercicio.prueba_back_end.VIRTUAL.ADDEMPLOYEEWORKEDHOURSV;
import com.ejercicio.prueba_back_end.VIRTUAL.ADDEMPLOYEEV;
import com.ejercicio.prueba_back_end.VIRTUAL.WORKEDHOURSV;
import com.ejercicio.prueba_back_end.VIRTUAL.POSITIONV;
import com.ejercicio.prueba_back_end.DAO.EMPLOYESSDAO;
import com.ejercicio.prueba_back_end.DAO.EMPLOYEE_WORKED_HOURSDAO;
import com.ejercicio.prueba_back_end.DAO.JOBSDAO;
import com.ejercicio.prueba_back_end.DAO.GENDERSDAO;
import com.ejercicio.prueba_back_end.components.LUTILSCOMPONENT;

@Service
public class EMPLOYEESERVMPL implements EMPLOYEESERV {
	private static Logger log = LoggerFactory.getLogger(EMPLOYEESERVMPL.class);
	@Autowired
	private JOBSDAO job_dao;
	@Autowired
	private EMPLOYESSDAO empleado_dao;
	@Autowired
	private GENDERSDAO genero_dao;
	@Autowired
	private EMPLOYEE_WORKED_HOURSDAO hrswork_dao;
	@Autowired
	private LUTILSCOMPONENT utils;
	@Autowired
	private CONSTANTS constantes;
	
	@Override
	public ADDEMPLOYEEDTO agregaEmpleado(ADDEMPLOYEEV empleado) {
		 empleado.setBirthdate(utils.aumentaDia(empleado.getBirthdate()));
		EMPLOYEENTITY empl = empleado_dao.findByNombreAndApellido(empleado.getName(), empleado.getLast_name());
		if(empl == null) {
			 if(ZonedDateTime.now().getYear() - (empleado.getBirthdate().getYear()+1900) >= 18) {
				 if(genero_dao.findById(empleado.getGender_id()).isPresent()) {
					 if(job_dao.findById(empleado.getJob_id()).isPresent()) {
						 EMPLOYEENTITY employee = empleado_dao.save(new EMPLOYEENTITY(empleado.getGender_id(),empleado.getJob_id(),
								 empleado.getName(),empleado.getLast_name(),empleado.getBirthdate()));
						 log.info("Se guardó el empleado");
						 return new ADDEMPLOYEEDTO(employee.getId(),true);
					 }else {
						 log.info(constantes.NO_EXISTE_PUESTO);
						 return new ADDEMPLOYEEDTO(false,constantes.NO_EXISTE_PUESTO);
					 }
				 }else {
					log.info(constantes.NO_EXISTE_GENERO);
					 return new ADDEMPLOYEEDTO(false,constantes.NO_EXISTE_GENERO);
				 }
			 }else {
				 log.info(constantes.NO_MAYOR_EDAD);
				 return new ADDEMPLOYEEDTO(false,constantes.NO_MAYOR_EDAD);
			 }
		}else {
			log.info(constantes.YA_EXISTE_EMPLEADO);
			 return new ADDEMPLOYEEDTO(false,constantes.YA_EXISTE_EMPLEADO);
		}
	}
	@Override
	public ADDEMPLOYEEDTO agregaHrsTrbj(ADDEMPLOYEEWORKEDHOURSV horas) {
		 horas.setWorked_date(utils.aumentaDia(horas.getWorked_date()));
		if(empleado_dao.findById(horas.getEmployee_id()).isPresent()) {
			if(horas.getWorked_hours() >=1 && horas.getWorked_hours() < 21) {
				 if(utils.validaFecha(horas.getWorked_date()) ) {
					 if(hrswork_dao.findByEmployeeIdAndFechaTrabajada(horas.getEmployee_id(),horas.getWorked_date()) == null) {
					  EMPLOYEEWORKEDHOURSENTITY hrs = hrswork_dao.save(new EMPLOYEEWORKEDHOURSENTITY(horas.getEmployee_id(),horas.getWorked_hours(),horas.getWorked_date()));
					  log.info("Horas registradas");
					  return new ADDEMPLOYEEDTO(hrs.getId(),true);
					}else {
						log.info(constantes.YA_EXISTE_REGISTRO_FECHA);
						return new ADDEMPLOYEEDTO(false,constantes.YA_EXISTE_REGISTRO_FECHA);
					}
				 }else {
					 log.info(constantes.FECHA_INCORRECTA);
					 return new ADDEMPLOYEEDTO(false,constantes.FECHA_INCORRECTA);
				 }
			}else {
				log.info(constantes.HORAS_INCORRECTAS);
				 return new ADDEMPLOYEEDTO(false,constantes.HORAS_INCORRECTAS);
			}
		}else {
			log.info(constantes.NO_EXISTE_EMPLEADO);
			 return new ADDEMPLOYEEDTO(false, constantes.NO_EXISTE_EMPLEADO);
		}
	}
	@Override
	public EMPLOYEEPOSITIONDTO obtieneEmpleadosPuesto(POSITIONV puesto) {
		List<EMPLOYEEDTO> lista = new ArrayList<EMPLOYEEDTO>();
		if(!job_dao.findById(puesto.getJob_id()).isPresent()) {
			return new EMPLOYEEPOSITIONDTO(lista,false);
		}
		List<EMPLOYEENTITY> employees = empleado_dao.findByJobId(puesto.getJob_id());
		for(int i = 0;i<employees.size();i++) {
			Optional<JOBENTITY> trabajo = job_dao.findById(employees.get(i).getJob_id());
			Optional<GENDERENTITY> genero = genero_dao.findById(employees.get(i).getGender_id());
			lista.add(new EMPLOYEEDTO(employees.get(i).getId(),employees.get(i).getNombre(),employees.get(i).getApellido(),employees.get(i).getCumpleanios(),
					new POSITIONDTO(trabajo.get().getId(),trabajo.get().getNombre(),trabajo.get().getSalario()),new GENDERDTO(genero.get().getId(),genero.get().getNombre())));
		}
		return new EMPLOYEEPOSITIONDTO(lista,true);
	}
	@Override
	public EMPLOYEEWORKEDHOURSDTO totalHorsTrbjEmpl(WORKEDHOURSV hrs) {
		 hrs.setStart_date(utils.aumentaDia(hrs.getStart_date()));
		 hrs.setEnd_date(utils.aumentaDia(hrs.getEnd_date()));
		if(empleado_dao.findById(hrs.getEmployee_id()).isPresent()) {
			if(utils.comparaFechas(hrs.getStart_date(),hrs.getEnd_date())) {
				return new EMPLOYEEWORKEDHOURSDTO(hrswork_dao.totalHoras(hrs.getEmployee_id(), hrs.getStart_date(), hrs.getEnd_date()) ,true);
			}else {
				return new EMPLOYEEWORKEDHOURSDTO(false);
			}
		}else {
			return new EMPLOYEEWORKEDHOURSDTO(false);
		}
	}
	@Override
	public PAYMENTSDTO totalPagoEmpl(WORKEDHOURSV hrs) {
		 hrs.setStart_date(utils.aumentaDia(hrs.getStart_date()));
		 hrs.setEnd_date(utils.aumentaDia(hrs.getEnd_date()));
		 Optional<EMPLOYEENTITY> empleado = empleado_dao.findById(hrs.getEmployee_id());
		if(empleado.isPresent()) {
			if(utils.comparaFechas(hrs.getStart_date(),hrs.getEnd_date())) {
				List<EMPLOYEEWORKEDHOURSENTITY> lis = hrswork_dao.findByFechaTrabajadaBetweenAndEmployeeId(hrs.getStart_date(), hrs.getEnd_date(),hrs.getEmployee_id());
				JOBENTITY trabajo = job_dao.getById(empleado.get().getJob_id());
				int total = trabajo.getSalario() * lis.size();
				log.info(lis.size()+"");
				return new PAYMENTSDTO(Integer.toString(total),true);
			}else {
				return new PAYMENTSDTO(false);
			}
		}else {
			return new PAYMENTSDTO(false);
		}
	}

}

