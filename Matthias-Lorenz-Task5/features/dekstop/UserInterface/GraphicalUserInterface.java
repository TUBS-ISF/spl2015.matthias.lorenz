package UserInterface;

import UserInterface.Windows.MainWindow;
import BusinessLogic.Coordinator;

public class GraphicalUserInterface implements UserInterfaceIF {
	
	public boolean authenticated;

	
	public void startUserInterface(final Coordinator c) 
	{
		MainWindow frame = new MainWindow(c);
		frame.setVisible(true);
	}
}
