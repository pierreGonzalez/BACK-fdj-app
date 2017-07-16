package com.springBootPackage.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBootPackage.domain.MessageRetour;
import com.springBootPackage.domain.ObjetArchiver;
import com.springBootPackage.domain.ObjetDateRecu;
import com.springBootPackage.domain.Tirage;
import com.springBootPackage.domain.service.FdjService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("fdj")
public class FdjRessource {
    private final Logger LOG = LoggerFactory.getLogger(FdjRessource.class);
    @Inject
    FdjService fdjService;

    @PostMapping("/public/jouer")
    public Tirage jouer(@RequestBody ObjetDateRecu objetDateRecu) {
	Tirage tirage = new Tirage();
	LOG.info("Demande Récuperation du tirage");
	if (objetDateRecu.getCalDate() == null) {
	    LOG.info("L'archivage à échoué : date est null");
	} else {
	    tirage = fdjService.getTirage(objetDateRecu);
	    LOG.info("Récuperation faite");
	}
	return tirage;
    }

    @PostMapping("/private/archiver")
    public MessageRetour archiver(@RequestBody ObjetArchiver objetArchiver) {
	MessageRetour message = new MessageRetour();
	LOG.info("Demande d'archivage du tirage");
	if (objetArchiver.getId() == null || objetArchiver.getDate() == null || objetArchiver.getNumeros() == null) {
	    message.setMessage("L'archivage à échoué : id ou date est null");
	    LOG.info("L'archivage à échoué : id ou date est null");
	} else {
	    message = fdjService.archiverTirage(objetArchiver);
	    LOG.info("Tirage archivé");
	}
	return message;
    }

    @GetMapping("/private/implementermongo")
    public MessageRetour implementerMongo() {
	MessageRetour messageRetour = new MessageRetour();
	LOG.info("Demande persistence historique");

	messageRetour = fdjService.persisteHistorique();

	LOG.info("Historique Tirage persité");
	return messageRetour;
    }

    @GetMapping("/private/lecturemongo")
    public List<ObjetArchiver> lectureMongo() {
	List<ObjetArchiver> listObjetTirage = new ArrayList<>();
	LOG.info("Demande récupération historique");

	listObjetTirage = fdjService.recupererHistorique();

	LOG.info("Liste envoyé");
	return listObjetTirage;
    }

    @DeleteMapping("/private/archiver")
    public void deleteArchive(@RequestParam("id") String id) {
	LOG.info("Demande de suppression d'une archive" + id);
	fdjService.deleteArchive(id);
	LOG.info("Suppression faite");
    }

    @GetMapping("/private/recupererUserName")
    public String recupererUserName (Authentication authentication) {
	LOG.info("Demande UserName");
	String userName = authentication.getName();
	String retour = StringUtils.capitalize(userName);
	LOG.info("UserName retourné");
	return retour;
    }
}
