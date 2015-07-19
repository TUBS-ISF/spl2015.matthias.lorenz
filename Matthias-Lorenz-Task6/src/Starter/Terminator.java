package Starter;
import BusinessLogic.Coordinator;
import UserInterface.UserInterfaceIF;


public class Terminator 
{
	public static void start()
	{
		Coordinator coord = new Coordinator();
		init();
		ui.startUserInterface(coord);
	}
	
	public static void init()
	{
		
	}
	
	public static UserInterfaceIF ui;
	static Coordinator coord;
}
