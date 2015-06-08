import BusinessLogic.Coordinator;
import UserInterface.UserInterfaceIF;

//#ifdef GUI
import UserInterface.GraphicalUserInterface;
//#elifdef TUI
//@import UserInterface.TerminalUserInterface;
//#endif


public class Terminator 
{
	public static void main(String[] args)
	{	
		UserInterfaceIF ui;
		
		//#ifdef GUI
			ui = new GraphicalUserInterface();
			ui.startUserInterface(new Coordinator());
		//#elifdef TUI
//@			ui = new TerminalUserInterface();
//@			ui.startUserInterface(new Coordinator());
		//#endif	
	}

}
