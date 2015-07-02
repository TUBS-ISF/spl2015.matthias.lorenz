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

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) 
//	{
//		EventQueue.invokeLater(new Runnable() 
//		{
//			public void run() 
//			{
//				try 
//				{
//					MainWindow frame = new MainWindow();
//					frame.setVisible(true);
//				} catch (Exception e) 
//				{
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
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
		
		
		//#ifdef REPEAT
//@		final JButton rptApp = new JButton("Repeat Appointment");
//@		rptApp.addActionListener(new ActionListener() 
//@		{
//@			public void actionPerformed(ActionEvent e) 
//@			{
//@				if(e.getSource() == rptApp)
//@				{
//@					RepeatAppointmentWindow frame = new RepeatAppointmentWindow(c);
//@					frame.setVisible(true);
//@				}
//@			}
//@		});
//@		contentPane.add(rptApp);
		//#endif
		
		//#ifdef COPY
//@		final JButton cpyApp = new JButton("Copy Appointment");
//@		cpyApp.addActionListener(new ActionListener() 
//@		{
//@			public void actionPerformed(ActionEvent e) 
//@			{
//@				if(e.getSource() == cpyApp)
//@				{
//@					System.out.println("Button was clicked! yay!");
//@				}
//@			}
//@		});
//@		contentPane.add(cpyApp);
		//#endif
		
		//#ifdef DELETE
//@		final JButton dltApp = new JButton("Delete Appointment");
//@		dltApp.addActionListener(new ActionListener() 
//@		{
//@			public void actionPerformed(ActionEvent e) 
//@			{
//@				if(e.getSource() == dltApp)
//@				{
//@					DeleteAppointmentWindow frame = new DeleteAppointmentWindow(c);
//@					frame.setVisible(true);
//@				}
//@			}
//@		});
//@		contentPane.add(dltApp);
		//#endif	
	}
}
