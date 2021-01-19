package main;

interface IAttaque {
	
    public int lancerAttaque();
    public String getNom();
    public int getDegats();
    public String getDescription();
    public double getChanceToucher();
    public void setNom(String nom);
    public void setDegats(int degats);
    public void setDescription(String description);
    public void setChanceToucher(double chanceToucher);
    
}
