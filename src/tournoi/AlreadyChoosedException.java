package tournoi;

public class AlreadyChoosedException extends Exception{

	public AlreadyChoosedException()
	{
		System.out.println("cette personne fait deja partie de l'equipe ");
	}
}
