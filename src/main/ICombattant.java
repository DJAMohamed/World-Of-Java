package main;

/**
 * 
 * @author Administrateur
 *
 */

interface ICombattant {
	/**
	 * Cette m�thode retire des points de vie � l'adversaire.
	 * @param adversaire
	 */
    public void attaquer(ICombattant adversaire);
    /**
     * Cette m�thode emp�che l'adversaire d'enlever des vies.
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