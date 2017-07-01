package com.springBootPackage.infrastructure.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springBootPackage.domain.Etoile;
import com.springBootPackage.domain.MessageRetour;
import com.springBootPackage.domain.Numero;
import com.springBootPackage.domain.ObjetArchiver;
import com.springBootPackage.domain.service.FdjService;
import com.springBootPackage.infrastructure.repository.FdjRepository;

@Service
public class HistoriqueManager {
	private final Logger LOG = LoggerFactory.getLogger(HistoriqueManager.class);
	@Inject
	FdjService fdjService;
	@Inject
	FdjRepository fdjRepository;

	public MessageRetour initialisation() {
		// Drop de la mongo
		fdjRepository.deleteAll();
		// montage de l'hystorique
		List<ObjetArchiver> listeHistoriqueArchivee = new ArrayList<>();
		MessageRetour messageRetour = new MessageRetour();
		List<Numero> numeros1 = new ArrayList<>();
		numeros1.add(new Numero(34));
		numeros1.add(new Numero(27));
		numeros1.add(new Numero(49));
		numeros1.add(new Numero(23));
		numeros1.add(new Numero(19));
		List<Etoile> etoiles1 = new ArrayList<>();
		etoiles1.add(new Etoile(11));
		etoiles1.add(new Etoile(1));
		ObjetArchiver a1 = new ObjetArchiver(null, new GregorianCalendar(2017,
				1, 3, 21, 0), 0L, numeros1, etoiles1, 0L);
		listeHistoriqueArchivee.add(a1);
		List<Numero> numeros2 = new ArrayList<>();
		numeros2.add(new Numero(21));
		numeros2.add(new Numero(14));
		numeros2.add(new Numero(49));
		numeros2.add(new Numero(10));
		numeros2.add(new Numero(18));
		List<Etoile> etoiles2 = new ArrayList<>();
		etoiles2.add(new Etoile(9));
		etoiles2.add(new Etoile(11));
		ObjetArchiver a2 = new ObjetArchiver(null, new GregorianCalendar(2017,
				1, 6, 21, 0), 0L, numeros2, etoiles2, 0L);
		listeHistoriqueArchivee.add(a2);
		List<Numero> numeros3 = new ArrayList<>();
		numeros3.add(new Numero(44));
		numeros3.add(new Numero(29));
		numeros3.add(new Numero(35));
		numeros3.add(new Numero(11));
		numeros3.add(new Numero(2));
		List<Etoile> etoiles3 = new ArrayList<>();
		etoiles3.add(new Etoile(4));
		etoiles3.add(new Etoile(9));
		ObjetArchiver a3 = new ObjetArchiver(null, new GregorianCalendar(2017,
				1, 10, 21, 0), 0L, numeros3, etoiles3, 0L);
		listeHistoriqueArchivee.add(a3);
		List<Numero> numeros4 = new ArrayList<>();
		numeros4.add(new Numero(16));
		numeros4.add(new Numero(7));
		numeros4.add(new Numero(50));
		numeros4.add(new Numero(3));
		numeros4.add(new Numero(26));
		List<Etoile> etoiles4 = new ArrayList<>();
		etoiles4.add(new Etoile(4));
		etoiles4.add(new Etoile(7));
		ObjetArchiver a4 = new ObjetArchiver(null, new GregorianCalendar(2017,
				1, 13, 21, 0), 0L, numeros4, etoiles4, 0L);
		listeHistoriqueArchivee.add(a4);
		List<Numero> numeros5 = new ArrayList<>();
		numeros5.add(new Numero(43));
		numeros5.add(new Numero(4));
		numeros5.add(new Numero(25));
		numeros5.add(new Numero(16));
		numeros5.add(new Numero(47));
		List<Etoile> etoiles5 = new ArrayList<>();
		etoiles5.add(new Etoile(10));
		etoiles5.add(new Etoile(2));
		ObjetArchiver a5 = new ObjetArchiver(null, new GregorianCalendar(2017,
				1, 17, 21, 0), 0L, numeros5, etoiles5, 0L);
		listeHistoriqueArchivee.add(a5);
		List<Numero> numeros6 = new ArrayList<>();
		numeros6.add(new Numero(17));
		numeros6.add(new Numero(10));
		numeros6.add(new Numero(27));
		numeros6.add(new Numero(49));
		numeros6.add(new Numero(31));
		List<Etoile> etoiles6 = new ArrayList<>();
		etoiles6.add(new Etoile(3));
		etoiles6.add(new Etoile(5));
		ObjetArchiver a6 = new ObjetArchiver(null, new GregorianCalendar(2017,
				1, 20, 21, 0), 0L, numeros6, etoiles6, 0L);
		listeHistoriqueArchivee.add(a6);
		List<Numero> numeros7 = new ArrayList<>();
		numeros7.add(new Numero(5));
		numeros7.add(new Numero(1));
		numeros7.add(new Numero(23));
		numeros7.add(new Numero(17));
		numeros7.add(new Numero(7));
		List<Etoile> etoiles7 = new ArrayList<>();
		etoiles7.add(new Etoile(3));
		etoiles7.add(new Etoile(8));
		ObjetArchiver a7 = new ObjetArchiver(null, new GregorianCalendar(2017,
				1, 24, 21, 0), 0L, numeros7, etoiles7, 0L);
		listeHistoriqueArchivee.add(a7);
		List<Numero> numeros8 = new ArrayList<>();
		numeros8.add(new Numero(28));
		numeros8.add(new Numero(45));
		numeros8.add(new Numero(20));
		numeros8.add(new Numero(17));
		numeros8.add(new Numero(48));
		List<Etoile> etoiles8 = new ArrayList<>();
		etoiles8.add(new Etoile(9));
		etoiles8.add(new Etoile(5));
		ObjetArchiver a8 = new ObjetArchiver(null, new GregorianCalendar(2017,
				1, 27, 21, 0), 0L, numeros8, etoiles8, 0L);
		listeHistoriqueArchivee.add(a8);
		List<Numero> numeros9 = new ArrayList<>();
		numeros9.add(new Numero(4));
		numeros9.add(new Numero(17));
		numeros9.add(new Numero(44));
		numeros9.add(new Numero(23));
		numeros9.add(new Numero(3));
		List<Etoile> etoiles9 = new ArrayList<>();
		etoiles9.add(new Etoile(6));
		etoiles9.add(new Etoile(9));
		ObjetArchiver a9 = new ObjetArchiver(null, new GregorianCalendar(2017,
				1, 31, 21, 0), 0L, numeros9, etoiles9, 0L);
		listeHistoriqueArchivee.add(a9);
		List<Numero> numeros10 = new ArrayList<>();
		numeros10.add(new Numero(3));
		numeros10.add(new Numero(4));
		numeros10.add(new Numero(50));
		numeros10.add(new Numero(46));
		numeros10.add(new Numero(15));
		List<Etoile> etoiles10 = new ArrayList<>();
		etoiles10.add(new Etoile(9));
		etoiles10.add(new Etoile(5));
		ObjetArchiver a10 = new ObjetArchiver(null, new GregorianCalendar(2017,
				2, 3, 21, 0), 0L, numeros10, etoiles10, 0L);
		listeHistoriqueArchivee.add(a10);
		List<Numero> numeros11 = new ArrayList<>();
		numeros11.add(new Numero(44));
		numeros11.add(new Numero(38));
		numeros11.add(new Numero(4));
		numeros11.add(new Numero(31));
		numeros11.add(new Numero(10));
		List<Etoile> etoiles11 = new ArrayList<>();
		etoiles11.add(new Etoile(10));
		etoiles11.add(new Etoile(8));
		ObjetArchiver a11 = new ObjetArchiver(null, new GregorianCalendar(2017,
				2, 7, 21, 0), 0L, numeros11, etoiles11, 0L);
		listeHistoriqueArchivee.add(a11);
		List<Numero> numeros12 = new ArrayList<>();
		numeros12.add(new Numero(43));
		numeros12.add(new Numero(26));
		numeros12.add(new Numero(7));
		numeros12.add(new Numero(35));
		numeros12.add(new Numero(21));
		List<Etoile> etoiles12 = new ArrayList<>();
		etoiles12.add(new Etoile(9));
		etoiles12.add(new Etoile(2));
		ObjetArchiver a12 = new ObjetArchiver(null, new GregorianCalendar(2017,
				2, 10, 21, 0), 0L, numeros12, etoiles12, 0L);
		listeHistoriqueArchivee.add(a12);
		List<Numero> numeros13 = new ArrayList<>();
		numeros13.add(new Numero(44));
		numeros13.add(new Numero(40));
		numeros13.add(new Numero(24));
		numeros13.add(new Numero(2));
		numeros13.add(new Numero(10));
		List<Etoile> etoiles13 = new ArrayList<>();
		etoiles13.add(new Etoile(3));
		etoiles13.add(new Etoile(10));
		ObjetArchiver a13 = new ObjetArchiver(null, new GregorianCalendar(2017,
				2, 14, 21, 0), 0L, numeros13, etoiles13, 0L);
		listeHistoriqueArchivee.add(a13);
		List<Numero> numeros14 = new ArrayList<>();
		numeros14.add(new Numero(25));
		numeros14.add(new Numero(19));
		numeros14.add(new Numero(33));
		numeros14.add(new Numero(36));
		numeros14.add(new Numero(48));
		List<Etoile> etoiles14 = new ArrayList<>();
		etoiles14.add(new Etoile(2));
		etoiles14.add(new Etoile(9));
		ObjetArchiver a14 = new ObjetArchiver(null, new GregorianCalendar(2017,
				2, 17, 21, 0), 0L, numeros14, etoiles14, 0L);
		listeHistoriqueArchivee.add(a14);
		List<Numero> numeros15 = new ArrayList<>();
		numeros15.add(new Numero(19));
		numeros15.add(new Numero(41));
		numeros15.add(new Numero(49));
		numeros15.add(new Numero(13));
		numeros15.add(new Numero(45));
		List<Etoile> etoiles15 = new ArrayList<>();
		etoiles15.add(new Etoile(4));
		etoiles15.add(new Etoile(3));
		ObjetArchiver a15 = new ObjetArchiver(null, new GregorianCalendar(2017,
				2, 21, 21, 0), 0L, numeros15, etoiles15, 0L);
		listeHistoriqueArchivee.add(a15);
		List<Numero> numeros16 = new ArrayList<>();
		numeros16.add(new Numero(13));
		numeros16.add(new Numero(2));
		numeros16.add(new Numero(43));
		numeros16.add(new Numero(22));
		numeros16.add(new Numero(4));
		List<Etoile> etoiles16 = new ArrayList<>();
		etoiles16.add(new Etoile(8));
		etoiles16.add(new Etoile(9));
		ObjetArchiver a16 = new ObjetArchiver(null, new GregorianCalendar(2017,
				2, 24, 21, 0), 0L, numeros16, etoiles16, 0L);
		listeHistoriqueArchivee.add(a16);
		List<Numero> numeros17 = new ArrayList<>();
		numeros17.add(new Numero(35));
		numeros17.add(new Numero(31));
		numeros17.add(new Numero(10));
		numeros17.add(new Numero(42));
		numeros17.add(new Numero(20));
		List<Etoile> etoiles17 = new ArrayList<>();
		etoiles17.add(new Etoile(2));
		etoiles17.add(new Etoile(12));
		ObjetArchiver a17 = new ObjetArchiver(null, new GregorianCalendar(2017,
				2, 28, 21, 0), 0L, numeros17, etoiles17, 0L);
		listeHistoriqueArchivee.add(a17);
		List<Numero> numeros18 = new ArrayList<>();
		numeros18.add(new Numero(47));
		numeros18.add(new Numero(2));
		numeros18.add(new Numero(11));
		numeros18.add(new Numero(29));
		numeros18.add(new Numero(30));
		List<Etoile> etoiles18 = new ArrayList<>();
		etoiles18.add(new Etoile(12));
		etoiles18.add(new Etoile(1));
		ObjetArchiver a18 = new ObjetArchiver(null, new GregorianCalendar(2017,
				3, 3, 21, 0), 0L, numeros18, etoiles18, 0L);
		listeHistoriqueArchivee.add(a18);
		List<Numero> numeros19 = new ArrayList<>();
		numeros19.add(new Numero(6));
		numeros19.add(new Numero(37));
		numeros19.add(new Numero(50));
		numeros19.add(new Numero(41));
		numeros19.add(new Numero(48));
		List<Etoile> etoiles19 = new ArrayList<>();
		etoiles19.add(new Etoile(5));
		etoiles19.add(new Etoile(4));
		ObjetArchiver a19 = new ObjetArchiver(null, new GregorianCalendar(2017,
				3, 7, 21, 0), 0L, numeros19, etoiles19, 0L);
		listeHistoriqueArchivee.add(a19);
		List<Numero> numeros20 = new ArrayList<>();
		numeros20.add(new Numero(38));
		numeros20.add(new Numero(49));
		numeros20.add(new Numero(31));
		numeros20.add(new Numero(47));
		numeros20.add(new Numero(36));
		List<Etoile> etoiles20 = new ArrayList<>();
		etoiles20.add(new Etoile(8));
		etoiles20.add(new Etoile(11));
		ObjetArchiver a20 = new ObjetArchiver(null, new GregorianCalendar(2017,
				3, 10, 21, 0), 0L, numeros20, etoiles20, 0L);
		listeHistoriqueArchivee.add(a20);
		List<Numero> numeros21 = new ArrayList<>();
		numeros21.add(new Numero(21));
		numeros21.add(new Numero(5));
		numeros21.add(new Numero(44));
		numeros21.add(new Numero(36));
		numeros21.add(new Numero(3));
		List<Etoile> etoiles21 = new ArrayList<>();
		etoiles21.add(new Etoile(3));
		etoiles21.add(new Etoile(6));
		ObjetArchiver a21 = new ObjetArchiver(null, new GregorianCalendar(2017,
				3, 14, 21, 0), 0L, numeros21, etoiles21, 0L);
		listeHistoriqueArchivee.add(a21);
		List<Numero> numeros22 = new ArrayList<>();
		numeros22.add(new Numero(19));
		numeros22.add(new Numero(29));
		numeros22.add(new Numero(36));
		numeros22.add(new Numero(6));
		numeros22.add(new Numero(10));
		List<Etoile> etoiles22 = new ArrayList<>();
		etoiles22.add(new Etoile(9));
		etoiles22.add(new Etoile(3));
		ObjetArchiver a22 = new ObjetArchiver(null, new GregorianCalendar(2017,
				3, 17, 21, 0), 0L, numeros22, etoiles22, 0L);
		listeHistoriqueArchivee.add(a22);
		List<Numero> numeros23 = new ArrayList<>();
		numeros23.add(new Numero(47));
		numeros23.add(new Numero(23));
		numeros23.add(new Numero(20));
		numeros23.add(new Numero(44));
		numeros23.add(new Numero(1));
		List<Etoile> etoiles23 = new ArrayList<>();
		etoiles23.add(new Etoile(11));
		etoiles23.add(new Etoile(4));
		ObjetArchiver a23 = new ObjetArchiver(null, new GregorianCalendar(2017,
				3, 21, 21, 0), 0L, numeros23, etoiles23, 0L);
		listeHistoriqueArchivee.add(a23);
		List<Numero> numeros24 = new ArrayList<>();
		numeros24.add(new Numero(2));
		numeros24.add(new Numero(21));
		numeros24.add(new Numero(17));
		numeros24.add(new Numero(27));
		numeros24.add(new Numero(34));
		List<Etoile> etoiles24 = new ArrayList<>();
		etoiles24.add(new Etoile(5));
		etoiles24.add(new Etoile(9));
		ObjetArchiver a24 = new ObjetArchiver(null, new GregorianCalendar(2017,
				3, 24, 21, 0), 0L, numeros24, etoiles24, 0L);
		listeHistoriqueArchivee.add(a24);
		List<Numero> numeros25 = new ArrayList<>();
		numeros25.add(new Numero(33));
		numeros25.add(new Numero(13));
		numeros25.add(new Numero(46));
		numeros25.add(new Numero(9));
		numeros25.add(new Numero(31));
		List<Etoile> etoiles25 = new ArrayList<>();
		etoiles25.add(new Etoile(6));
		etoiles25.add(new Etoile(10));
		ObjetArchiver a25 = new ObjetArchiver(null, new GregorianCalendar(2017,
				3, 28, 21, 0), 0L, numeros25, etoiles25, 0L);
		listeHistoriqueArchivee.add(a25);
		List<Numero> numeros26 = new ArrayList<>();
		numeros26.add(new Numero(24));
		numeros26.add(new Numero(26));
		numeros26.add(new Numero(45));
		numeros26.add(new Numero(17));
		numeros26.add(new Numero(28));
		List<Etoile> etoiles26 = new ArrayList<>();
		etoiles26.add(new Etoile(4));
		etoiles26.add(new Etoile(12));
		ObjetArchiver a26 = new ObjetArchiver(null, new GregorianCalendar(2017,
				3, 31, 21, 0), 0L, numeros26, etoiles26, 0L);
		listeHistoriqueArchivee.add(a26);
		List<Numero> numeros27 = new ArrayList<>();
		numeros27.add(new Numero(24));
		numeros27.add(new Numero(33));
		numeros27.add(new Numero(9));
		numeros27.add(new Numero(1));
		numeros27.add(new Numero(34));
		List<Etoile> etoiles27 = new ArrayList<>();
		etoiles27.add(new Etoile(2));
		etoiles27.add(new Etoile(6));
		ObjetArchiver a27 = new ObjetArchiver(null, new GregorianCalendar(2017,
				4, 4, 21, 0), 0L, numeros27, etoiles27, 0L);
		listeHistoriqueArchivee.add(a27);
		List<Numero> numeros28 = new ArrayList<>();
		numeros28.add(new Numero(35));
		numeros28.add(new Numero(10));
		numeros28.add(new Numero(2));
		numeros28.add(new Numero(50));
		numeros28.add(new Numero(19));
		List<Etoile> etoiles28 = new ArrayList<>();
		etoiles28.add(new Etoile(7));
		etoiles28.add(new Etoile(6));
		ObjetArchiver a28 = new ObjetArchiver(null, new GregorianCalendar(2017,
				4, 7, 21, 0), 0L, numeros28, etoiles28, 0L);
		listeHistoriqueArchivee.add(a28);
		List<Numero> numeros29 = new ArrayList<>();
		numeros29.add(new Numero(22));
		numeros29.add(new Numero(5));
		numeros29.add(new Numero(31));
		numeros29.add(new Numero(49));
		numeros29.add(new Numero(21));
		List<Etoile> etoiles29 = new ArrayList<>();
		etoiles29.add(new Etoile(8));
		etoiles29.add(new Etoile(2));
		ObjetArchiver a29 = new ObjetArchiver(null, new GregorianCalendar(2017,
				4, 11, 21, 0), 0L, numeros29, etoiles29, 0L);
		listeHistoriqueArchivee.add(a29);
		List<Numero> numeros30 = new ArrayList<>();
		numeros30.add(new Numero(33));
		numeros30.add(new Numero(20));
		numeros30.add(new Numero(4));
		numeros30.add(new Numero(14));
		numeros30.add(new Numero(23));
		List<Etoile> etoiles30 = new ArrayList<>();
		etoiles30.add(new Etoile(6));
		etoiles30.add(new Etoile(10));
		ObjetArchiver a30 = new ObjetArchiver(null, new GregorianCalendar(2017,
				4, 14, 21, 0), 0L, numeros30, etoiles30, 0L);
		listeHistoriqueArchivee.add(a30);
		List<Numero> numeros31 = new ArrayList<>();
		numeros31.add(new Numero(22));
		numeros31.add(new Numero(17));
		numeros31.add(new Numero(45));
		numeros31.add(new Numero(38));
		numeros31.add(new Numero(31));
		List<Etoile> etoiles31 = new ArrayList<>();
		etoiles31.add(new Etoile(12));
		etoiles31.add(new Etoile(5));
		ObjetArchiver a31 = new ObjetArchiver(null, new GregorianCalendar(2017,
				4, 18, 21, 0), 0L, numeros31, etoiles31, 0L);
		listeHistoriqueArchivee.add(a31);
		List<Numero> numeros32 = new ArrayList<>();
		numeros32.add(new Numero(2));
		numeros32.add(new Numero(13));
		numeros32.add(new Numero(22));
		numeros32.add(new Numero(49));
		numeros32.add(new Numero(16));
		List<Etoile> etoiles32 = new ArrayList<>();
		etoiles32.add(new Etoile(4));
		etoiles32.add(new Etoile(5));
		ObjetArchiver a32 = new ObjetArchiver(null, new GregorianCalendar(2017,
				4, 21, 21, 0), 0L, numeros32, etoiles32, 0L);
		listeHistoriqueArchivee.add(a32);
		List<Numero> numeros33 = new ArrayList<>();
		numeros33.add(new Numero(11));
		numeros33.add(new Numero(9));
		numeros33.add(new Numero(32));
		numeros33.add(new Numero(19));
		numeros33.add(new Numero(43));
		List<Etoile> etoiles33 = new ArrayList<>();
		etoiles33.add(new Etoile(3));
		etoiles33.add(new Etoile(9));
		ObjetArchiver a33 = new ObjetArchiver(null, new GregorianCalendar(2017,
				4, 25, 21, 0), 0L, numeros33, etoiles33, 0L);
		listeHistoriqueArchivee.add(a33);
		List<Numero> numeros34 = new ArrayList<>();
		numeros34.add(new Numero(20));
		numeros34.add(new Numero(25));
		numeros34.add(new Numero(30));
		numeros34.add(new Numero(39));
		numeros34.add(new Numero(14));
		List<Etoile> etoiles34 = new ArrayList<>();
		etoiles34.add(new Etoile(8));
		etoiles34.add(new Etoile(2));
		ObjetArchiver a34 = new ObjetArchiver(null, new GregorianCalendar(2017,
				4, 28, 21, 0), 0L, numeros34, etoiles34, 0L);
		listeHistoriqueArchivee.add(a34);
		List<Numero> numeros35 = new ArrayList<>();
		numeros35.add(new Numero(27));
		numeros35.add(new Numero(25));
		numeros35.add(new Numero(19));
		numeros35.add(new Numero(6));
		numeros35.add(new Numero(23));
		List<Etoile> etoiles35 = new ArrayList<>();
		etoiles35.add(new Etoile(12));
		etoiles35.add(new Etoile(11));
		ObjetArchiver a35 = new ObjetArchiver(null, new GregorianCalendar(2017,
				5, 2, 21, 0), 0L, numeros35, etoiles35, 0L);
		listeHistoriqueArchivee.add(a35);
		List<Numero> numeros36 = new ArrayList<>();
		numeros36.add(new Numero(7));
		numeros36.add(new Numero(43));
		numeros36.add(new Numero(30));
		numeros36.add(new Numero(3));
		numeros36.add(new Numero(35));
		List<Etoile> etoiles36 = new ArrayList<>();
		etoiles36.add(new Etoile(1));
		etoiles36.add(new Etoile(3));
		ObjetArchiver a36 = new ObjetArchiver(null, new GregorianCalendar(2017,
				5, 5, 21, 0), 0L, numeros36, etoiles36, 0L);
		listeHistoriqueArchivee.add(a36);
		List<Numero> numeros37 = new ArrayList<>();
		numeros37.add(new Numero(26));
		numeros37.add(new Numero(22));
		numeros37.add(new Numero(16));
		numeros37.add(new Numero(12));
		numeros37.add(new Numero(8));
		List<Etoile> etoiles37 = new ArrayList<>();
		etoiles37.add(new Etoile(7));
		etoiles37.add(new Etoile(6));
		ObjetArchiver a37 = new ObjetArchiver(null, new GregorianCalendar(2017,
				5, 9, 21, 0), 0L, numeros37, etoiles37, 0L);
		listeHistoriqueArchivee.add(a37);
		List<Numero> numeros38 = new ArrayList<>();
		numeros38.add(new Numero(2));
		numeros38.add(new Numero(28));
		numeros38.add(new Numero(29));
		numeros38.add(new Numero(44));
		numeros38.add(new Numero(20));
		List<Etoile> etoiles38 = new ArrayList<>();
		etoiles38.add(new Etoile(3));
		etoiles38.add(new Etoile(9));
		ObjetArchiver a38 = new ObjetArchiver(null, new GregorianCalendar(2017,
				5, 12, 21, 0), 0L, numeros38, etoiles38, 0L);
		listeHistoriqueArchivee.add(a38);
		List<Numero> numeros39 = new ArrayList<>();
		numeros39.add(new Numero(20));
		numeros39.add(new Numero(8));
		numeros39.add(new Numero(30));
		numeros39.add(new Numero(11));
		numeros39.add(new Numero(15));
		List<Etoile> etoiles39 = new ArrayList<>();
		etoiles39.add(new Etoile(3));
		etoiles39.add(new Etoile(8));
		ObjetArchiver a39 = new ObjetArchiver(null, new GregorianCalendar(2017,
				5, 16, 21, 0), 0L, numeros39, etoiles39, 0L);
		listeHistoriqueArchivee.add(a39);
		List<Numero> numeros40 = new ArrayList<>();
		numeros40.add(new Numero(30));
		numeros40.add(new Numero(12));
		numeros40.add(new Numero(9));
		numeros40.add(new Numero(19));
		numeros40.add(new Numero(11));
		List<Etoile> etoiles40 = new ArrayList<>();
		etoiles40.add(new Etoile(9));
		etoiles40.add(new Etoile(4));
		ObjetArchiver a40 = new ObjetArchiver(null, new GregorianCalendar(2017,
				5, 19, 21, 0), 0L, numeros40, etoiles40, 0L);
		listeHistoriqueArchivee.add(a40);
		List<Numero> numeros41 = new ArrayList<>();
		numeros41.add(new Numero(15));
		numeros41.add(new Numero(8));
		numeros41.add(new Numero(42));
		numeros41.add(new Numero(25));
		numeros41.add(new Numero(27));
		List<Etoile> etoiles41 = new ArrayList<>();
		etoiles41.add(new Etoile(1));
		etoiles41.add(new Etoile(4));
		ObjetArchiver a41 = new ObjetArchiver(null, new GregorianCalendar(2017,
				5, 23, 21, 0), 0L, numeros41, etoiles41, 0L);
		listeHistoriqueArchivee.add(a41);
		List<Numero> numeros42 = new ArrayList<>();
		numeros42.add(new Numero(36));
		numeros42.add(new Numero(5));
		numeros42.add(new Numero(39));
		numeros42.add(new Numero(7));
		numeros42.add(new Numero(26));
		List<Etoile> etoiles42 = new ArrayList<>();
		etoiles42.add(new Etoile(2));
		etoiles42.add(new Etoile(10));
		ObjetArchiver a42 = new ObjetArchiver(null, new GregorianCalendar(2017,
				5, 26, 21, 0), 0L, numeros42, etoiles42, 0L);
		listeHistoriqueArchivee.add(a42);
		List<Numero> numeros43 = new ArrayList<>();
		numeros43.add(new Numero(27));
		numeros43.add(new Numero(48));
		numeros43.add(new Numero(38));
		numeros43.add(new Numero(12));
		numeros43.add(new Numero(7));
		List<Etoile> etoiles43 = new ArrayList<>();
		etoiles43.add(new Etoile(9));
		etoiles43.add(new Etoile(6));
		ObjetArchiver a43 = new ObjetArchiver(null, new GregorianCalendar(2017,
				5, 30, 21, 0), 0L, numeros43, etoiles43, 0L);
		listeHistoriqueArchivee.add(a43);
		List<Numero> numeros44 = new ArrayList<>();
		numeros44.add(new Numero(8));
		numeros44.add(new Numero(42));
		numeros44.add(new Numero(33));
		numeros44.add(new Numero(24));
		numeros44.add(new Numero(10));
		List<Etoile> etoiles44 = new ArrayList<>();
		etoiles44.add(new Etoile(9));
		etoiles44.add(new Etoile(3));
		ObjetArchiver a44 = new ObjetArchiver(null, new GregorianCalendar(2017,
				6, 2, 21, 0), 0L, numeros44, etoiles44, 0L);
		listeHistoriqueArchivee.add(a44);
		List<Numero> numeros45 = new ArrayList<>();
		numeros45.add(new Numero(25));
		numeros45.add(new Numero(40));
		numeros45.add(new Numero(20));
		numeros45.add(new Numero(22));
		numeros45.add(new Numero(37));
		List<Etoile> etoiles45 = new ArrayList<>();
		etoiles45.add(new Etoile(7));
		etoiles45.add(new Etoile(3));
		ObjetArchiver a45 = new ObjetArchiver(null, new GregorianCalendar(2017,
				6, 6, 21, 0), 0L, numeros45, etoiles45, 0L);
		listeHistoriqueArchivee.add(a45);
		List<Numero> numeros46 = new ArrayList<>();
		numeros46.add(new Numero(9));
		numeros46.add(new Numero(39));
		numeros46.add(new Numero(27));
		numeros46.add(new Numero(20));
		numeros46.add(new Numero(43));
		List<Etoile> etoiles46 = new ArrayList<>();
		etoiles46.add(new Etoile(11));
		etoiles46.add(new Etoile(10));
		ObjetArchiver a46 = new ObjetArchiver(null, new GregorianCalendar(2017,
				6, 9, 21, 0), 0L, numeros46, etoiles46, 0L);
		listeHistoriqueArchivee.add(a46);
		List<Numero> numeros47 = new ArrayList<>();
		numeros47.add(new Numero(12));
		numeros47.add(new Numero(3));
		numeros47.add(new Numero(22));
		numeros47.add(new Numero(27));
		numeros47.add(new Numero(49));
		List<Etoile> etoiles47 = new ArrayList<>();
		etoiles47.add(new Etoile(11));
		etoiles47.add(new Etoile(4));
		ObjetArchiver a47 = new ObjetArchiver(null, new GregorianCalendar(2017,
				6, 13, 21, 0), 0L, numeros47, etoiles47, 0L);
		listeHistoriqueArchivee.add(a47);
		List<Numero> numeros48 = new ArrayList<>();
		numeros48.add(new Numero(38));
		numeros48.add(new Numero(42));
		numeros48.add(new Numero(15));
		numeros48.add(new Numero(17));
		numeros48.add(new Numero(41));
		List<Etoile> etoiles48 = new ArrayList<>();
		etoiles48.add(new Etoile(9));
		etoiles48.add(new Etoile(12));
		ObjetArchiver a48 = new ObjetArchiver(null, new GregorianCalendar(2017,
				6, 16, 21, 0), 0L, numeros48, etoiles48, 0L);
		listeHistoriqueArchivee.add(a48);
		List<Numero> numeros49 = new ArrayList<>();
		numeros49.add(new Numero(11));
		numeros49.add(new Numero(18));
		numeros49.add(new Numero(26));
		numeros49.add(new Numero(43));
		numeros49.add(new Numero(44));
		List<Etoile> etoiles49 = new ArrayList<>();
		etoiles49.add(new Etoile(8));
		etoiles49.add(new Etoile(10));
		ObjetArchiver a49 = new ObjetArchiver(null, new GregorianCalendar(2017,
				6, 20, 21, 0), 0L, numeros49, etoiles49, 0L);
		listeHistoriqueArchivee.add(a49);
		List<Numero> numeros50 = new ArrayList<>();
		numeros50.add(new Numero(3));
		numeros50.add(new Numero(4));
		numeros50.add(new Numero(21));
		numeros50.add(new Numero(31));
		numeros50.add(new Numero(38));
		List<Etoile> etoiles50 = new ArrayList<>();
		etoiles50.add(new Etoile(3));
		etoiles50.add(new Etoile(7));
		ObjetArchiver a50 = new ObjetArchiver(null, new GregorianCalendar(2017,
				6, 23, 21, 0), 0L, numeros50, etoiles50, 0L);
		listeHistoriqueArchivee.add(a50);
		
		

		// forEach de la liste sauvegarder dans la base mongo
		for (ObjetArchiver objetArchiver : listeHistoriqueArchivee) {
			fdjService.archiverTirage(objetArchiver);
		}
		
		messageRetour.setMessage("Historique Tirage piersisté");
		
		return messageRetour;
	}
}