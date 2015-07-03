package UserInterface.Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;

import BusinessLogic.Coordinator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame 
{
	private void decorateWindow(JPanel contentPane, final Coordinator c)
	{
		original(contentPane, c);
		
		final JButton dltApp = new JButton("Delete Appointment");
		dltApp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == dltApp)
				{
					DeleteAppointmentWindow frame = new DeleteAppointmentWindow(c);
					frame.setVisible(true);
				}
			}
		});
		contentPane.add(dltApp);
	}
}
