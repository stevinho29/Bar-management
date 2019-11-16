package tournoi;

public class AllowedPlayerException extends Exception {

	public AllowedPlayerException()
	{
		System.out.println("ce personnage n'est pas autorisé à participer aux tournois ");
	}
}
