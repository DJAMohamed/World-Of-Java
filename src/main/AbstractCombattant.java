package main;
abstract class AbstractCombattant {
	public String nom;
	public int pointDeVie;
	public int degat;

	
	public AbstractCombattant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AbstractCombattant(String nom, int pointDeVie, int degat) {
		this.nom = nom;
		this.pointDeVie = pointDeVie;
		this.degat = degat;
	}

	@Override
	public String toString() {
		return "AbstractCombattant [Nom = " + this.nom + ", points de vie = " + this.pointDeVie + ", dégâts = " + this.degat + "]";
	}

}