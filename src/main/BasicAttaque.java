package main;

import java.util.Random;

class BasicAttaque implements IAttaque {

	public String nom;
	public String description;
	public int degats;
	public double chanceToucher;

	public BasicAttaque(String nom, String description, int degats, double chanceToucher) {
		this.nom = nom;
		this.description = description;
		this.degats = degats;
		this.chanceToucher = chanceToucher;
	}
	
	public int lancerAttaque(ICombattant lanceur, ICombattant cible) {
		Random r = new Random();
		int n = r.nextInt(101);
		if (n < this.getChanceToucher()) {
			return lanceur.getDegats();
		} else {
			System.out.println("Échec...");
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
		this.chanceToucher = chanceToucher;
	}

}