package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Groupe extends AbstractCombattant {

	public List<ICombattant> listeCombattants = new ArrayList<ICombattant>();

	public Groupe() {
		super();
	}

	public Groupe(List<ICombattant> listeCombattants) {
		super();
		this.listeCombattants = listeCombattants;
	}

	public void AddCombattant(ICombattant combattant) {
		listeCombattants.add(combattant);
	}

	public boolean EstMort() {
		boolean sontTousMorts = false;
		int nombreDeMorts = 0;
		for (int i = 0; i < listeCombattants.size(); i++) {
			if (listeCombattants.get(i).getPointDeVie() <= 0) {
				nombreDeMorts++;
			}
		}
		if (nombreDeMorts == listeCombattants.size()) {
			sontTousMorts = true;
		}
		return sontTousMorts;
	}

	public void attaquer(List<ICombattant> adversaires) {
		Random random = new Random();
		int index = random.nextInt(this.listeCombattants.size());
		int degats = 0;
		// Choisit un combattant, aléatoirement, dans cette liste.
		// Si le combattant choisi pour attaquer est un personnage :
		// - Lancer une attaque de sa classe.
		// Sinon, retourner les dégâts du combattant.
		if (this.listeCombattants.get(index) instanceof Personnage) {
			Personnage ic = (Personnage) this.listeCombattants.get(index);
			degats = ic.getClasse().getAttaque().lancerAttaque();
		}
		else {
			ICombattant ic = this.listeCombattants.get(index);
			degats = ic.getDegats();
		}
		this.defendre(degats);
	}

	public void defendre(int degats) {
		Random random = new Random();
		int nb = random.nextInt(this.listeCombattants.size());
		listeCombattants.get(nb).setPointDeVie(listeCombattants.get(nb).getPointDeVie() - degats);
	}

}
