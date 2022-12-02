package com.ejercicio.prueba_back_end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ejercicio.prueba_back_end.DTO.ADDEMPLOYEEDTO;
import com.ejercicio.prueba_back_end.DTO.EMPLOYEEPOSITIONDTO;
import com.ejercicio.prueba_back_end.DTO.EMPLOYEEWORKEDHOURSDTO;
import com.ejercicio.prueba_back_end.DTO.PAYMENTSDTO;
import com.ejercicio.prueba_back_end.VIRTUAL.ADDEMPLOYEEWORKEDHOURSV;
import com.ejercicio.prueba_back_end.VIRTUAL.ADDEMPLOYEEV;
import com.ejercicio.prueba_back_end.VIRTUAL.WORKEDHOURSV;
import com.ejercicio.prueba_back_end.VIRTUAL.POSITIONV;
import com.ejercicio.prueba_back_end.service.EMPLOYEESERV;

@Controller
public class EMPLOYEECONTROLLER {
	
	@Autowired
	private EMPLOYEESERV empleadoserv;
	
	@PostMapping("/empleados")
	public ResponseEntity<ADDEMPLOYEEDTO> agregaEmpleado(@Validated @RequestBody ADDEMPLOYEEV empleado) {
		return new ResponseEntity<ADDEMPLOYEEDTO>(empleadoserv.agregaEmpleado(empleado),HttpStatus.OK);
	}
	@PostMapping("/empleados/horas-trabajadas")
	public ResponseEntity<ADDEMPLOYEEDTO> agregaHrsTrbj(@Validated @RequestBody ADDEMPLOYEEWORKEDHOURSV horas) {
		return new ResponseEntity<ADDEMPLOYEEDTO>(empleadoserv.agregaHrsTrbj(horas),HttpStatus.OK);
	}
	@GetMapping("/empleados")
	public ResponseEntity<EMPLOYEEPOSITIONDTO> obtieneEmpleadosPuesto(@Validated @RequestBody POSITIONV puesto){
		return new ResponseEntity<EMPLOYEEPOSITIONDTO>(empleadoserv.obtieneEmpleadosPuesto(puesto),HttpStatus.OK);
	}
	@GetMapping("/empleados/horas-trabajadas")
	public ResponseEntity<EMPLOYEEWORKEDHOURSDTO> totalHorsTrbjEmpl(@Validated @RequestBody WORKEDHOURSV hrs){
		return new ResponseEntity<EMPLOYEEWORKEDHOURSDTO>(empleadoserv.totalHorsTrbjEmpl(hrs),HttpStatus.OK);
	}
	@GetMapping("/empleados/pagos")
	public ResponseEntity<PAYMENTSDTO> totalPagoEmpl(@Validated @RequestBody WORKEDHOURSV hrs){
		return new ResponseEntity<PAYMENTSDTO>(empleadoserv.totalPagoEmpl(hrs),HttpStatus.OK);
	}
}
