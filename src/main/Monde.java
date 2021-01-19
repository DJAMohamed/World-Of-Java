package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Monde {
	
	public static String[] debutNom = new String[] {"Chat", "Chien", "Chaton"};
	public static String[] finNom = new String[] {"m�chant", "de feu", "de la mort"};
	public static Scanner scanner = new Scanner(System.in);
	static Map<String, Classe> dictionnaire = new HashMap<String, Classe>();
	
	static List<Monstre> listeDeMonstres = new ArrayList<Monstre>();
	
	public Monde() {
		super();
	}
	
	public static Groupe CreationGroupeMonstre(int nombreMonstre) {		
		Groupe groupeDeMonstre = new Groupe();
		for (int i = 0 ; i < nombreMonstre ; i++) {
			Random random = new Random();
			int index = random.nextInt(listeDeMonstres.size());
			Monstre m = listeDeMonstres.get(index);
			groupeDeMonstre.AddCombattant(m);
		}
		
		return groupeDeMonstre;
	}
	
	public static Groupe CreationGroupePersonnage(int nombrePersonnage) {
		Groupe groupeDePersonnes = new Groupe();
		for (int i = 0 ; i < nombrePersonnage ; i++) {
			Personnage p = new Personnage(50, 5, " ", null);
			groupeDePersonnes.AddCombattant(p);
		}
		return groupeDePersonnes;
	}
	
	public static Personnage personnageFactory() {
        Personnage p = new Personnage("", 0, 0, classeFactory());
        System.out.println("Cr�ation d'un personnage : ");
        while (p.getNom().equals("")) {
            System.out.println("Saisir un nom :");
            p.setNom(scanner.next());
        }
         while (p.getDegats() == 0) {
            System.out.println("Saisir les d�gats :");
            p.setDegats(scanner.nextInt());
        }
         
        while (p.getPointDeVie() == 0) {
            System.out.println("Saisir les points de vie :");
            p.setPointDeVie(scanner.nextInt());
        }
        return p;
//		//Personnage p = new Personnage(10, 2, "Bidouille", classeFactpry());
//		// Demander a l'utilisateur un nom de personnage
//		// Creer un nouveau personnage en utilisant le constructeur avec tous ses params
//		// (dont le nom qui vient d'�tre choisi par l'utilisateur)
//		// Retourner l'instance du personnage
//		Scanner sc = new Scanner(System.in);		
//		System.out.println("Veuillez saisir le nom du personnage :");
//		String nom = sc.nextLine();
//		System.out.println("Veuillez saisir le nombre de points de vie :");
//		int pointDeVie = sc.nextInt();
//		System.out.println("Veuillez saisir le nombre de d�g�ts :");
//		int degat = sc.nextInt();
//		System.out.println();
//		System.out.println("Veuillez saisir le nom de la classe :");
//		String nomClasse = sc.nextLine();
//		
//		
//		
//		System.out.println("Veuillez saisir le nom de l'attaque :");
//		String nomAttaque = sc.nextLine();
//		System.out.println("Veuillez saisir la description de l'attaque :");
//		String descriptionAttaque = sc.nextLine();
//		System.out.println("Veuillez saisir le nombre de d�g�ts :");
//		int nombreDegats = sc.nextInt();
//		System.out.println("Veuillez saisir la chance de toucher :");
//		double chanceToucher = sc.nextDouble();
//
//		
//		
//		
//		
//		
//		BasicAttaque ba1 = new BasicAttaque(nomAttaque, descriptionAttaque, nombreDegats, chanceToucher);
////		BasicAttaque ba2 = new BasicAttaque("Toto", "Titi", 2, 10.0);
////		BasicAttaque ba3 = new BasicAttaque("Toto", "Titi", 2, 10.0);
////		BasicAttaque ba4 = new BasicAttaque("Toto", "Titi", 2, 10.0);
//
//		
//		
//		Classe c = new Classe(nomClasse, List.of(ba1));
//		Personnage p = new Personnage(pointDeVie, degat, nom, c);
//		return p;
	}

	public static Monstre monstreFactory() {
		Monstre m = new Monstre(50, 5, genererNom()); // Les d�g�ts et les points de vie peuvent �tre lus depuis la console.
		return m;
	}
	
	public static String genererNom() {		
		Random random = new Random();
		String str = debutNom[random.nextInt(debutNom.length)] + " " + finNom[random.nextInt(finNom.length)];
        return str;
    }
	
	public static void combat(ICombattant combattant1, ICombattant combattant2) {
		boolean turn = true;
		while ((combattant1.getPointDeVie() > 0) && (combattant2.getPointDeVie() > 0)) {
		    if (turn) {
		    	combattant2.attaquer(combattant1);		    	
		    	System.out.println(combattant2.getNom() + " a attaqu� " + combattant1.getNom() + " de : " + combattant2.getDegats() + ".");
		    	System.out.println("Il reste " + combattant1.getPointDeVie() + " points de vie au " + combattant1.getNom() + ".");
		    }
		    else {
		    	combattant1.attaquer(combattant2);		    	
		    	System.out.println(combattant1.getNom() + " a attaqu� " + combattant2.getNom() + " de : " + combattant1.getDegats() + ".");
		    	System.out.println("Il reste " + combattant2.getPointDeVie() + " points de vie au " + combattant2.getNom() + ".");
		    }
		    turn = !turn;
		    scanner.nextLine(); // Ca permet de marquer un temps d'arr�t. L'ex�cution reprend quand on appuie sur une touche.
		}
		if (combattant1.getPointDeVie() > 0) {
			System.out.println(combattant1.getNom() + " a gagn�.");
		}
		else {
			System.out.println(combattant2.getNom() + " a gagn�.");
		}
	}
	
	public static void afficherInformations() {
		System.out.println("Voici le monde.");
	}
	
	public static Classe getClasse(String nom) {
		return dictionnaire.get(nom);
	}
	
	public static void ajouterClasse(String key, Classe classe) {
		dictionnaire.put(key, classe);
	}
	
	public static BasicAttaque basicAttaqueFactory() {
	       System.out.println("Cr�ation d'un attaque ---------");
	        BasicAttaque a = new BasicAttaque("", "Ceci est une attaque", 10, 50);
	        System.out.println("Nom :");
	        a.setNom(scanner.next());
	        return a;
	}
	
	public static Classe classeFactory() {
        System.out.println("Cr�ation d'une classe : ");
        Classe c = new Classe();
        System.out.println("Nom :");
        c.setNom(scanner.next());
        // Cr�ation d'une liste d'attaque pour la classe
        List<IAttaque> attaques = new ArrayList<>();
        attaques.add(basicAttaqueFactory());
        attaques.add(basicAttaqueFactory());
        c.setAttaques(attaques);
        return c;
	}
	
	public static void genese() {
		System.out.println("--------- Bonjour ---------");
		System.out.println("Choisir une option :");
		System.out.println("1: Lancer un combat 1 v 1.");
		System.out.println("2: Lancer un combat de groupe.");
		System.out.println("3: One vs World Hardcore Edition.");
		System.out.println("4: Informations.");
		System.out.println("----------------------------");
		System.out.print("\n>>> ");
		int choix = scanner.nextInt();
		switch (choix) {
		  case 1 :
			  combat1v1(Monde.personnageFactory(), Monde.monstreFactory());
			  break;
		  case 2 :
			  combatGroupe();
			  break;
		  case 3 :
			  System.out.println("\nOne vs World Hardcore Edition.");
			  break;
		  case 4:
			  System.out.println("\nInformations.");
			  break;
		}
	}
	
	public static void combat1v1(Personnage p, Monstre m) {
		combat(p, m);
	}
	
	public static void combatGroupe() {
		genese();
		System.out.println("Saisir la taille des groupes (Personnages vs Monstres) :");
		int tailleGroupes = scanner.nextInt();
		System.out.println();
		System.out.println("D�but du combat : ");
		System.out.println();
		System.exit(1);
		Groupe montres = CreationGroupeMonstre(tailleGroupes);
		Groupe personnages = CreationGroupePersonnage(tailleGroupes);
		for (int i = 0 ; i < tailleGroupes ; i++) {
			for (int j = 0; j < tailleGroupes ; j++) {
				combat(personnages.listeCombattants.get(i), listeDeMonstres.get(j));
			}
		}		
	}
	
}