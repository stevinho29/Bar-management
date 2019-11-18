package tournoi;

public class NotEnoughServeurException extends Exception {

	public NotEnoughServeurException()
	{
		System.out.println("ce serveur ou cette serveuse ne peut participer au tournoi... il faut bien que quelqu'un serve le clients");
	}
}
