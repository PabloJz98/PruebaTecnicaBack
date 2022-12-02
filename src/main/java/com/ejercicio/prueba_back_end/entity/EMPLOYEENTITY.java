package com.ejercicio.prueba_back_end.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class EMPLOYEENTITY {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="gender_id")
	private int gender_id;
	@Column(name="job_id")
	private int jobId;
	@Column(name="name")
	private String nombre;
	@Column(name="last_name")
	private String apellido;
	@Column(name="birthdate")
	private Date cumpleanios;
	public EMPLOYEENTITY() {
	}
	public EMPLOYEENTITY( int gender_id, int job_id, String nombre, String apellido, Date cumpleanios) {
		this.gender_id = gender_id;
		this.jobId = job_id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cumpleanios = cumpleanios;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGender_id() {
		return gender_id;
	}
	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}
	public int getJob_id() {
		return jobId;
	}
	public void setJob_id(int job_id) {
		this.jobId = job_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getCumpleanios() {
		return cumpleanios;
	}
	public void setCumpleanios(Date cumpleanios) {
		this.cumpleanios = cumpleanios;
	}
	
}
