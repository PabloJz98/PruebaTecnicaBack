package com.ejercicio.prueba_back_end.VIRTUAL;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WORKEDHOURSV implements Serializable {
	
	private static final long serialVersionUID = -1669914028361424001L;
	@NotNull(message = "ESTE VALOR NO PUEDE SER NULO")
	private int employee_id;
	@NotNull(message = "ESTE VALOR NO PUEDE SER NULO")
	@NotEmpty(message = "ESTE VALOR NO PUEDE SER NULO")
	private Date start_date;
	@NotNull(message = "ESTE VALOR NO PUEDE SER NULO")
	@NotEmpty(message = "ESTE VALOR NO PUEDE SER NULO")
	private Date end_date;
	public WORKEDHOURSV() {
		super();
	}
	public WORKEDHOURSV(int employee_id, Date start_date, Date end_date) {
		super();
		this.employee_id = employee_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
}
