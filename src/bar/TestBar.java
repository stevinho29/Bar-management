/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bar;

/**
 *
 * @author USER
 */
public class TestBar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        Barman jeffrey = new Barman("Jeffrey", "Jeff", 100, 100, "Oh Oh Oh");
        Patronne linda = new Patronne();
        Bar bar = new Bar("Les 3 Brasseurs", linda);
        bar.addToInventaire(new Boisson("eau", 50, 1, false));
        bar.addToInventaire(new Boisson("Johnny Walker", 50, 1, true));
        bar.addToInventaire(new Boisson("Jack Daniels", 50, 1, true));
        bar.addToInventaire(new Boisson("Sirop Menthe", 50, 1, false));
        bar.addToInventaire(new Boisson("Cocktail Rose", 50, 1, true));
        System.out.println(bar.getInventaire());
    }
    
}
