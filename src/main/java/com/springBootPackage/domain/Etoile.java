package com.springBootPackage.domain;

public class Etoile {
	private Integer etoile;

	public Etoile() {
		super();
	}

	public Etoile(Integer etoile) {
		super();
		this.etoile = etoile;
	}

	public Integer getEtoile() {
		return etoile;
	}

	public void setEtoile(Integer etoile) {
		this.etoile = etoile;
	}

	@Override
	public String toString() {
		return " " + etoile + " ";
	}

}
