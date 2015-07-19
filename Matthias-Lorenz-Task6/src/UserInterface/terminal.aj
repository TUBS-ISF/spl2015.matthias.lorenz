package UserInterface;

import Starter.Terminator;

public aspect terminal 
{
	after():execution(void Terminator.init())
	{
		Terminator.ui = new TerminalUserInterface();
	}
}
