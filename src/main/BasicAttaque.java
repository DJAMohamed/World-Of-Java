package main;

import java.util.Random;

class BasicAttaque implements IAttaque {

	public String nom;
	public String description;
	public int degats;
	public double chanceToucher;
	
	public BasicAttaque() {
		super();
	}

	public BasicAttaque(String nom, String description, int degats, double chanceToucher) {
		this.nom = nom;
		this.description = description;
		this.degats = degats;
		this.chanceToucher = chanceToucher;
	}
	
	public int lancerAttaque() {
		Random r = new Random();
		double nombre = r.nextDouble() * 100;
		if (nombre < this.getChanceToucher()) {
			return this.getDegats();
		} else {
			System.out.println("L'attaque a échoué...\n");
			return 0;
		}
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public int getDegats() {
		return this.degats;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public double getChanceToucher() {
		return this.chanceToucher;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void setDegats(int degats) {
		this.degats = degats;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setChanceToucher(double chanceToucher) {
		if ((chanceToucher >= 0) && (chanceToucher <= 0)) {
			this.chanceToucher = chanceToucher;
		}
		else {
			System.out.println("La chance de toucher doit appartenir à l'intervalle [0, 100]");
		}
	}

	@Override
	public String toString() {
		return "Basic Attaque [Nom = " + this.nom + ", description = " + this.description + ", dégâts = " + this.degats + ", chance de toucher = "
				+ this.chanceToucher + "]";
	}

}