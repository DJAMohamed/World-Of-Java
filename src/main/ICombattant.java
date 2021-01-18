package main;

/**
 * 
 * @author Administrateur
 *
 */

interface ICombattant {
	/**
	 * Cette méthode retire des points de vie à l'adversaire.
	 * @param adversaire
	 */
    public void attaquer(ICombattant adversaire);
    /**
     * Cette méthode empêche l'adversaire d'enlever des vies.
     * @param degats
     */
    public void defendre(int degats);
    public String getNom();
    public int getDegats();
    public int getPointDeVie();
    public void setNom(String nom);
    public void setDegats(int degats);
    public void setPointDeVie(int pointDeVie);
}