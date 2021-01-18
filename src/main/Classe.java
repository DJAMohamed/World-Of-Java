package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Classe {
	
	public String nom;
	
	public List<IAttaque> attaques =  new ArrayList<IAttaque>();

	public Classe() {
		super();
	}
	
	public Classe(String nom, List<IAttaque> attaques) {
		super();
		this.nom = nom;
		this.attaques = attaques;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<IAttaque> getAttaques() {
		return attaques;
	}

	public void setAttaques(List<IAttaque> attaques) {
		this.attaques = attaques;
	}
	
	public IAttaque getAttaque() {
		Random r = new Random();
		int index = r.nextInt(attaques.size());
		return attaques.get(index);
	}
	
}