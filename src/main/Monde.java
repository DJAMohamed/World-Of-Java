package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Monde {
	
	public static String[] debutNom = new String[] {"Chat", "Chien", "Chaton"};
	public static String[] finNom = new String[] {"méchant", "de feu", "de la mort"};
	public static Scanner scanner = new Scanner(System.in);
	private static Map<String, Classe> dictionnaire = new HashMap<String, Classe>();
	
	static List<Monstre> listeDeMonstres = new ArrayList<Monstre>();
	static List<Personnage> listeDePersonnages = new ArrayList<Personnage>();
	
	public Monde() {
		super();
	}
	
	public static Groupe CreationGroupeMonstre(int nombreMonstre) {
		System.out.println("\nCréation du groupe de monstres :\n");
		Groupe groupeDeMonstre = new Groupe();
		for (int index = 0 ; index < nombreMonstre ; index++) {
			Monstre monstre = new Monstre(50, 5, "Monstre " + (index + 1));
			groupeDeMonstre.listeCombattants.add(monstre);
		}
		for (int index = 0; index < groupeDeMonstre.listeCombattants.size() ; index++) System.out.println(groupeDeMonstre.listeCombattants.get(index));
		return groupeDeMonstre;
	}
	
	public static Groupe CreationGroupePersonnage(int nombrePersonnage) {
		System.out.println("\nCréation du groupe de personnages :\n");		
		Groupe groupeDePersonnages = new Groupe();
		for (int index = 0 ; index < nombrePersonnage ; index++) {		
		    Classe c = new Classe();
		    c.setNom("Classe " + (index + 1));    
		    List<IAttaque> attaques = new ArrayList<>();
		    attaques.add(basicAttaqueFactory());
		    attaques.add(basicAttaqueFactory());
		    c.setAttaques(attaques);			
			Personnage personnage = new Personnage(50, 5, "Personnage " + (index + 1), c);
			groupeDePersonnages.listeCombattants.add(personnage);
		}
		for (int index = 0; index < groupeDePersonnages.listeCombattants.size() ; index++) System.out.println(groupeDePersonnages.listeCombattants.get(index));
		return groupeDePersonnages;
	}
	
	public static Personnage personnageFactory() {
        Personnage p = new Personnage("", 0, 0, classeFactory());
        System.out.println("Création d'un personnage : ");
        while (p.getNom().equals("")) {
            System.out.println("Saisir un nom :");
            p.setNom(scanner.next());
        }
         while (p.getDegats() == 0) {
            System.out.println("Saisir les dégats :");
            p.setDegats(scanner.nextInt());
        }
         
        while (p.getPointDeVie() == 0) {
            System.out.println("Saisir les points de vie :");
            p.setPointDeVie(scanner.nextInt());
        }
        return p;
	}

	public static Monstre monstreFactory() {
		Monstre m = new Monstre(50, 5, genererNom()); // Les dégâts et les points de vie peuvent être lus depuis la console.
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
	
	public static Classe getClasse(String nom) {
		return dictionnaire.get(nom);
	}
	
	public static void ajouterClasse(String key, Classe classe) {
		dictionnaire.put(key, classe);
	}
	
	public static BasicAttaque basicAttaqueFactory() {
	       System.out.println("Création d'un attaque ---------");
	        BasicAttaque a = new BasicAttaque("", "Ceci est une attaque", 10, 50);
	        System.out.println("Nom :");
	        a.setNom(scanner.next());
	        return a;
	}
	
	public static Classe classeFactory() {
        System.out.println("Création d'une classe : ");
        Classe c = new Classe();
        System.out.println("Nom :");
        c.setNom(scanner.next());
        // Création d'une liste d'attaque pour la classe
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
			  System.out.println();
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
		boolean quiAttaque = true;
		System.out.print("\nVeuillez saisir la taille des groupes [Personnages vs Monstres] : ");
		int tailleGroupes = scanner.nextInt();
		Groupe monstres = CreationGroupeMonstre(tailleGroupes);
		Groupe personnages = CreationGroupePersonnage(tailleGroupes);
		System.out.println("\nDébut du combat :\n");
		while ((!monstres.EstMort()) && (!personnages.EstMort())) {
			if (quiAttaque) {
				monstres.attaquer(personnages);
			}
			else {
				personnages.attaquer(monstres);
			}
			scanner.nextLine();
			quiAttaque = !quiAttaque;
		}
		if (monstres.EstMort()) {
			System.out.println("Le groupe de personnages a gagné.");
		}
		else {
			System.out.println("Le groupe de monstres a gagné");
		}	
	}
	
}