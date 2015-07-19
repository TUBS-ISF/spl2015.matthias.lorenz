package Operations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Appointment.Appointment;
import BusinessLogic.Coordinator;
import UserInterface.TerminalUserInterface;
import UserInterface.Windows.MainWindow;

public aspect eintragen 
{
	public class AddAppointmentWindow extends JFrame {

		private JPanel contentPane;
		private JTextField txtNote;
		private JTextField txtDay;
		private JTextField txtMonth;
		private JTextField txtAppointmentName;
		private JTextField txtYear;


		public AddAppointmentWindow(final Coordinator c) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
			JSplitPane splitPaneName = new JSplitPane();
			contentPane.add(splitPaneName);
			
			txtAppointmentName = new JTextField();
			txtAppointmentName.setText("Appointment Name");
			splitPaneName.setRightComponent(txtAppointmentName);
			txtAppointmentName.setColumns(10);
			
			JLabel lblName = new JLabel("Name");
			splitPaneName.setLeftComponent(lblName);
			
			JSplitPane splitPaneDay = new JSplitPane();
			contentPane.add(splitPaneDay);
			
			txtDay = new JTextField();
			txtDay.setText("10");
			splitPaneDay.setRightComponent(txtDay);
			txtDay.setColumns(10);
			
			JLabel lblDay = new JLabel("Day");
			splitPaneDay.setLeftComponent(lblDay);
			
			JSplitPane splitPaneMonth = new JSplitPane();
			contentPane.add(splitPaneMonth);
			
			txtMonth = new JTextField();
			txtMonth.setText("10");
			splitPaneMonth.setRightComponent(txtMonth);
			txtMonth.setColumns(10);
			
			JLabel lblMonth = new JLabel("Month");
			splitPaneMonth.setLeftComponent(lblMonth);
			
			JSplitPane splitPaneYear = new JSplitPane();
			contentPane.add(splitPaneYear);
			
			txtYear = new JTextField();
			txtYear.setText("1999");
			splitPaneYear.setRightComponent(txtYear);
			txtYear.setColumns(10);
			
			JLabel lblY = new JLabel("Year");
			splitPaneYear.setLeftComponent(lblY);
			
			JSplitPane splitPaneNote = new JSplitPane();
			contentPane.add(splitPaneNote);
			
			txtNote = new JTextField();
			txtNote.setText("Note");
			splitPaneNote.setRightComponent(txtNote);
			txtNote.setColumns(10);
			
			JLabel lblNote = new JLabel("Note");
			splitPaneNote.setLeftComponent(lblNote);
			
			final JButton btnAddAppointment = new JButton("Add Appointment");
			btnAddAppointment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					if(e.getSource() == btnAddAppointment)
					{
						c.saveAppointment(new Appointment(txtAppointmentName.getText(), Integer.parseInt(txtDay.getText()), 
								Integer.parseInt(txtMonth.getText()), Integer.parseInt(txtYear.getText()), txtNote.getText()));
					}
				}
			});
			contentPane.add(btnAddAppointment);
		}
	}
	
	private void newAppointmentMenu(TerminalUserInterface ui)
	{
		displayNewAppointmentMenu();
		
		System.out.println("Please enter a name for the appointment:");
		String name = ui.readInput();
		
		System.out.println("Please enter the day of the appointment as Integer:");
		int day = Integer.parseInt(ui.readInput());
		
		System.out.println("Please enter the month of the appointment as Integer:");
		int month = Integer.parseInt(ui.readInput());
		
		System.out.println("Please enter the year of the appointment as Integer:");
		int year = Integer.parseInt(ui.readInput());
		
		System.out.println("Please enter a note for the appointment:");
		String note = ui.readInput();
		
		GregorianCalendar cal = new  GregorianCalendar(year, month - 1, day);
		Date appDate = cal.getTime();
		
		Appointment newApp = new Appointment(name, appDate, note);
		
		System.out.println("Saving Appointment:\n");
		newApp.printAppointment();
		
		ui.coord.saveAppointment(newApp);
	}
	
	
	private void displayNewAppointmentMenu()
	{
		System.out.println("\n\n\t----------------------");
		System.out.println("\tCreate new Appointment");
		System.out.println("\t----------------------\n");
	}
	

	before(JPanel contentPane, final Coordinator coord):execution(void MainWindow.decorateWindow(JPanel, Coordinator)) 
		&& args(contentPane, coord)
	{
		final JButton nwApp = new JButton("New Appointment");
		nwApp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == nwApp)
				{
					AddAppointmentWindow frame = new AddAppointmentWindow(coord);
					frame.setVisible(true);
				}
			}
		});
		contentPane.add(nwApp);
	}

	
	before(): execution(void TerminalUserInterface.displayMainMenuOptions())
	{
		System.out.println("New Appointment:\t [n]");
	}
	
	
	before(TerminalUserInterface ui, String input): execution(void TerminalUserInterface.evaluateInput(String)) && this(ui) && args(input)
	{
		if(input.equalsIgnoreCase("n"))
		{
			newAppointmentMenu(ui);	
		}
	}
}
