package com.ejercicio.prueba_back_end.VIRTUAL;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class ADDEMPLOYEEV implements Serializable{

	private static final long serialVersionUID = -6299911325504953818L;
	@NotNull(message="CAMPO OBLIGATORIO")
	private int gender_id;
	@NotNull(message="CAMPO OBLIGATORIO")
	private int job_id;
	@Size(min = 1, max = 20)
	private String name;
	@Size(min = 1, max = 20)
	private String last_name;
	@NotNull(message = "ESTE VALOR NO PUEDE SER NULO")
	private Date birthdate;
	
	public ADDEMPLOYEEV() {
		super();
	}
	public ADDEMPLOYEEV(int gender_id, int job_id, String name, String last_name, Date birthdate) {
		super();
		this.gender_id = gender_id;
		this.job_id = job_id;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
	}
	public int getGender_id() {
		return gender_id;
	}
	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	
}

