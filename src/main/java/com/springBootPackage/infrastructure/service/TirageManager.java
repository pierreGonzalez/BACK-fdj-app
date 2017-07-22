package com.springBootPackage.infrastructure.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springBootPackage.domain.Etoile;
import com.springBootPackage.domain.Numero;
import com.springBootPackage.domain.ObjetArchiver;
import com.springBootPackage.domain.StatNombre;
import com.springBootPackage.domain.Tirage;
import com.springBootPackage.domain.data.OccuranceData;

@Service
public class TirageManager {
    public Tirage getTirage(List<ObjetArchiver> listeTirages) {
	Tirage tirageCorrespondant = new Tirage();
	// On fait les stats de sorti de chaque numero des tirages
	// / On créer une liste d'occurance

	List<StatNombre> listeOcNumeros = OccuranceData.getListeStatNumerosEnum();
	List<StatNombre> listeOcEtoiles = OccuranceData.getListeStatEtoilesEnum();

	// On met à jour les occurances de la liste de tirages
	for (ObjetArchiver objetArchiver : listeTirages) {
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
	Collections.sort(listeOcNumeros, (o1, o2) -> o1.getOccurence().compareTo(o2.getOccurence()));
	Collections.sort(listeOcEtoiles, (o1, o2) -> o1.getOccurence().compareTo(o2.getOccurence()));

	// On prend les 15 dernières occurences de listeOcNumeros
	List<Numero> combinaisonNumeros = new ArrayList<>();
	List<Etoile> combinaisonEtoiles = new ArrayList<>();
	Float precision = 0F;
	Float precisionNumeros = 0F;
	Float precisionEtoiles = 0F;
	Integer listeTiragesSize = listeTirages.size();
	// On prend les 5 deniers occurences de listeOcNumros
	for (int i = 1; i <= 15; i++) {
	    Numero numero = new Numero((listeOcNumeros.get(listeOcNumeros.size() - i)).getNombre());
	    combinaisonNumeros.add(numero);
	    // On recupere l'occurence de i
	    Integer ocCourante = listeOcNumeros.get(listeOcNumeros.size() - i).getOccurence();
	    /*
	     * On ajoute l'(occurence courante/au nombre de tirage) à la précision
	     * précédente ce qui revient à faire la moyenne des ratios d'occurence
	     * (occurence/nb de tirage)
	     */
	    precisionNumeros += Float.valueOf((float) ocCourante / (float) listeTiragesSize);
	    precisionNumeros = precisionNumeros / 2;
	}
	// On prend les 4 deniers occurences de listeOcEtoiles
	for (int i = 1; i <= 4; i++) {
	    Etoile etoile = new Etoile((listeOcEtoiles.get(listeOcEtoiles.size() - i)).getNombre());
	    combinaisonEtoiles.add(etoile);
	    // On recupere l'occurence de i
	    Integer ocCourante = listeOcEtoiles.get(listeOcEtoiles.size() - i).getOccurence();
	    /*
	     * On ajoute l'(occurence courante/au nombre de tirage) à la précision
	     * précédente ce qui revient à faire la moyenne des ratio d'occurence
	     * (occurence/nb de tirage)
	     */
	    precisionEtoiles += Float.valueOf((float) ocCourante / (float) listeTiragesSize);
	    precisionEtoiles = precisionEtoiles / 2;
	}

	// On recupère la precision du tirage (moyenne des deux precision)
	precision = 100 * (precisionNumeros + precisionEtoiles) / 2;

	tirageCorrespondant.setPrecision(precision);
	tirageCorrespondant.setNumeros(combinaisonNumeros);
	tirageCorrespondant.setEtoiles(combinaisonEtoiles);

	return tirageCorrespondant;
    }
}
