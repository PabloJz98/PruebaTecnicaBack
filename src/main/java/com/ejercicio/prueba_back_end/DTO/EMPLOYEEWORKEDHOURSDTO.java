package com.ejercicio.prueba_back_end.DTO;

import java.io.Serializable;

public class EMPLOYEEWORKEDHOURSDTO implements Serializable {
	
	private static final long serialVersionUID = 9186474436101721312L;
	private String total_worked_hours;
	private boolean success;
	public EMPLOYEEWORKEDHOURSDTO() {
		super();
	}
	public EMPLOYEEWORKEDHOURSDTO(String total_worked_hours, boolean success) {
		super();
		this.total_worked_hours = total_worked_hours;
		this.success = success;
	}
	public EMPLOYEEWORKEDHOURSDTO( boolean success) {
		super();
		this.success = success;
	}
	public String getTotal_worked_hours() {
		return total_worked_hours;
	}
	public void setTotal_worked_hours(String total_worked_hours) {
		this.total_worked_hours = total_worked_hours;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
