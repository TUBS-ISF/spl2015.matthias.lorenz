import BusinessLogic.Coordinator;
import UserInterface.UserInterfaceIF;
import UserInterface.TerminalUserInterface;



public class Terminator 
{
	public static void main(String[] args)
	{	
		UserInterfaceIF ui;

		ui = new TerminalUserInterface();
		
		ui.startUserInterface(new Coordinator());
		
		//blaa
	}
}
