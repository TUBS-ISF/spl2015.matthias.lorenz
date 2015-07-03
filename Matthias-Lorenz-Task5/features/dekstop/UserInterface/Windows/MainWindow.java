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

public class MainWindow extends JFrame {

	private JPanel contentPane;


	public MainWindow(Coordinator c) 
	{	
		setTitle("Terminator Terminverwaltung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		decorateWindow(contentPane, c);
	}
	
	private void decorateWindow(JPanel contentPane, final Coordinator c)
	{
		final JButton nwApp = new JButton("New Appointment");
		nwApp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == nwApp)
				{
					AddAppointmentWindow frame = new AddAppointmentWindow(c);
					frame.setVisible(true);
				}
			}
		});
		contentPane.add(nwApp);
		
		final JButton dsplApp = new JButton("Display Appointments");
		dsplApp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == dsplApp)
				{
					ShowAppointmentsWindow frame = new ShowAppointmentsWindow(c);
					frame.setVisible(true);
				}
			}
		});
		contentPane.add(dsplApp);	
	}
}
