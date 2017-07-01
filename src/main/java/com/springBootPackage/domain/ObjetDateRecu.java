package com.springBootPackage.domain;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjetDateRecu {
	@JsonProperty("date")
	private Date date;

	public ObjetDateRecu() {
		super();
	}
	public ObjetDateRecu(Date date) {
		super();
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public Calendar getCalDate() {
		
		Calendar calendar = Calendar.getInstance();
		// On met la date du tirage au format Calendar
		calendar.setTime(date);
		// On met l'heure du tirage à 21h
		calendar.set(Calendar.HOUR_OF_DAY,21);
		calendar.set(Calendar.MINUTE,00);
		
		return calendar;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ObjetDateRecu [date=" + date + "]";
	}

	
}
