package main;

public class Personnage extends AbstractCombattant {
	
	Classe classe;
	
	public Personnage(int pointDeVie, int degat, String nom, Classe classe) {
		super(nom, pointDeVie, degat);
		this.classe = classe;
	}
	
	public Personnage(String nom, int degats, int pointDeVie, Classe classe) {
        super(nom, degats, pointDeVie);
        this.classe = classe;
    }
	
	public void attaquer(ICombattant adversaire) {
		adversaire.defendre(this.classe.getAttaque().lancerAttaque());
		System.out.println(this.nom + " a attaqué " + adversaire.getNom() + ".");
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
	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String toString() {
		return "Personnage [Points de vie = " + this.pointDeVie + ", dégâts = " + this.degat + ", nom = " + this.nom + "]";
	}

}