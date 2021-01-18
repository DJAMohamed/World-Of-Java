package main;

public class Personnage extends AbstractCombattant {
	
	public Personnage(int pointDeVie, int degat, String nom) {
		super(nom, pointDeVie, degat);
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Personnage [Points de vie = " + this.pointDeVie + ", dégâts = " + this.degat + ", nom = " + this.nom + "]";
	}
	
}
