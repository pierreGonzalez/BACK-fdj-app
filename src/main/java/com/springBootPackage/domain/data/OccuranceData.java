package com.springBootPackage.domain.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.springBootPackage.domain.StatNombre;


public enum OccuranceData {
	 n1 (0, 1),
	 n2 (0, 2),
	 n3 (0, 3),
	 n4 (0, 4),
	 n5 (0, 5),
	 n6 (0, 6),
	 n7 (0, 7),
	 n8 (0, 8),
	 n9 (0, 9),
	 n10 (0, 10),
	 n11 (0, 11),
	 n12 (0, 12),
	 n13 (0, 13),
	 n14 (0, 14),
	 n15 (0, 15),
	 n16 (0, 16),
	 n17 (0, 17),
	 n18 (0, 18),
	 n19 (0, 19),
	 n20 (0, 20),
	 n21 (0, 21),
	 n22 (0, 22),
	 n23 (0, 23),
	 n24 (0, 24),
	 n25 (0, 25),
	 n26 (0, 26),
	 n27 (0, 27),
	 n28 (0, 28),
	 n29 (0, 29),
	 n30 (0, 30),
	 n31 (0, 31),
	 n32 (0, 32),
	 n33 (0, 33),
	 n34 (0, 34),
	 n35 (0, 35),
	 n36 (0, 36),
	 n37 (0, 37),
	 n38 (0, 38),
	 n39 (0, 39),
	 n40 (0, 40),
	 n41 (0, 41),
	 n42 (0, 42),
	 n43 (0, 43),
	 n44 (0, 44),
	 n45 (0, 45),
	 n46 (0, 46),
	 n47 (0, 47),
	 n48 (0, 48),
	 n49 (0, 49),
	 n50 (0, 50);
	
	private Integer occurence;
	private Integer nombre;
	

	private OccuranceData(Integer occurence, Integer nombre) {
		this.occurence = occurence;
		this.nombre = nombre;
	}
	public Integer getOccurence() {
		return occurence;
	}
	public void setOccurence(Integer occurence) {
		this.occurence = occurence;
	}
	public Integer getNombre() {
		return nombre;
	}
	public void setNombre(Integer nombre) {
		this.nombre = nombre;
	}
	
	public static final List<StatNombre> getListeStatNumerosEnum() {
		List<OccuranceData> listeEnum = Arrays.asList(OccuranceData
				.values());
		List<StatNombre> listeStatNombre = new ArrayList<>();
		for (OccuranceData enumListe : listeEnum) {
			StatNombre statNombre = new StatNombre();
			statNombre.setNombre(enumListe.getNombre());
			statNombre.setOccurence(enumListe.getOccurence());
			listeStatNombre.add(statNombre);
		}
		return listeStatNombre;
	}
	public static final List<StatNombre> getListeStatEtoilesEnum() {
		List<StatNombre> listeStatNombre = new ArrayList<>();
		
		for (int i = 0; i < 13; i++) {
			StatNombre statNombre = new StatNombre();
			statNombre.setNombre((OccuranceData.values())[i].getNombre());
			statNombre.setOccurence((OccuranceData.values())[i].getOccurence());
			listeStatNombre.add(statNombre);
		}
		return listeStatNombre;
	}
}
