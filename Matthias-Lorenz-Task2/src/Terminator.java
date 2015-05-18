
import java.util.HashSet;

import BusinessLogic.Coordinator;
import UserInterface.GraphicalUserInterface;
import UserInterface.TerminalUserInterface;
import UserInterface.UserInterfaceIF;


public class Terminator 
{
	public static void main(String[] args)
	{
		HashSet<String> config = new HashSet<String>();
		
		for(String s: args)
		{
			config.add(s);
		}
		
		UserInterfaceIF ui;
		
		// dient zur Auffindung von Modulauswahlen
		//[MODUL]
		if(config.contains("gui"))
		{
			ui = new GraphicalUserInterface();
		}
		else
		{
			ui = new TerminalUserInterface();
			ui.startUserInterface(config, new Coordinator(config));
		}
	}

}
