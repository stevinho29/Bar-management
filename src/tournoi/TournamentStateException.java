package tournoi;

public class TournamentStateException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  TournamentStateException()
	{
		System.out.println("Ce tournoi est passé vous ne pouvez y participer");
	}

}
