package com.campus.cars;

public class Car {
	private int id;
	private String modele;
	private String marque;
	private String couleur;
	
	/**
	 * @param id
	 * @param modele
	 * @param marque
	 * @param couleur
	 */
	public Car(int id, String modele, String marque, String couleur) {
		this.id = id;
		this.modele = modele;
		this.marque = marque;
		this.couleur = couleur;
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
		return "Car [id=" + id + ", modele=" + modele + ", marque=" + marque + ", couleur=" + couleur + "]";
	}
	
	

}
