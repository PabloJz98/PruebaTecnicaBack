package com.ejercicio.prueba_back_end.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genders")
public class GENDERENTITY {
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}