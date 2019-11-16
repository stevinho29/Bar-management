package bar;

/**
 * @author Josias SEMANOU
 * @version 1.0
 */
public class TestBar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        Boisson whisky0 = new Boisson("Johnny Walker", 50, 5, true);
        Barman jeffrey = new Barman("Jeffrey", "Jeff", 100, 100, "Oh Oh Oh");
        Patronne linda = new Patronne(whisky0, new Boisson("Johnny Walker", 50, 1, true), 0, "Linda Senpaï", "Linda", 100, 100, "Ouww", Bijoux.medaillon);
        Bar bar = new Bar(linda, jeffrey);
        System.out.println(bar.getNom());
        Boisson eau = new Boisson("Eau", 50, 1, false);
        Boisson whisky1 = new Boisson("Jack Daniels", 50, 7, true);
        Boisson whisky2 = new Boisson("Red Label", 50, 2, true);
        Boisson cocktail0 = new Boisson("Cocktail Rose", 50, 3, true);
        bar.addToInventaire(eau);
        bar.addToInventaire(whisky0);
        bar.addToInventaire(whisky1);
        bar.addToInventaire(whisky2);
        bar.addToInventaire(cocktail0);
        System.out.println(bar.getInventaire());
        ServeurHomme Johnatan = new ServeurHomme("Johnatan", "John", 100, 100, "Oh La La", 50);
        ServeurHomme Paul = new ServeurHomme("Paul", "Popol", 100, 100, "Hey !!!", 50);
        ServeurHomme Jacques = new ServeurHomme("Jacques", "Jacky", 100, 100, "Wooaaw", 50);
        ServeurHomme David = new ServeurHomme("David", "Dave", 100, 100, "Humm", 50);
        ServeurFemme Micheline = new ServeurFemme("Micheline", "Michou", 100, 100, "Hi hi", 10);
        ServeurFemme Caroline = new ServeurFemme("Caroline", "Caro", 100, 100, "Oulàà ", 20);
        ServeurFemme Fatoumata = new ServeurFemme("Fatoumata", "Fatou", 100, 100, "Aïe aïe aïe", 32);
        ServeurFemme Marietou = new ServeurFemme("Marietou", "Marie", 100, 100, "Helele", 45);
        ServeurFemme Cendrillon = new ServeurFemme("Cendrillon", "Princesse", 100, 100, "Youupiii ", 54);
        ServeurFemme Raiponce = new ServeurFemme("Raiponce", "Lady Ponce", 100, 100, "He he ", 72);
        ClientFemme Michou = new ClientFemme(whisky0, eau, 0, "Micheline", "Michou", 100, 100, "Oh Oh Oh", Bijoux.bague);
        ClientFemme Caro = new ClientFemme(whisky1, cocktail0, 0, "Caroline", "Caro", 100, 100, "Oh Oh Oh", Bijoux.amulette);
        ClientFemme Fatou = new ClientFemme(whisky2, eau, 0, "Fatoumata", "Fatou", 100, 100, "Oh Oh Oh", Bijoux.boucle);
        ClientFemme Marie = new ClientFemme(cocktail0, whisky2, 0, "Marietou", "Marie", 100, 100, "Oh Oh Oh", Bijoux.chapelet);
        ClientFemme Cinderella = new ClientFemme(cocktail0, whisky1, 0, "Princesse Cinderella", "Cendrillon", 100, 100, "Oh Oh Oh", Bijoux.diademe);
        ClientFemme Jojo = new ClientFemme(whisky2, whisky0, 0, "Johanna", "Jojo", 100, 100, "Oh Oh Oh", Bijoux.medaillon);
        ClientHomme Dave = new ClientHomme(whisky0, cocktail0, 0, "David", "Dave", 100, 100, "Oh Oh Oh", Couleur.blanc);
        ClientHomme Josias = new ClientHomme(whisky2, whisky0, 0, "Josias", "jojo", 100, 100, "Oh Oh Oh", Couleur.bleu);
        ClientHomme Tanjiro = new ClientHomme(whisky1, whisky2, 0, "Tanjiro", "Tanji", 100, 100, "Oh Oh Oh", Couleur.rouge);
        ClientHomme Kazuto = new ClientHomme(whisky0, whisky1, 0, "Kazuto", "Kirito", 100, 100, "Oh Oh Oh", Couleur.violet);
        ClientHomme Milllan = new ClientHomme(whisky2, cocktail0, 0, "Milllan", "mimi", 100, 100, "Oh Oh Oh", Couleur.vert);
        ClientHomme pierre = new ClientHomme(cocktail0, cocktail0, 0, "Pierre", "pierrot", 1000, 100, "Oh Oh Oh", Couleur.vert);
        ClientHomme paul = new ClientHomme(whisky2, cocktail0, 0, "Paul", "Popol", 100, 100, "Oh Oh Oh", Couleur.blanc);
        pierre.payer(40);
        pierre.payer(10);
        paul.getDrinks(pierre, 10);
        System.out.println("-------------------------------");
        Fournisseur fournisseur = new Fournisseur("JOhn", "johnny", 0, 0, "criSignificatif");
        bar.getBarman().commanderBoissons(fournisseur);
        linda.payer(10);
        //System.out.println(Bar.getOccupants());
    }
    
}
