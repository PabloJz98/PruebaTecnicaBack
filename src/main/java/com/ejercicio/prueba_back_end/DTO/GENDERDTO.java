package com.ejercicio.prueba_back_end.DTO;

import java.io.Serializable;

public class GENDERDTO implements Serializable{

	private static final long serialVersionUID = 3585973468918587126L;
	private int id;
	private String name;
	public GENDERDTO() {
		super();
	}
	public GENDERDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
