package com.springBootPackage.infrastructure.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springBootPackage.domain.Etoile;
import com.springBootPackage.domain.MessageRetour;
import com.springBootPackage.domain.Numero;
import com.springBootPackage.domain.ObjetArchiver;
import com.springBootPackage.domain.ObjetDateRecu;
import com.springBootPackage.domain.Tirage;
import com.springBootPackage.domain.service.FdjService;
import com.springBootPackage.infrastructure.repository.FdjRepository;

@Service
public class FdjServiceImpl implements FdjService {
    private final Logger LOG = LoggerFactory.getLogger(FdjServiceImpl.class);
    @Inject
    FdjRepository fdjRepository;
    @Inject
    HistoriqueManager historiqueManager;
    @Inject
    TirageManager tirageManager;

    @Override
    public Tirage getTirage(ObjetDateRecu objetDateRecu) {
	Tirage tirageCorrespondant = new Tirage();

	// Récupère l'historique des tirages dans la base mongo
	List<ObjetArchiver> listeTirages = fdjRepository.findAll();
	/*
	 * Appel de tirageManager pour récupèrer un objet avec une liste de 15 numeros
	 * et 4 etoiles
	 */
	tirageCorrespondant = tirageManager.getTirage(listeTirages);

	List<Numero> combinaisonNumeros5 = new ArrayList<>();
	List<Etoile> combinaisonEtoiles2 = new ArrayList<>();
	List<Numero> combinaisonNumeros15 = tirageCorrespondant.getNumeros();
	List<Etoile> combinaisonEtoiles4 = tirageCorrespondant.getEtoiles();
	Boolean doublonNumeros = false;
	/*
	 * Tant qu'une nouvelle combinaison n'est pas trouvée et validée on en en génère
	 * une nouvelle
	 */
	do {
	    // On recupère les numeros
	    combinaisonNumeros5 = getTirageNumeros(combinaisonNumeros15);
	    // On implément tirageCorrespondant pour tester les numeros
	    tirageCorrespondant.setNumeros(combinaisonNumeros5);
	    // On verifie les numeros avec verificationDoublon()
	    doublonNumeros = verificationDoublon(listeTirages, tirageCorrespondant);
	} while (doublonNumeros);

	// On récupere les etoiles
	combinaisonEtoiles2 = getTirageEtoiles(combinaisonEtoiles4);
	tirageCorrespondant.setEtoiles(combinaisonEtoiles2);

	return tirageCorrespondant;
    }

    /**
     * On shuffle et on prend les 5 derniers numéros de la liste de 15 numeros de
     * combinaison15Numeros
     */
    private List<Numero> getTirageNumeros(List<Numero> combinaison15Numeros) {
	List<Numero> combinaisonNumeros5 = new ArrayList<>();

	Collections.shuffle(combinaison15Numeros);
	for (int i = 1; i < 6; i++) {
	    Numero numero = combinaison15Numeros.get(combinaison15Numeros.size() - i);
	    combinaisonNumeros5.add(numero);
	}
	return combinaisonNumeros5;
    }

    /**
     * On shuffle et on prend les 2 dernières étoiles de la liste de 4 étoiles
     * combinaison4Etoiles
     */
    private List<Etoile> getTirageEtoiles(List<Etoile> combinaison4Etoiles) {
	List<Etoile> combinaisonEtoiles2 = new ArrayList<>();

	Collections.shuffle(combinaison4Etoiles);
	for (int i = 1; i <= 2; i++) {
	    Etoile etoile = combinaison4Etoiles.get(combinaison4Etoiles.size() - i);
	    combinaisonEtoiles2.add(etoile);
	}
	return combinaisonEtoiles2;
    }

    /**
     * On vérifie qu'un tirage similaire à 4 numero près n'est pas déjà sorti
     * (existant en base)
     */
    private Boolean verificationDoublon(List<ObjetArchiver> listeTirages, Tirage tirageCorrespondant) {
	Boolean retourVerification = false;
	Integer cptNumero = 0;

	// On créer une liste à deux dimensions (liste de liste)
	List<List> listeDeListeNumeroInteger = new ArrayList<List>();

	/*
	 * On implément listeDeListeNumeroInteger avec les listes de numeros provenant
	 * des tirages en base (listeTirages)
	 */
	for (ObjetArchiver objetArchiver : listeTirages) {

	    List<Integer> listeNumerosInteger = new ArrayList<>();
	    for (Numero numero : objetArchiver.getNumeros()) {
		listeNumerosInteger.add(numero.getNumero());
	    }
	    // On ordonne chaque liste pour faciliter une future comparaison
	    Collections.sort(listeNumerosInteger);
	    // Implémentation de listeDeListeNumeroInteger
	    listeDeListeNumeroInteger.add(listeNumerosInteger);
	}

	/*
	 * On implémente une liste des numeros du tirage passée en paramètre (correspond
	 * à celui demandé par le Front)
	 */
	List<Integer> listeNumerosTcInteger = new ArrayList<>();
	for (Numero numeroTc : tirageCorrespondant.getNumeros()) {
	    listeNumerosTcInteger.add(numeroTc.getNumero());
	}
	// On ordonne la liste pour faciliter une future comparaison
	Collections.sort(listeNumerosTcInteger);

	/*
	 * On compare la liste demandée à chaque liste en base
	 * Une comparaison numéro par numéro est exécutée
	 */
	Integer cptDoublons = 0;
	Integer cptTemporaire = 0;
	for (List<Integer> list : listeDeListeNumeroInteger) {
	    if (cptDoublons < cptTemporaire) {
		cptDoublons = cptTemporaire;
	    }
	    cptTemporaire = 0;
	    for (Integer integer : list) {
		for (Integer integerTc : listeNumerosTcInteger) {
		    if (integer == integerTc) {
			cptTemporaire++;
		    }
		}
	    }
	}
	/*
	 * Si le tirage demandé n'a aucune correspondance à 4 numéros près on valide le
	 * tirage demandé (true) sinon on le réfute (false)
	 */
	retourVerification = (cptDoublons < 4) ? true : false;
	return retourVerification;
    }

    @Override
    public MessageRetour archiverTirage(ObjetArchiver objetArchiver) {
	MessageRetour messageRetour = new MessageRetour();

	// On set l'heure à 21h00 (heure local)
	objetArchiver.getDate().set(Calendar.HOUR_OF_DAY, 19);
	objetArchiver.getDate().set(Calendar.MINUTE, 0);
	// Implémentation de la base mongo le tirage
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
	// Récuperation la liste des tirages en base
	listeObjetTiragePersistee = fdjRepository.findAll();
	return listeObjetTiragePersistee;
    }

    @Override
    public void deleteArchive(String id) {
	fdjRepository.delete(id);
    }

}
