package com.ejercicio.prueba_back_end.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_worked_hours")
public class EMPLOYEEWORKEDHOURSENTITY {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="employee_id")
	private int employeeId;
	@Column(name="worked_hours")
	private int horas_trabajadas;
	@Column(name="worked_date")
	private Date fechaTrabajada;
	
	
	public EMPLOYEEWORKEDHOURSENTITY() {
		super();
	}
	public EMPLOYEEWORKEDHOURSENTITY(int employee_id, int horas_trabajadas, Date fechaTrabajada) {
		super();
		this.employeeId = employee_id;
		this.horas_trabajadas = horas_trabajadas;
		this.fechaTrabajada = fechaTrabajada;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployee_id() {
		return employeeId;
	}
	public void setEmployee_id(int employee_id) {
		this.employeeId = employee_id;
	}
	public int getHoras_trabajadas() {
		return horas_trabajadas;
	}
	public void setHoras_trabajadas(int horas_trabajadas) {
		this.horas_trabajadas = horas_trabajadas;
	}
	public Date getFecha_trabajada() {
		return fechaTrabajada;
	}
	public void setFecha_trabajada(Date fecha_trabajada) {
		this.fechaTrabajada = fecha_trabajada;
	}
	
}

