package com.springBootPackage.domain;

public class StatNombre {
	private Integer occurence;
	private Integer nombre;

	public StatNombre() {
		super();
	}

	public StatNombre(Integer occurence, Integer nombre) {
		super();
		this.occurence = occurence;
		this.nombre = nombre;
	}

	public Integer getOccurence() {
		return occurence;
	}

	public void setOccurence(Integer occurence) {
		this.occurence = occurence;
	}

	public Integer getNombre() {
		return nombre;
	}

	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "StatNombre [occurence=" + occurence + ", nombre=" + nombre
				+ "]";
	}

}
