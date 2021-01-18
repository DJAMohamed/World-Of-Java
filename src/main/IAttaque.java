package main;

interface IAttaque {
    public int lancerAttaque(ICombattant lanceur, ICombattant cible);

    public String getNom();
    public int getDegats();
    public String getDescription();
    public double getChanceToucher();
    public void setNom(String nom);
    public void setDegats(int degats);
    public void setDescription(String description);
    // Chance de toucher doit être compris entre 0 et 100 obligatoirement.
    public void setChanceToucher(double chanceToucher); 
}
