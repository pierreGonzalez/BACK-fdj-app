package com.springBootPackage.domain;

import java.util.List;

public class Tirage {
	private Float precision;
	private List<Numero> numeros;
	private List<Etoile> etoiles;

	public Tirage() {
		super();
	}

	public Tirage(Float precision, List<Numero> numeros, List<Etoile> etoiles) {
		super();
		this.precision = precision;
		this.numeros = numeros;
		this.etoiles = etoiles;
	}

	public Float getPrecision() {
		return precision;
	}

	public void setPrecision(Float precision) {
		this.precision = precision;
	}

	public List<Numero> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Numero> numeros) {
		this.numeros = numeros;
	}

	public List<Etoile> getEtoiles() {
		return etoiles;
	}

	public void setEtoiles(List<Etoile> etoiles) {
		this.etoiles = etoiles;
	}

	@Override
	public String toString() {
		return "Tirage [precision=" + precision + ", numeros=" + numeros
				+ ", etoile=" + etoiles + "]";
	}

}
