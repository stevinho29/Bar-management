package bar;

/**
 * <b>Couleur est la classe representant une couleur.</b><br>
 * Une couleur est caracterisee par :
 * <ul>
 * <li>Un nom de couleur</li>
 * </ul>
 * 
 * @author Josias SEMANOU
 * @version 1.0
 */
public enum Couleur {
    bleu("BLEU"),
    noir("NOIR"),
    blanc("BLANC"),
    rouge("ROUGE"),
    jaune("JAUNE"),
    orange("ORANGE"),
    vert("VERT"),
    violet("VIOLET");
    
    /**
     * Le nom de la couleur
     */
    private String color;
	
    /**
     * Constructeur de Couleur
     * 
     * @param color
     */
    private Couleur(String color)
    {
        this.color= color;
    }
    
    /**
     * @return Le nom de la couleur
     */
    public String getColor()
    {
        return this.color;
    }
}
