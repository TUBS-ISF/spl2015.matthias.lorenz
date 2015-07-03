package UserInterface;

import UserInterface.Windows.AuthenticationWindow;
import UserInterface.Windows.MainWindow;
import BusinessLogic.Coordinator;

public class GraphicalUserInterface implements UserInterfaceIF {
	
	public boolean authenticated;

	
	public void startUserInterface(final Coordinator c) 
	{
		final Object lock = new Object();
		
		final AuthenticationWindow auth = new AuthenticationWindow(c, lock);
		auth.setVisible(true);
		
	    Thread t = new Thread() 
	    {
	        public void run() 
	        {
	            synchronized(lock) 
	            {
	                while (auth.isVisible())
	                    try {
	                        lock.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	        		MainWindow frame = new MainWindow(c);
	        		frame.setVisible(true);
	            }
	        }
	    };
	    t.start();
	
		

	}
}
