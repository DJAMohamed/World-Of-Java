package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Monde {
	
	private static String[] debutNom = new String[] {"Chat", "Chien", "Chaton"};
	private static String[] finNom = new String[] {"méchant", "de feu", "de la mort"};
	private static Scanner scanner = new Scanner(System.in);
	private static Map<String, Classe> dictionnaire = new HashMap<String, Classe>();
	
	private static Groupe listeDeMonstres;
	private static Groupe listeDePersonnages;
	
	public Monde() {
		super();
	}
	
	public static Groupe groupeMonstreFactory(int nombreMonstre) {
		System.out.println("\nCréation du groupe de monstres :\n");
		Groupe groupeDeMonstre = new Groupe();
		for (int index = 0 ; index < nombreMonstre ; index++) {
			Monstre monstre = new Monstre(50, 5, "Monstre " + (index + 1));
			groupeDeMonstre.getListeCombattants().add(monstre);
		}
		for (int index = 0; index < groupeDeMonstre.getListeCombattants().size() ; index++) System.out.println(groupeDeMonstre.getListeCombattants().get(index));
		return groupeDeMonstre;
	}
	
	public static Groupe groupePersonnageFactory(int nombrePersonnage) {
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
			groupeDePersonnages.getListeCombattants().add(personnage);
		}
		for (int index = 0; index < groupeDePersonnages.getListeCombattants().size() ; index++) System.out.println(groupeDePersonnages.getListeCombattants().get(index));
		return groupeDePersonnages;
	}
	
	public static Personnage personnageFactory() { // Cette méthode est à modifier.
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

	public static Classe choisirClasse() {
		return null; // Cette méthode est à écrire.
		
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
//		    scanner.nextLine(); // Ca permet de marquer un temps d'arrêt. L'exécution reprend quand on appuie sur une touche.
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
		System.out.println("Création d'une attaque :\n");
	    BasicAttaque a = new BasicAttaque("", "Ceci est une attaque", 10, 50);
	    System.out.print("Nom de l'attaque : ");
	    a.setNom(scanner.next());
	    System.out.println();
	    return a;
	}
	
	public static Classe classeFactory() {
        System.out.println("Création d'une classe : ");
        Classe c = new Classe();
        System.out.println("Nom :");
        c.setNom(scanner.next());
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
		int tour = 0;
		boolean quiAttaque = true;
		System.out.print("\nVeuillez saisir la taille des groupes [Personnages vs Monstres] : ");
		int tailleGroupes = scanner.nextInt();
		listeDeMonstres = groupeMonstreFactory(tailleGroupes);
		listeDePersonnages = groupePersonnageFactory(tailleGroupes);
		System.out.println("\nDébut du combat :\n");
		while ((!listeDeMonstres.estMort()) && (!listeDePersonnages.estMort())) {
			tour++;
			System.out.println("\n-------------------- Tour n° " + tour + " --------------------\n");
			if (quiAttaque) {
				listeDeMonstres.attaquer(listeDePersonnages);
			}
			else {
				listeDePersonnages.attaquer(listeDeMonstres);
			}
//			scanner.nextLine();
			quiAttaque = !quiAttaque;
		}
		if (listeDeMonstres.estMort()) {
			System.out.println("\nLe groupe de personnages a gagné.");
		}
		else {
			System.out.println("\nLe groupe de monstres a gagné.");
		}	
	}
	
}