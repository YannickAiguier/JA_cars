package com.campus.cars;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

//la classe des voitures

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Length(min=2, max=20, message="La marque doit contenir de 2 à 20 caractères")
	@NotBlank
	private String marque;
	
	@NotBlank
	private String modele;
	
	@NotBlank
	private String couleur;
	
	/**
	 * @param id
	 * @param marque
	 * @param modele
	 * @param couleur
	 */
	public Car(int id, String marque, String modele, String couleur) {
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
	}
	
	public Car() {
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}
	
	/**
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", marque=" + marque + ", modele=" + modele + ", couleur=" + couleur + "]";
	}
	
	

}
