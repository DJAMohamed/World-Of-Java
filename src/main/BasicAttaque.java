package main;

class BasicAttaque implements IAttaque {
   public int degats;

   public void basicAttaque(int degats, double chanceToucher) {
   
   }

   public int lancerAttaque(ICombattant lanceur, ICombattant cible) {
       // Avec un nombre aleatoire random compris entre 0 et 100
       // si random < chanceToucher
           // retourner lanceur.Degats
       // sinon renvoyer 0 et afficher un message d'echec
   }

}