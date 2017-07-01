package com.springBootPackage.domain;

import java.util.Calendar;

public class Distance {
	private Calendar date;
	private Long distance;
	private Long difference;
	private Boolean apogee;

	public Distance() {
		super();
	}

	public Distance(Calendar date, Long distance, Long difference,
			Boolean apogee) {
		super();
		this.date = date;
		this.distance = distance;
		this.difference = difference;
		this.apogee = apogee;
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

	public Long getDifference() {
		return difference;
	}

	public void setDifference(Long difference) {
		this.difference = difference;
	}

	public Boolean getApogee() {
		return apogee;
	}

	public void setApogee(Boolean apogee) {
		this.apogee = apogee;
	}

	@Override
	public String toString() {
		return "Distance [date=" + date + ", distance=" + distance
				+ ", difference=" + difference + ", apogee=" + apogee + "]";
	}

}
