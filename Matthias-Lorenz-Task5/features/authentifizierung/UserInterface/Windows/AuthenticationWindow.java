package UserInterface.Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;


import javax.swing.JPasswordField;

import UserInterface.GraphicalUserInterface;
import BusinessLogic.Coordinator;

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
