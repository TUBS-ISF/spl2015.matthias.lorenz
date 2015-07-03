package UserInterface.Windows; 

import java.awt.BorderLayout; 
import java.awt.FlowLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 

import javax.swing.JButton; 
import javax.swing.JDialog; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder; 

import net.miginfocom.swing.MigLayout; 

public  class  WrongPasswordDialog  extends JDialog  implements ActionListener {
	

	private final JPanel contentPanel = new JPanel();

	
	private JLabel lbWrong;

	
	private JButton btnOK;

	

	/**
	 * Create the dialog.
	 */
	public WrongPasswordDialog() 
	{
		setTitle("Wrong Password");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 100);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[]", "[]"));
		
		lbWrong = new JLabel("Wrong Password!");
		
		btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		
		contentPanel.add(lbWrong, "cell 3 3");
		contentPanel.add(btnOK, "cell 3 4");
	}

	
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == this.btnOK)
		{
			dispose();
		}	
	}


}
