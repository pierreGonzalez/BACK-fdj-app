package com.springBootPackage.domain;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "fdjArchive")
public class ObjetArchiver {
	@Id
	@JsonProperty("id")
	private String id;
	@Field("date")
	@JsonProperty("date")
	private Calendar date;
	@Field("distance")
	@JsonProperty("distance")
	private Long distance;
	@Field("numeros")
	@JsonProperty("numeros")
	private List<Numero> numeros;
	@Field("etoiles")
	@JsonProperty("etoiles")
	private List<Etoile> etoiles;
	@Field("difference")
	@JsonProperty("difference")
	private Long difference;

	public ObjetArchiver() {
		super();
	}

	public ObjetArchiver(String id, Calendar date, Long distance,
			List<Numero> numeros, List<Etoile> etoiles, Long difference) {
		super();
		this.id = id;
		this.date = date;
		this.distance = distance;
		this.numeros = numeros;
		this.etoiles = etoiles;
		this.difference = difference;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
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

	public Long getDifference() {
		return difference;
	}

	public void setDifference(Long difference) {
		this.difference = difference;
	}

	@Override
	public String toString() {
		return "ObjetArchiver [id=" + id + ", date=Calendar" + ", distance="
				+ distance + ", numeros=" + numeros + ", etoiles=" + etoiles
				+ ", difference=" + difference + "]";
	}

}