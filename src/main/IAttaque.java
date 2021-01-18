package main;

interface IAttaque {
    public int LancerAttaque(ICombattant lanceur, ICombattant cible);

    public String getNom();
    public int getDegats();
    public String getDescription();
    public double getChanceToucher();
    public void setNom(String nom);
    public void setDegats(int degats);
    public void etDescription(int description);
    // Chance de toucher doit être compris entre 0 et 100 obligatoirement.
    public void setChanceToucher(double chanceToucher); 
}
