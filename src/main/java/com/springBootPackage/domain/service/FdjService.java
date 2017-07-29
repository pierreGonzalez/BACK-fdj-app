package com.springBootPackage.domain.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springBootPackage.domain.Etoile;
import com.springBootPackage.domain.MessageRetour;
import com.springBootPackage.domain.Numero;
import com.springBootPackage.domain.ObjetArchiver;
import com.springBootPackage.domain.ObjetDateRecu;
import com.springBootPackage.domain.Tirage;

@Component
public interface FdjService {

    /**
     * Methode qui recupère un tirage : { Float precision, List<Numero> numeros,
     * List<Etoile> etoiles } <br/>
     * La liste de numeros et des etoiles sont choisi en fontion de leur occurences
     * propre. Si la liste de numeros contient plus de 4 numeros similaire avec un
     * des tirage en base, on réitère la génération <br/>
     * La précision est estimée en faisant la moyenne des occurance/nombre de sortie
     * 
     * @param objetDateRecu
     * @return Tirage
     */
    public Tirage getTirage(ObjetDateRecu objetDateRecu);

    /**
     * Methode qui permet d'archiver le tirage passé en paramètre dans la base Mongo
     * 
     * @param objetArchiver
     * @return message de confirmation
     */
    public MessageRetour archiverTirage(ObjetArchiver objetArchiver);

    /**
     * Methode qui permet de reseter la base mongo avec des valeurs de base
     * 
     * @return message de confirmation
     */
    public MessageRetour persisteHistorique();

    /**
     * Methode qui permet de supprimer un element de la base
     * 
     * @param id
     */
    public void deleteArchive(String id);

    /**
     * Methode qui permet de récuperer la liste de tous les tirages en base
     * 
     * @return liste de tous les tirages
     */
    public List<ObjetArchiver> recupererHistorique();
}
