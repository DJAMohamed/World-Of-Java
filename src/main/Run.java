package main;
import java.util.Scanner;

public class Run {
	
	/**
	* Cette m�thode a pour but de cr�er un personnage avec tous ses attributs. 
	* Elle demande � l'utilisateur d'entrer le nom du personnage.
	* Retour: une instance de la classe Personnage correctement instanci�e.
	 * @return 
	**/
//	public static void personnageFactory() {
//	    // Demander a l'utilisateur un nom de personnage
//	    // Creer un nouveau personnage en utilisant le constructeur avec tous ses params (dont le nom qui vient d'�tre choisi par l'utilisateur)
//	    // Retourner l'instance du personnage
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Veuillez saisir le nom du personnage :");
//		String nom = sc.nextLine();
//		System.out.println("Veuillez saisir le nombre de points de vie :");
//		int pointDeVie = sc.nextInt();
//		System.out.println("Veuillez saisir le nombre de d�g�ts :");
//		int degat = sc.nextInt();
//		
//		Personnage p = new Personnage(pointDeVie, degat, nom);
//		System.out.println(p);
//	}


	public static void main(String[] args) {
		Personnage p = Monde.personnageFactory();
		System.out.println(p);
//		Monde.afficherInformations();
	}

}
