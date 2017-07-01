package com.springBootPackage.domain.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators.IndexOfArray;

import com.springBootPackage.domain.Distance;

public enum DistanceTerreLune {

	DISTANCE_01(new GregorianCalendar(2017, 1, 10, 6, 7), 36324L, 0L, false), DISTANCE_02(
			new GregorianCalendar(2017, 1, 22, 0, 32), 404922L, 0L, true), DISTANCE_03(
			new GregorianCalendar(2017, 2, 6, 14, 27), 368807L, 0L, false), DISTANCE_04(
			new GregorianCalendar(2017, 2, 18, 20, 52), 404386L, 0L, true), DISTANCE_05(
			new GregorianCalendar(2017, 3, 3, 7, 47), 369065L, 0L, false), DISTANCE_06(
			new GregorianCalendar(2017, 3, 18, 17, 13), 404646L, 0L, true), DISTANCE_07(
			new GregorianCalendar(2017, 3, 30, 12, 23), 363863L, 0L, false), DISTANCE_08(
			new GregorianCalendar(2017, 4, 15, 9, 48), 405488L, 0L, true), DISTANCE_09(
			new GregorianCalendar(2017, 4, 27, 16, 13), 359341L, 0L, false), DISTANCE_10(
			new GregorianCalendar(2017, 5, 12, 19, 39), 406216L, 0L, true), DISTANCE_11(
			new GregorianCalendar(2017, 5, 26, 1, 7), 357227L, 0L, false), DISTANCE_12(
			new GregorianCalendar(2017, 6, 8, 22, 33), 406371L, 0L, true), DISTANCE_13(
			new GregorianCalendar(2017, 6, 23, 10, 58), 357956L, 0L, false), DISTANCE_14(
			new GregorianCalendar(2017, 7, 6, 4, 28), 405934L, 0L, true), DISTANCE_15(
			new GregorianCalendar(2017, 7, 21, 17, 12), 361236L, 0L, false), DISTANCE_16(
			new GregorianCalendar(2017, 8, 2, 17, 55), 405025L, 0L, true), DISTANCE_17(
			new GregorianCalendar(2017, 8, 18, 13, 18), 366121L, 0L, false), DISTANCE_18(
			new GregorianCalendar(2017, 8, 30, 11, 25), 404308L, 0L, true), DISTANCE_19(
			new GregorianCalendar(2017, 9, 13, 16, 06), 369860L, 0L, false), DISTANCE_20(
			new GregorianCalendar(2017, 9, 27, 6, 50), 404348L, 0L, true), DISTANCE_21(
			new GregorianCalendar(2017, 10, 9, 5, 55), 366855L, 0L, false), DISTANCE_22(
			new GregorianCalendar(2017, 10, 25, 2, 26), 405154L, 0L, true), DISTANCE_23(
			new GregorianCalendar(2017, 11, 6, 0, 10), 361438L, 0L, false), DISTANCE_24(
			new GregorianCalendar(2017, 11, 21, 18, 53), 406132L, 0L, true), DISTANCE_25(
			new GregorianCalendar(2017, 12, 4, 8, 46), 357492L, 0L, false), DISTANCE_26(
			new GregorianCalendar(2017, 12, 19, 1, 26), 406603L, 0L, true);

	private final Calendar date;
	private final Long distance;
	private final Long difference;
	private final Boolean apogee;

	private DistanceTerreLune(Calendar date, Long distance,
			Long difference, Boolean apogee) {
		this.date = date;
		this.distance = distance;
		this.difference = difference;
		this.apogee = apogee;
	}

	public Calendar getDate() {
		return date;
	}

	public Long getDistance() {
		return distance;
	}

	public Long getDifference() {
		return difference;
	}

	public Boolean getApogee() {
		return apogee;
	}

	public static DistanceTerreLune getSuivant(Distance enumDistance,Integer index) {
		
		// si index n'est pas celui de la dernière enumeration on renvoie le la suivante
		DistanceTerreLune enumDistanceSuivante = null;
		if (index != (DistanceTerreLune.values().length - 1)) {
			enumDistanceSuivante = DistanceTerreLune.values()[index + 1];
		} else if(index == 0) {
			enumDistanceSuivante = DistanceTerreLune.values()[index - 1];
		}
		return enumDistanceSuivante;
	}

	public static DistanceTerreLune getPrecedent(Distance enumDistance, Integer index) {
		

		// si index n'est pas celui de la première enumeration on renvoie le la précedente
		DistanceTerreLune enumDistanceSuivante = null;
		if (index != 0) {
			enumDistanceSuivante = DistanceTerreLune.values()[index - 1];
		} else if(index == 0) {
			enumDistanceSuivante = DistanceTerreLune.values()[index + 1];
		}
		return enumDistanceSuivante;
	}

	public static final List<Distance> getListeObjetDistanceAvecValeurEnum() {
		List<DistanceTerreLune> listeEnum = Arrays.asList(DistanceTerreLune
				.values());
		List<Distance> listeDistance = new ArrayList<>();
		for (DistanceTerreLune enumListe : listeEnum) {
			Distance distance = new Distance();
			distance.setDate(enumListe.getDate());
			distance.setDistance(enumListe.getDistance());
			distance.setApogee(enumListe.getApogee());
			listeDistance.add(distance);
		}
		return listeDistance;
	}

	
}
