import UserInterface.GraphicalUserInterface;




public class Terminator 
{
	public static void main(String[] args)
	{	
		original(args);
		ui = new GraphicalUserInterface();
		ui.startUserInterface(new Coordinator());
	}
}
