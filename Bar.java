
import java.util.ArrayList;
/**
 * Décrivez votre classe Bar ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Bar {
    
    public ArrayList<Boisson> Inventaire = new ArrayList<>();

    public ArrayList<Boisson> getInventaire() {
        return Inventaire;
    }

    public void setInventaire(ArrayList<Boisson> Inventaire) {
        this.Inventaire = Inventaire;
    }

    public void addToInventaire(Boisson boisson) {
        this.Inventaire.add(boisson);
    }

    public void removeFromInventaire(Boisson boisson) {
        this.Inventaire.remove(boisson);
    }
}
