package com.springBootPackage.infrastructure.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springBootPackage.domain.Etoile;
import com.springBootPackage.domain.Numero;
import com.springBootPackage.domain.ObjetArchiver;
import com.springBootPackage.domain.ObjetDateRecu;
import com.springBootPackage.domain.Tirage;
import com.springBootPackage.infrastructure.repository.FdjRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
/**
 * Les fonctionnalités principales de l'application sont "jouer" et "archiver", les
 * autres sont secondaires.</br>
 * La fonction "jouer" se traduit pas la méthode getTirage() et ses méthodes
 * filles.</br>
 * La fonction "archiver" se traduit par une opération CRUD (en l'occurence save)
 * de l'interface fdjRepository. La tester n'est pas nécessaire</br>
 * 
 * Test de la fonctionnalité "jouer"
 * Ces 6 tests couvrent 60% des méthodes de la couche infrastructure.</br>
 * Ces 6 tests ne couvrent que 20% des fonctionnalités de l'application.
 * Cependant ces 20% représentent 80% de son utilisation.
 * 
 * @author Pierre
 *
 */
public class FdjServiceImplTest {

    @Autowired
    private FdjServiceImpl fdjServiceImpl;
    @Autowired
    private FdjRepository fdjRepository;
    @Autowired
    private TirageManager tirageManager;

    @Test
    public void testerFomatObjetTirageDeGetTirage() {
	/* Préparation de objetDateRecu */
	ObjetDateRecu objetDateRecu = new ObjetDateRecu(new Date());
	
	/* Préparation du test */
	Tirage tirage = this.fdjServiceImpl.getTirage(objetDateRecu);
	
	/* Test */
	assertThat(tirage.getNumeros()).asList();
	assertThat(tirage.getEtoiles()).asList();
	assertThat(tirage.getNumeros()).hasSize(5);
	assertThat(tirage.getEtoiles()).hasSize(2);
    }

    @Test
    public void testerFormatListNumerosDeGetTirageNumeros() {
	/* Préparation combinaison15Numeros */
	List<Numero> combinaison15Numeros = new ArrayList<Numero>();
	for (int i = 1; i < 16; i++) {
	    combinaison15Numeros.add(new Numero(i));
	}
	
	/* Préparation du test */
	List<Numero> combinaisonNumeros5 = this.fdjServiceImpl.getTirageNumeros(combinaison15Numeros);
	
	/* Test */
	assertThat(combinaisonNumeros5).hasSize(5);
    }

    @Test
    public void testerFormatListNumerosDeGetTirageEtoiles() {
	/* Préparation combinaison4Etoiles */
	List<Etoile> combinaison4Etoiles = new ArrayList<Etoile>();
	for (int i = 1; i < 5; i++) {
	    combinaison4Etoiles.add(new Etoile(i));
	}
	
	/* Préparation du test */
	List<Etoile> combinaison2Etoiles = this.fdjServiceImpl.getTirageEtoiles(combinaison4Etoiles);
	
	/* Test */
	assertThat(combinaison2Etoiles).hasSize(2);
    }

    @Test
    public void testerRetourDeVerificationDoublon() {
	/* Préparation de listeTirages */
	List<ObjetArchiver> listeTirages = new ArrayList<ObjetArchiver>();
        	/* Préparation de (ObjetArchiver) a1 */
        	List<Numero> numeros1 = new ArrayList<>();
        	for (int i = 6; i < 11; i++) {
        	    numeros1.add(new Numero(i));
        	}
        	List<Etoile> etoiles1 = new ArrayList<>();
        	for (int j = 3; j < 6; j++) {
        	    etoiles1.add(new Etoile(j));
        	}
        	ObjetArchiver a1 = new ObjetArchiver(null, new GregorianCalendar(2017, 0, 1, 21, 0), numeros1, etoiles1);
        	listeTirages.add(a1);
        	/* Préparation de (ObjetArchiver) a2 */
        	List<Numero> numeros2 = new ArrayList<>();
        	for (int i = 1; i < 6; i++) {
        	    numeros2.add(new Numero(i));
        	}
        	List<Etoile> etoiles2 = new ArrayList<>();
        	for (int j = 1; j < 3; j++) {
        	    etoiles2.add(new Etoile(j));
        	}
        	ObjetArchiver a2 = new ObjetArchiver(null, new GregorianCalendar(2017, 0, 2, 21, 0), numeros2, etoiles2);
        	listeTirages.add(a2);

	/* Préparation de tirageCorrespondant (doublon de a2) */
	List<Numero> numeros = a2.getNumeros();
	List<Etoile> etoiles = a2.getEtoiles();
	
	Tirage tirageCorrespondant = new Tirage(0F, numeros, etoiles);
	
	/* Préparation du test */
	Boolean verificationDoublon = this.fdjServiceImpl.verificationDoublon(listeTirages, tirageCorrespondant);

	/* Test */
	assertThat(verificationDoublon).isEqualTo(true);
    }
    
    @Test
    public void testerRetourTirageManager() {
	/* Préparation de listeTirages */
	List<ObjetArchiver> listeTirages = fdjRepository.findAll();
	
	/* Préparation du test */
	Tirage tirage = this.tirageManager.getTirage(listeTirages);
	
	/* Test */
	assertThat(tirage.getNumeros()).asList();
	assertThat(tirage.getEtoiles()).asList();
	assertThat(tirage.getNumeros()).hasSize(15);
	assertThat(tirage.getEtoiles()).hasSize(4);
	
    }

}
