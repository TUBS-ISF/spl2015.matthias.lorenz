package UserInterface;

import java.util.HashSet;

import BusinessLogic.Coordinator;

public interface UserInterfaceIF 
{	
	//run interface
	abstract void startUserInterface(HashSet<String> config, Coordinator c);
}
