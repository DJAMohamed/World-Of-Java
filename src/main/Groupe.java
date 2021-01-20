package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Groupe extends AbstractCombattant {

	private List<ICombattant> listeCombattants = new ArrayList<>();

	public Groupe() {
		super();
	}

	public Groupe(List<ICombattant> listeCombattants) {
		super();
		this.listeCombattants = listeCombattants;
	}
	
	public List<ICombattant> getListeCombattants() {
		return listeCombattants;
	}

	public void setListeCombattants(List<ICombattant> listeCombattants) {
		this.listeCombattants = listeCombattants;
	}

	public void AddCombattant(ICombattant combattant) {
		this.listeCombattants.add(combattant);
	}

	/**
	 * Cette méthode parcourt la liste des combattants du groupe et vérifie si ils sont tous morts
	 * retourne "false" si tous les combattants ne sont pas mort
	 * retourne "true" si tous les combattants sont morts
	 * @return
	 */
	public boolean estMort() {
		boolean sontTousMorts = true;
		for (ICombattant combattant : listeCombattants) {
			if (combattant.getPointDeVie() > 0) {
				sontTousMorts = false;
			}
		}
		return sontTousMorts;
	}
	
	public List<ICombattant> getALiveCombttant() {
		
		List<ICombattant> aLiveCombattant = new ArrayList();
		
		for (int i = 0 ; i < this.listeCombattants.size() ; i++) {
			if (!listeCombattants.get(i).estMort()) {
				aLiveCombattant.add(listeCombattants.get(i));
			}
		}
		return aLiveCombattant;
	}
	
	public void attaquer(Groupe adversaires) {
		Random random = new Random();
		if (getALiveCombttant().size() != 0) {
			ICombattant attaquant = getALiveCombttant().get(random.nextInt(getALiveCombttant().size()));
			ICombattant adversaire = adversaires.getALiveCombttant().get(random.nextInt(adversaires.getALiveCombttant().size()));
			if (attaquant instanceof Personnage) {
				Personnage personnage = (Personnage) attaquant;
				personnage.attaquer(adversaire);
			}
			else {
				attaquant.attaquer(adversaire);
			}
		}
		else {
			System.out.println("Liste vide.");
		}
	}

}
