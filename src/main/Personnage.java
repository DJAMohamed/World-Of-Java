package main;

public class Personnage extends AbstractCombattant {
	
	Classe classe;
	
	public Personnage(int pointDeVie, int degat, String nom, Classe classe) {
		super(nom, pointDeVie, degat);
		this.classe = classe;
	}
	
	@Override
	public void attaquer(ICombattant adversaire) {
		this.degat = this.classe.getAttaque().getDegats();
//		adversaire.defendre(this.classe.getAttaque().lancerAttaque(this, adversaire));
		adversaire.defendre(this.classe.getAttaque().lancerAttaque());
		System.out.println(this.nom + ", vous avez causé " + this.getDegats() + " points de dégâts à " + adversaire.getNom() + ".");
		System.out.println("Points de vie du monstre : " + adversaire.getPointDeVie() + ".");
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
