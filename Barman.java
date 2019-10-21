
/**
 * Décrivez votre classe Barman ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Barman extends Humain implements Homme, Femme{
    
    private Bar barEnCharge;

    public Barman(String prenom, String surnom, int porteMonnaie, int cotePopularite, String criSignificatif) {
        super(prenom, surnom, porteMonnaie, cotePopularite, criSignificatif);
    }
    
    public void vendreBoisson(Boisson boisson, int quantite, Humain humain){
        if(barEnCharge.Inventaire.contains(boisson)){
            Boisson boissonDuBar = barEnCharge.Inventaire.get(barEnCharge.Inventaire.indexOf(boisson));
            if (boissonDuBar.getQuantite() >= quantite) {
                float coutTotal = boissonDuBar.getPrix() * quantite;
                if (humain.getPorteMonnaie() >= coutTotal) {
                    humain.setPorteMonnaie(humain.getPorteMonnaie() - coutTotal);
                    humain.setContenuVerre(quantite);
                }else{
                    System.out.println("Vous n'avez pas assez pour acheter " + quantite + " Litres de " + boisson.getNom());
                }
            }else{
                System.out.println("Nous n'avons pas assez de " + boissonDuBar.getNom() + ". Il n'en reste que " + boissonDuBar.getQuantite() + " Litres.");
            }
        }else{
            System.out.println("Il n'y a pas cette boisson dans notre bar !!");
        }
    }
    
    @Override
    public void caracteristiqueHomme() {}

    @Override
    public void caracteristiqueFemme() {}
    
}
