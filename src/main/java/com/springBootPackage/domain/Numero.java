package com.springBootPackage.domain;

public class Numero {
	private Integer numero;

	public Numero() {
		super();
	}

	public Numero(Integer numero) {
		super();
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return " "+numero+"";
	}

}
