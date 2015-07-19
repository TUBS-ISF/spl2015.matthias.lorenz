package Operations;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import UserInterface.Windows.MainWindow;
import UserInterface.TerminalUserInterface;
import Appointment.Appointment;
import BusinessLogic.Coordinator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public aspect auslesen 
{
	public class ShowAppointmentsWindow extends JFrame {

		private JPanel contentPane;
		private JTable table;


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

	private void displayAppointments(Coordinator coord)
	{
		List<Appointment> apps = coord.readAppointments();
		
		if(apps == null || apps.isEmpty())
		{
			System.out.println("No Appointment found.");
			return;
		}
		
		int i = 0;
		
		for(Appointment a : apps)
		{
			System.out.println("\n\nAppointment number: " + i);
			System.out.println("----------------------");
			a.printAppointment();
			i++;
		}	
	}
	
	before(JPanel contentPane, final Coordinator coord):execution(void MainWindow.decorateWindow(JPanel, Coordinator)) 
			&& args(contentPane, coord)
	{
		final JButton dsplApp = new JButton("Display Appointments");
		dsplApp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == dsplApp)
				{
					ShowAppointmentsWindow frame = new ShowAppointmentsWindow(coord);
					frame.setVisible(true);
				}
			}
		});
		contentPane.add(dsplApp);;
	}
	
	before(): execution(void TerminalUserInterface.displayMainMenuOptions())
	{
		System.out.println("Display Appointments:\t [d]");
	}
	
	before(TerminalUserInterface ui, String input): execution(void TerminalUserInterface.evaluateInput(String)) && this(ui) && args(input)
	{
		if(input.equalsIgnoreCase("d"))
		{
			displayAppointments(ui.coord);	
		}
	}
}
