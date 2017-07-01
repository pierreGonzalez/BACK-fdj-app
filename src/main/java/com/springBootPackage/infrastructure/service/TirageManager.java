package com.springBootPackage.infrastructure.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springBootPackage.domain.Etoile;
import com.springBootPackage.domain.Numero;
import com.springBootPackage.domain.ObjetArchiver;
import com.springBootPackage.domain.ObjetDateRecu;
import com.springBootPackage.domain.StatNombre;
import com.springBootPackage.domain.Tirage;
import com.springBootPackage.domain.data.OccuranceData;

@Service
public class TirageManager {
	public Tirage getTirage(Long objetDateRecuDistance,List<ObjetArchiver> listReduite) {
		Tirage tirageCorrespondant = new Tirage();
		// On fait les stats de sorti de chaque numero des tirage réduit
		// / On créer une liste d'occurance

		List<StatNombre> listeOcNumeros = OccuranceData.getListeStatNumerosEnum();
		List<StatNombre> listeOcEtoiles=OccuranceData.getListeStatEtoilesEnum();
		// On réduit la listeReduite aux objetArchivé avec une distance
		// terre-lune equivalente (== à 5% près, +ou- 2,5%)
		
		List<ObjetArchiver> listeReduiteDistance = new ArrayList<>();
		for (ObjetArchiver objetArchiver : listReduite) {
			Boolean plusPrCent = objetArchiver.getDistance() >= objetDateRecuDistance * 1.025 ;
			Boolean moinsPrCent = objetArchiver.getDistance() < objetDateRecuDistance * 0.975 ;
			Boolean conditionprCent = plusPrCent || moinsPrCent;
			if( conditionprCent ){
				listeReduiteDistance.add(objetArchiver);
//System.out.println("liste reduite "+objetArchiver);
			}
		}
		
		// On met à jour les occurances de la liste reduite
		for (ObjetArchiver objetArchiver : listeReduiteDistance) {
			// Pour chaque objetArchiver maj l'occurences de ses numeros et
			// etoiles
			for (Numero numero : objetArchiver.getNumeros()) {
				for (StatNombre statNumero : listeOcNumeros) {
					if (numero.getNumero() == statNumero.getNombre()) {
						statNumero.setOccurence(statNumero.getOccurence() + 1);
					}
				}
			}
			for (Etoile etoile : objetArchiver.getEtoiles()) {
				for (StatNombre statEtoile : listeOcEtoiles) {
					if (etoile.getEtoile() == statEtoile.getNombre()) {
						statEtoile.setOccurence(statEtoile.getOccurence() + 1);
					}
				}
			}
		}

		// On range dans l'ordre croissant les occurences
		Collections.sort(listeOcNumeros, (o1, o2) -> o1.getOccurence()
				.compareTo(o2.getOccurence()));
		Collections.sort(listeOcEtoiles, (o1, o2) -> o1.getOccurence()
				.compareTo(o2.getOccurence()));
		
//for (StatNombre oNumero : listeOcNumeros) {
//	System.out.println("oNumero "+oNumero);
//}
//for (StatNombre oEtoile : listeOcEtoiles) {
//	System.out.println("oEtoile "+oEtoile);
//}

		// On prend les 5 dernières occurences de listeOcNumeros
		List<Numero> combinaisonNumeros = new ArrayList<>();
		List<Etoile> combinaisonEtoiles = new ArrayList<>();
		Float precision = 0F;
		Float precisionNumeros = 0F;
		Float precisionEtoiles = 0F;
		Integer listeReduiteDistanceSize = listeReduiteDistance.size();
		// On prend les 5 deniers occurences de listeOcNumros
		for (int i = 1; i <= 5; i++) {
			Numero numero = new Numero((listeOcNumeros.get(listeOcNumeros
					.size() - i)).getNombre());
			combinaisonNumeros.add(numero);
			// On recupere l'occurence de i
			Integer ocCourante = listeOcNumeros.get(listeOcNumeros.size() - i)
					.getOccurence();
			/*
			 * On ajoute l'(occurence courante/au nombre de tirage) à la
			 * précision précédente ce qui revient à faire la moyenne des ratio
			 * d'occurence (occurence/nb de tirage)
			 */
			precisionNumeros += Float.valueOf((float) ocCourante
					/ (float) listeReduiteDistanceSize);
			precisionNumeros = precisionNumeros /2;
		}
		// On prend les 2 deniers occurences de listeOcEtoiles
		for (int i = 1; i <= 2; i++) {
			Etoile etoile = new Etoile((listeOcEtoiles.get(listeOcEtoiles
					.size() - i)).getNombre());
			combinaisonEtoiles.add(etoile);
			// On recupere l'occurence de i
			Integer ocCourante = listeOcEtoiles.get(listeOcEtoiles.size() - i)
					.getOccurence();
			/*
			 * On ajoute l'(occurence courante/au nombre de tirage) à la
			 * précision précédente ce qui revient à faire la moyenne des ratio
			 * d'occurence (occurence/nb de tirage)
			 */
			precisionEtoiles += Float.valueOf((float) ocCourante
					/ (float) listeReduiteDistanceSize);
			precisionEtoiles = precisionEtoiles/2;
		}

		// On recupère la precision du tirage (moyenne des deux precision)
		precision = 100 * (precisionNumeros + precisionEtoiles) / 2;

		tirageCorrespondant.setPrecision(precision);
		tirageCorrespondant.setNumeros(combinaisonNumeros);
		tirageCorrespondant.setEtoiles(combinaisonEtoiles);

		return tirageCorrespondant;
	}
}
