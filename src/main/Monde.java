package main;

import java.util.Random;
import java.util.Scanner;

class Monde {
	
	public static String[] debutNom = new String[] {"Chat", "Chien", "Chaton"};
	public static String[] finNom = new String[] {"m�chant", "de feu", "de la mort"};

	public static Personnage personnageFactory() {
		// Demander a l'utilisateur un nom de personnage
		// Creer un nouveau personnage en utilisant le constructeur avec tous ses params
		// (dont le nom qui vient d'�tre choisi par l'utilisateur)
		// Retourner l'instance du personnage
		Scanner sc = new Scanner(System.in);		
		System.out.println("Veuillez saisir le nom du personnage :");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir le nombre de points de vie :");
		int pointDeVie = sc.nextInt();
		System.out.println("Veuillez saisir le nombre de d�g�ts :");
		int degat = sc.nextInt();
		Personnage p = new Personnage(pointDeVie, degat, nom);
		return p;
	}

	
	/**
	 * Cette m�thode sert � cr�er et � retourner un monstre. Ses caract�ristiques sont demand�es � l'utilisateur.
	 * @return : un monstre.
	 */

	public static Monstre MonstreFactory() {
		// Cr�er un String pour le nom de votre monstre.
		// Cr�er une instance Monstre avec son constructeur complet.
		// retourner le monstre.
		String nom = debutNom[new Random().nextInt(debutNom.length)] + " " + finNom[new Random().nextInt(finNom.length)];
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le nombre de points de vie :");
		int pointDeVie = sc.nextInt();
		System.out.println("Veuillez saisir le nombre de d�g�ts :");
		int degat = sc.nextInt();
		Monstre m = new Monstre(pointDeVie, degat, nom);
		return m;
	}
	
	/**
	 * 
	 * @param personnage
	 * @param monstre
	 */
	
	public static void combat(Personnage personnage, Monstre monstre) {
		// definir un boolean turn
		boolean turn = true;
		while ((personnage.getPointDeVie() > 0) && (monstre.getPointDeVie() > 0)) {/* verifier si les deux adversaires ont encore de la vie*/
		    if (turn) personnage.pointDeVie -= monstre.getDegat();
		    else monstre.degat -= personnage.getPointDeVie();
		}
	}

	public static void afficherInformations() {
		System.out.println("Voici le monde.");
	}
}
