package UserInterface.Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import Appointment.Appointment;
import BusinessLogic.Coordinator;

public class ShowAppointmentsWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ShowAppointmentsWindow frame = new ShowAppointmentsWindow();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ShowAppointmentsWindow(Coordinator c) {
		
		this.c = c;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(getContentTable(), BorderLayout.CENTER);
	}
	
	Object[][] getAppointments()
	{
		List<Appointment> appointments = c.readAppointments();
		Object[][] data = new Object[appointments.size()][4];
		
		int i = 0;
		for(Appointment a : appointments)
		{
			data[i][0] = i;
			data[i][1] = a.getName();
			data[i][2] = a.getDate();
			data[i][3] = a.getNote();
			
			i++;
		}
		
		return data;
	}
	
	JTable getContentTable()
	{
		String[] columNames = {"#", "Name", "Date", "Note"};
		return new JTable(getAppointments(), columNames);
	}
	
	private Coordinator c;
}
