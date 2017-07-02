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
		List<ObjetArchiver> listTirages = fdjRepository.findAll();
		List<ObjetArchiver> listReduite = new ArrayList<>();

		// On reduit la liste si le mois de la date est egal à +ou- mois de la
		// date reçus (impacte solaire)
		if (listTirages.size() > 0) {
			listTirages
					.forEach(objetArchive -> {
						int monthEnbase = objetArchive.getDate().get(
								Calendar.MONTH);
						int monthRecus = objetDateRecu.getCalDate().get(
								Calendar.MONTH);

						boolean egal = monthEnbase == monthRecus;
						boolean supPlusUn = (monthEnbase + 1) == monthRecus;
						boolean infMoinsUn = (monthEnbase - 1) == monthRecus;
						boolean conditionListeReduite = egal || supPlusUn
								|| infMoinsUn;

						if (conditionListeReduite) {
							listReduite.add(objetArchive);
						}
					});

			// On calcul la distance pour la date choisi et on l'ajout à
			// objetDateRecu
			if (listReduite.size() > 0) {
				Long objetDateRecuDistance = getDistance(objetDateRecu
						.getCalDate());

				Long difference = 0L;
				Long superieur;
				Long inferieur;

				for (ObjetArchiver objetArchiveDistance : listReduite) {
					// On determine entre le couple de valeur laquelle est
					// superieure
					// pour en faire la difference
					inferieur = objetArchiveDistance.getDistance() > objetDateRecuDistance ? objetArchiveDistance
							.getDistance() : objetDateRecuDistance;
					superieur = objetArchiveDistance.getDistance() < objetDateRecuDistance ? objetArchiveDistance
							.getDistance() : objetDateRecuDistance;
					difference = superieur - inferieur;
					// On met à jour la difference calculée pour l'utiliser plus
					// tard
					objetArchiveDistance.setDifference(difference);
				}

				tirageCorrespondant = tirageManager.getTirage(objetDateRecuDistance,listReduite);



			}
			// si listeReduite est vide, on renvoie l'objet null
		}
		// si listeTirage est vide, renvoie l'objer null

		return tirageCorrespondant;
	}

	private Long getDistance(Calendar dateTirage) {
		Long distance = 0L;
		// On estime la distance Terre Lune à la date depuis l'enum
		// DistanceTerreLune
		List<Distance> listeObjDistance = DistanceTerreLune
				.getListeObjetDistanceAvecValeurEnum();
		Long dateDiff = 0L;
		// on cherche la date de l'enum la plus proche de la dateTirage
		for (Distance objetDistance : listeObjDistance) {

			if (dateTirage.getTimeInMillis() > objetDistance.getDate()
					.getTimeInMillis()) {
				dateDiff = dateTirage.getTimeInMillis()
						- objetDistance.getDate().getTimeInMillis();
			} else {
				dateDiff = objetDistance.getDate().getTimeInMillis()
						- dateTirage.getTimeInMillis();
			}
			objetDistance.setDifference(dateDiff);
		}
		// On recupere l'index de la plus proche date
		int i = 0, indice_min = listeObjDistance.size() - 1;
		while (i < listeObjDistance.size()) {
			if (listeObjDistance.get(i).getDifference() < listeObjDistance.get(
					indice_min).getDifference()) {
				indice_min = i;
			}
			i++;
		}
		// On recupere l'objetDistance à l'index trouvé
		Distance objetDistance = listeObjDistance.get(indice_min);

		/*
		 * Pour estimer la distance terre-lune on utilise une équation de droite
		 * y=ax+b Determination de la droite
		 */
		EquationDroiteDTL equation = new EquationDroiteDTL();

		Boolean dateTirageSup = dateTirage.getTimeInMillis() > objetDistance
				.getDate().getTimeInMillis();
		Distance pointB = getPointB(objetDistance, dateTirageSup, indice_min);
		Long x1 = objetDistance.getDate().getTimeInMillis();
		Long y1 = objetDistance.getDistance();
		Long x2 = pointB.getDate().getTimeInMillis();
		Long y2 = pointB.getDistance();
		equation = equation.getEquation(x1, y1, x2, y2);

		// Estimation de la distance pour
		distance = equation.getYdistance(equation, dateTirage);

		return distance;
	}

	private Distance getPointB(Distance pointA, Boolean dateTirageSup,
			Integer index) {
		Distance distance = new Distance();
		DistanceTerreLune distanceTerreLune = null;

		if (dateTirageSup) {
			distanceTerreLune = DistanceTerreLune.getSuivant(pointA, index);
		} else {
			distanceTerreLune = DistanceTerreLune.getPrecedent(pointA, index);
		}
		distance.setDate(distanceTerreLune.getDate());
		distance.setDifference(distanceTerreLune.getDifference());
		distance.setDistance(distanceTerreLune.getDistance());
		distance.setApogee(distanceTerreLune.getApogee());

		return distance;
	}

	@Override
	public MessageRetour archiverTirage(ObjetArchiver objetArchiver) {
		MessageRetour messageRetour = new MessageRetour();
		// On recupère la distance correspondant à la date de objetArchiver
		// recus
		objetArchiver.setDistance(getDistance(objetArchiver.getDate()));
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

}
