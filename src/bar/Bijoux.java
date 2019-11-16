package bar;

/**
 * <b>Bijou est la classe representant un bijou.</b><br>
 * Un bijou est caracterise par :
 * <ul>
 * <li>Un nom de bijou</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public enum Bijoux {
    couronne("COURONNE"),
    boucle("BOUCLE"),
    diademe("DIADEME"),
    bague("BAGUE"),
    solitaire("SOLITAIRE"),
    bracelet("BRACELET"),
    collier("COLLIER"),
    predentif("PENDENTIF"),
    broche("BROCHE"),
    divers("DIVERS"),
    amulette("AMULETTE"),
    chaine("CHAINE"),
    chapelet("CHAPELET"),
    medaillon("MEDAILLON"),
    montre("MONTRE");
    
    
    /**
     * Le nom du bijou
     */
    private String bijou;
	
    /**
     * Constructeur de la classe bijou
     */
    private Bijoux(String bijou)
    {
        this.bijou= bijou;
    }
    
    /**
     * @return Le nom du bijou
     */
    public String getBijou()
    {
        return this.bijou;
    }
}
