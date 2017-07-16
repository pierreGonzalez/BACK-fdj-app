package com.springBootPackage.infrastructure.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.hadoop.mapred.gethistory_jsp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springBootPackage.domain.Distance;
import com.springBootPackage.domain.EquationDroiteDTL;
import com.springBootPackage.domain.Etoile;
import com.springBootPackage.domain.MessageRetour;
import com.springBootPackage.domain.Numero;
import com.springBootPackage.domain.ObjetArchiver;
import com.springBootPackage.domain.ObjetDateRecu;
import com.springBootPackage.domain.StatNombre;
import com.springBootPackage.domain.Tirage;
import com.springBootPackage.domain.data.DistanceTerreLune;
import com.springBootPackage.domain.service.FdjService;
import com.springBootPackage.infrastructure.repository.FdjRepository;

@Service
public class FdjServiceImplV2 implements FdjService {
    private final Logger LOG = LoggerFactory.getLogger(FdjServiceImplV2.class);
    @Inject
    FdjRepository fdjRepository;
    @Inject
    HistoriqueManager historiqueManager;
    @Inject
    TirageManagerV2 tirageManagerV2;

    @Override
    public Tirage getTirage(ObjetDateRecu objetDateRecu) {
	Tirage tirageCorrespondant = new Tirage();

	// Récupère l'historique des tirages dans la base mongo
	List<ObjetArchiver> listeTirages = fdjRepository.findAll();
	/*
	 * Sur tous les tirages on prend les neumero avec la plus grande occurance de
	 * même pour les étoiles puis on créer un combinaison qui n'est jamais sortie
	 */

	// Appel tirage manager V2 on en récupère un objet avec une liste de 15 numero
	// et 4 etoiles
	tirageCorrespondant = tirageManagerV2.getTirage(listeTirages);

	List<Numero> combinaisonNumeros5 = new ArrayList<>();
	List<Etoile> combinaisonEtoiles2 = new ArrayList<>();
	List<Numero> combinaisonNumeros15 = tirageCorrespondant.getNumeros();
	List<Etoile> combinaisonEtoiles4 = tirageCorrespondant.getEtoiles();
	Boolean doublonNumeros = false;
	// tant qu'une nouvelle combinaison n'est pas trouvée on en cherche
	do {
	    // on recupere les numeros
	    combinaisonNumeros5 = getTirageNumeros(combinaisonNumeros15);
	    // on implément tirageCorrespondant pour tester les numeros via une méthode
	    // commune aux étoiles
	    tirageCorrespondant.setNumeros(combinaisonNumeros5);
	    // on verifie les numeros
	    doublonNumeros = verificationDoublon(listeTirages, tirageCorrespondant);
	} while (doublonNumeros);
	
	// on recupere les etoiles
	combinaisonEtoiles2 = getTirageEtoiles(combinaisonEtoiles4);
	tirageCorrespondant.setEtoiles(combinaisonEtoiles2);
	
	return tirageCorrespondant;
    }

    private List<Numero> getTirageNumeros(List<Numero> combinaisonNumeros15) {
	List<Numero> combinaisonNumeros5 = new ArrayList<>();
	// On choisi de façon aléatoire une combinaison de 5 numeros, on shuffle et on
	// prend les 5 derniers
	Collections.shuffle(combinaisonNumeros15);
	for (int i = 1; i <= 5; i++) {
	    Numero numero = combinaisonNumeros15.get(combinaisonNumeros15.size() - i);
	    combinaisonNumeros5.add(numero);
	}
	return combinaisonNumeros5;
    }

    private List<Etoile> getTirageEtoiles(List<Etoile> combinaisonEtoiles4) {
	List<Etoile> combinaisonEtoiles2 = new ArrayList<>();
	// On choisi de façon aléatoire une combinaison de 2 etoiles, on shuffle et on
	// prend les 2 derniers
	Collections.shuffle(combinaisonEtoiles4);
	for (int i = 1; i <= 2; i++) {
	    Etoile etoile = combinaisonEtoiles4.get(combinaisonEtoiles4.size() - i);
	    combinaisonEtoiles2.add(etoile);
	}
	return combinaisonEtoiles2;
    }

    private Boolean verificationDoublon(List<ObjetArchiver> listeTirages, Tirage tirageCorrespondant) {
	Boolean retourVerification = false;
	Integer cptNumero = 0;
	// On recherche dans la table
	// pour chaque element de listeTirages
	for (ObjetArchiver objetArchiver : listeTirages) {
	    // pour chaque numero de objetArchiver
	    for (Numero numero : objetArchiver.getNumeros()) {
		// pour chaque numero de tirageCorrespondant
		for (Numero numeroTc : tirageCorrespondant.getNumeros()) {
		    // si egalité on incrémente sinon on le met égal à lui même
		    cptNumero = (numeroTc == numero) ? (cptNumero + 1) : cptNumero;
		}
	    }
	    // si cptNumero > 5 retourVerification est false
	    retourVerification = (cptNumero > 5) ? true : false;
	}
	return retourVerification;
    }

    @Override
    public MessageRetour archiverTirage(ObjetArchiver objetArchiver) {
	MessageRetour messageRetour = new MessageRetour();

	// On set l'heure à 21h00
	objetArchiver.getDate().set(Calendar.HOUR_OF_DAY, 21);
	objetArchiver.getDate().set(Calendar.MINUTE, 0);
	// Implémenter la base mongo le tirage
	fdjRepository.save(objetArchiver);

	messageRetour.setMessage("Tirage archivé");
	return messageRetour;
    }

    @Override
    public MessageRetour persisteHistorique() {
	MessageRetour messageRetour = historiqueManager.initialisation();
	return messageRetour;
    }

    @Override
    public List<ObjetArchiver> recupererHistorique() {

	List<ObjetArchiver> listeObjetTiragePersistee = new ArrayList<>();
	// Récuperer la liste des tirage en base
	listeObjetTiragePersistee = fdjRepository.findAll();
	return listeObjetTiragePersistee;
    }

    @Override
    public void deleteArchive(String id) {
	fdjRepository.delete(id);
    }

}
