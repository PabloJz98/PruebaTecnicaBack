package com.ejercicio.prueba_back_end.VIRTUAL;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class POSITIONV implements Serializable{
	
	private static final long serialVersionUID = 4844611300573397982L;
	@NotNull(message = "ESTE VALOR NO PUEDE SER NULO")
	private int job_id;
	
	
	public POSITIONV() {
		super();
	}

	public POSITIONV(int job_id) {
		super();
		this.job_id = job_id;
	}

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	
}
