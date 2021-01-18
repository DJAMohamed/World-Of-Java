package main;
public class Personnage extends AbstractCombattant {
	
	int pointDeVie = 0;
	int degat = 0;
	String nom = null;
	
	public Personnage(int pointDeVie, int degat, String nom) {
		super(nom, pointDeVie, degat);
		this.pointDeVie = pointDeVie;
		this.degat = degat;
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
