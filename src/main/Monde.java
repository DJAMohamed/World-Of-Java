package main;
import java.util.Scanner;

class Monde {
	
	public static Personnage personnageFactory() {
	    // Demander a l'utilisateur un nom de personnage
	    // Creer un nouveau personnage en utilisant le constructeur avec tous ses params (dont le nom qui vient d'être choisi par l'utilisateur)
	    // Retourner l'instance du personnage
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le nom du personnage :");
		String nom = sc.nextLine();
		System.out.println("Veuillez saisir le nombre de points de vie :");
		int pointDeVie = sc.nextInt();
		System.out.println("Veuillez saisir le nombre de dégâts :");
		int degat = sc.nextInt();
		Personnage p = new Personnage(pointDeVie, degat, nom);
		return p;
	}

	public static void afficherInformations() {
		System.out.println("Voici le monde.");
	}
}
