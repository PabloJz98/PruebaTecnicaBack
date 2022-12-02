package com.ejercicio.prueba_back_end.DTO;

import java.io.Serializable;
import java.util.List;

public class EMPLOYEEPOSITIONDTO implements Serializable{

	private static final long serialVersionUID = 1097681647388734698L;
	private List<EMPLOYEEDTO> employees;
	private boolean success;
	public EMPLOYEEPOSITIONDTO() {
	}
	public EMPLOYEEPOSITIONDTO(List<EMPLOYEEDTO> employees, boolean success) {
		super();
		this.employees = employees;
		this.success = success;
	}
	public List<EMPLOYEEDTO> getEmployees() {
		return employees;
	}
	public void setEmployees(List<EMPLOYEEDTO> employees) {
		this.employees = employees;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
