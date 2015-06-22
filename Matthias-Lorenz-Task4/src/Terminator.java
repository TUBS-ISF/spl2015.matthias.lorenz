import BusinessLogic.Coordinator;
import UserInterface.UserInterfaceIF;

import UserInterface.GraphicalUserInterface;
import UserInterface.TerminalUserInterface;



public class Terminator 
{
	public static void main(String[] args)
	{	
		UserInterfaceIF ui;

		//CHOOSE
		ui = new GraphicalUserInterface();
		//ui = new TerminalUserInterface();
		
		ui.startUserInterface(new Coordinator());
	}
}
