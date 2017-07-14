package com.springBootPackage.domain.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springBootPackage.domain.MessageRetour;
import com.springBootPackage.domain.ObjetArchiver;
import com.springBootPackage.domain.ObjetDateRecu;
import com.springBootPackage.domain.Tirage;

@Component
public interface FdjService {
	public Tirage getTirage(ObjetDateRecu objetDateRecu );
	public MessageRetour archiverTirage(ObjetArchiver objetArchiver);
	public MessageRetour persisteHistorique();
	public void deleteArchive(String id);
	public List<ObjetArchiver> recupererHistorique();
}
