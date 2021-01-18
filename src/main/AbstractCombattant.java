package main;

abstract class AbstractCombattant {
	public String nom;
	public int pointDeVie;
	public int degat;
	
	public AbstractCombattant() {
		super();
	}

	public AbstractCombattant(String nom, int pointDeVie, int degat) {
		this.nom = nom;
		this.pointDeVie = pointDeVie;
		this.degat = degat;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPointDeVie() {
		return pointDeVie;
	}

	public void setPointDeVie(int pointDeVie) {
		this.pointDeVie = pointDeVie;
	}

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

	@Override
	public String toString() {
		return "AbstractCombattant [Nom = " + this.nom + ", points de vie = " + this.pointDeVie + ", dégâts = " + this.degat + "]";
	}

}