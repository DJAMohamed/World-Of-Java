package main;

abstract class AbstractCombattant implements ICombattant {
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

	public int getDegats() {
		return degat;
	}

	public void setDegats(int degat) {
		this.degat = degat;
	}
	
//	Appeler la m�thode D�fense de l'adversaire pass� en param�tre.
//	Afficher un message pour notifier de l'attaque.
	public void attaquer(ICombattant adversaire) {
		System.out.println(adversaire.getNom() + " a �t� attaqu�.");		
		adversaire.defendre(this.degat);
	}
	
//	Soustraire aux points de vie les d�g�ts pass�s en param�tre.
	public void defendre(int degats) {
		this.setPointDeVie(this.getPointDeVie() - degats);
	}

	@Override
	public String toString() {
		return "AbstractCombattant [Nom = " + this.nom + ", points de vie = " + this.pointDeVie + ", d�g�ts = "
				+ this.degat + "]";
	}

}