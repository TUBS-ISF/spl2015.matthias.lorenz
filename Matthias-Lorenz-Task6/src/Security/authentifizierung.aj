package Security;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import UserInterface.TerminalUserInterface;
import UserInterface.UserInterfaceIF;
import UserInterface.Windows.MainWindow;
import net.miginfocom.swing.MigLayout;
import BusinessLogic.Coordinator;

public aspect authentifizierung 
{
	public LinkedList<AuthenticatorIF> Coordinator.auths = new LinkedList<AuthenticatorIF>();
	
	public boolean Coordinator.authenticate(String username, String token)
	{
		for(AuthenticatorIF a: auths)
		{
			if(!a.authenticate(username, token))
			{
				return false;
			}
		}
		
		return true;
	}

	public class AuthenticationWindow extends JFrame implements ActionListener
	{

		private JPanel contentPane;
		
		private JLabel lbUsername;
		private JLabel lbPassword;
		
		private JTextField txtFUsername;
		private JPasswordField pwFpassword;
		
		private JButton btnOK;
		
		private Coordinator coord;
		
		private int counter;
		
		private Object lock;
		

		/**
		 * Create the frame.
		 */
		public AuthenticationWindow(Coordinator c, Object lock) 
		{
			setAlwaysOnTop(true);
			setResizable(false);
			setTitle("Authentication");
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setBounds(100, 100, 400, 130);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(new MigLayout("", "[][][][grow]", "[][]"));
			
			lbUsername = new JLabel("Username:");
			lbPassword = new JLabel("Password:");
			
			txtFUsername = new JTextField(20);
			pwFpassword = new JPasswordField(20);
			
			btnOK = new JButton("OK");
			btnOK.addActionListener(this);
			
			contentPane.add(lbUsername, "cell 0 0");
			contentPane.add(txtFUsername, "cell 3 0");
			contentPane.add(lbPassword, "cell 0 1");
			contentPane.add(pwFpassword, "cell 3 1");
			contentPane.add(btnOK, "cell 0 2");
			
			this.coord = c;
			
			this.lock = lock;
		}
		
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == this.btnOK)
			{
				txtFUsername.getText();
				String t = new String(pwFpassword.getPassword());
				
				if(coord.authenticate(txtFUsername.getText(), new String(pwFpassword.getPassword())))
				{
		            synchronized (lock) 
		            {
		                this.setVisible(false);
		                lock.notify();
		            }
				}
				else if(counter++ == 3)
				{
					System.exit(0);
				}
			}	
		}
	}


	void around(UserInterfaceIF ui, final Coordinator coord): execution(void UserInterfaceIF.startUserInterface(Coordinator)) && this(ui) && args(coord)
	{
		coord.getClass();
		
		if(ui.getClass().getSimpleName().equalsIgnoreCase("GraphicalUserInterface"))
		{
			final Object lock = new Object();
			
			final AuthenticationWindow auth = new AuthenticationWindow(coord, lock);
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
		        		MainWindow frame = new MainWindow(coord);
		        		frame.setVisible(true);
		            }
		        }
		    };
		    
		    t.start();
		}
		else if(ui.getClass().getSimpleName().equalsIgnoreCase("TerminalUserInterface"))
		{
			String username;
			String password ;
			
			for(int i = 0; i < 3; i++)
			{
				System.out.println("username: ");
				username = ((TerminalUserInterface) ui).readInput();
				System.out.println("password: ");
				password = ((TerminalUserInterface) ui).readInput();
				
				if(coord.authenticate(username.trim(), password.trim()))
				{
					((TerminalUserInterface) ui).coord = coord;
					((TerminalUserInterface) ui).displayMainMenu(coord);
					return;
				}
				
				System.out.println("Wrong Credentials!");	
			}
			
			System.out.println("Exiting!");	
			System.exit(0);	
		}
	}
}
