package main;

public class Monstre extends AbstractCombattant {
	
	public Monstre() {
        super();
    }
	
	public Monstre(int pointDeVie, int degat, String nom) {
		super(nom, pointDeVie, degat);
	}

}
