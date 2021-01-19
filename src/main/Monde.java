package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Monde {
	
	public static String[] debutNom = new String[] {"Chat", "Chien", "Chaton"};
	public static String[] finNom = new String[] {"méchant", "de feu", "de la mort"};
	public static Scanner scanner = new Scanner(System.in);
	static Map<String, Classe> dictionnaire = new HashMap<String, Classe>();
	
	public static Personnage personnageFactory() {
		// Demander a l'utilisateur un nom de personnage
		// Creer un nouveau personnage en utilisant le constructeur avec tous ses params
		// (dont le nom qui vient d'être choisi par l'utilisateur)
		// Retourner l'instance du personnage
		Scanner sc = new Scanner(System.in);		
		System.out.println("Veuillez saisir le nom du personnage :");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir le nombre de points de vie :");
		int pointDeVie = sc.nextInt();
		System.out.println("Veuillez saisir le nombre de dégâts :");
		int degat = sc.nextInt();
		BasicAttaque ba1 = new BasicAttaque("Toto", "Titi", 2, 10.0);
		BasicAttaque ba2 = new BasicAttaque("Toto", "Titi", 2, 10.0);
		BasicAttaque ba3 = new BasicAttaque("Toto", "Titi", 2, 10.0);
		BasicAttaque ba4 = new BasicAttaque("Toto", "Titi", 2, 10.0);
		Classe c = new Classe(nom, List.of(ba1, ba2, ba3, ba4));
		Personnage p = new Personnage(pointDeVie, degat, nom, c);
		return p;
	}

	
	/**
	 * Cette méthode sert à créer et à retourner un monstre. Ses caractéristiques sont demandées à l'utilisateur.
	 * @return : un monstre.
	 */

	public static Monstre MonstreFactory() {
		// Créer un String pour le nom de votre monstre.
		// Créer une instance Monstre avec son constructeur complet.
		// retourner le monstre.
		String nom = debutNom[new Random().nextInt(debutNom.length)] + " " + finNom[new Random().nextInt(finNom.length)];
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le nombre de points de vie :");
		int pointDeVie = sc.nextInt();
		System.out.println("Veuillez saisir le nombre de dégâts :");
		int degat = sc.nextInt();
		System.out.println();
		Monstre m = new Monstre(pointDeVie, degat, nom);
		return m;
	}
	
	/**
	 * Cette méthode permet de lancer le combat et designer le vainqueur. (Le combattant dont le solde de points restants est strictement positif.)
	 * @param combattant1
	 * @param combattant2
	 */
	
	public static void combat(ICombattant combattant1, ICombattant combattant2) {
		boolean turn = true;
		while ((combattant1.getPointDeVie() > 0) && (combattant2.getPointDeVie() > 0)) {
		    if (turn) {
		    	combattant2.attaquer(combattant1);		    	
		    	System.out.println(combattant2.getNom() + " a attaqué " + combattant1.getNom() + " de : " + combattant2.getDegats() + ".");
		    	System.out.println("Il reste " + combattant1.getPointDeVie() + " points de vie au " + combattant1.getNom() + ".");
		    }
		    else {
		    	combattant1.attaquer(combattant2);		    	
		    	System.out.println(combattant1.getNom() + " a attaqué " + combattant2.getNom() + " de : " + combattant1.getDegats() + ".");
		    	System.out.println("Il reste " + combattant2.getPointDeVie() + " points de vie au " + combattant2.getNom() + ".");
		    }
		    turn = !turn;
		    scanner.nextLine(); // Ca permet de marquer un temps d'arrêt. L'exécution reprend quand on appuie sur une touche.
		}
		if (combattant1.getPointDeVie() > 0) {
			System.out.println(combattant1.getNom() + " a gagné.");
		}
		else {
			System.out.println(combattant2.getNom() + " a gagné.");
		}
	}
	
	public static void afficherInformations() {
		System.out.println("Voici le monde.");
	}
	
	public static Classe GetClasse(String nom) {
		return dictionnaire.get(nom);
	}
}
