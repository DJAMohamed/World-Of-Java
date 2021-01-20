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

	/**
	 * Cette méthode parcourt la liste des combattants du groupe et vérifie si ils sont tous morts
	 * retourne "false" si tous les combattants ne sont pas mort
	 * retourne "true" si tous les combattants sont morts
	 * @return
	 */
	public boolean EstMort() {
		boolean sontTousMorts = false;
		int nombreDeMorts = 0;
		// Pour chaque combattant du groupe, si le combattant est mort : nombreMorts + 1
		for (ICombattant combattant : listeCombattants) {
			if (combattant.getPointDeVie() <= 0) {
				nombreDeMorts++;
			}
		}
		if (nombreDeMorts == listeCombattants.size()) {
			sontTousMorts = true;
		}
		return sontTousMorts;
	}

	public void attaquer(Groupe adversaires) {
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
		System.out.println(this.listeCombattants.get(index).getNom() + " attaque !");
		adversaires.defendre(degats);
	}

	public void defendre(int degats) {
		Random random = new Random();
		int nb = random.nextInt(this.listeCombattants.size());
		System.out.println(this.listeCombattants.get(nb).getNom() + " subit " + degats + " dégats");
		this.listeCombattants.get(nb).setPointDeVie(listeCombattants.get(nb).getPointDeVie() - degats);
	}

}
