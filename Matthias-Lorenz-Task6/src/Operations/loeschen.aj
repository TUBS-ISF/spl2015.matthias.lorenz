package Operations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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


public aspect loeschen 
{
	public class DeleteAppointmentWindow extends JFrame {

		private JPanel contentPane;

		public DeleteAppointmentWindow(final Coordinator c) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
			JSplitPane splitPaneAppointmentNumber = new JSplitPane();
			contentPane.add(splitPaneAppointmentNumber);
			
			final JTextField txtAppointmentNumber = new JTextField();
			txtAppointmentNumber.setText("0");
			splitPaneAppointmentNumber.setRightComponent(txtAppointmentNumber);
			txtAppointmentNumber.setColumns(10);
			
			JLabel lblDeleteNumber = new JLabel("Delete Number:");
			splitPaneAppointmentNumber.setLeftComponent(lblDeleteNumber);
			
			contentPane.add(splitPaneAppointmentNumber);
			
			final JButton btnDeleteAppointment = new JButton("Delete Appointment");
			btnDeleteAppointment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					if(e.getSource() == btnDeleteAppointment)
					{
						c.deleteAppointment(Integer.parseInt(txtAppointmentNumber.getText()));
					}
				}
			});
			contentPane.add(btnDeleteAppointment);
		}
	}

	private void deleteAppointment(TerminalUserInterface ui)
	{
		displayDeleteAppointmentBanner();
		
		System.out.println("Enter appointment number of appointment to delete");
		System.out.println("or [a] for abbort");	
		String temp = ui.readInput();	
		if(temp.equalsIgnoreCase("a"))
		{
			return;
		}
		int number = Integer.parseInt(temp);
		
		List<Appointment> apps = ui.coord.readAppointments();
		Appointment oldApp = apps.get(number);
		
		System.out.println("Deleting appointment number: " + number);
		oldApp.printAppointment();
		
		ui.coord.deleteAppointment(oldApp);
	}
	
	
	private void displayDeleteAppointmentBanner()
	{
		System.out.println("\n\n\t------------------");
		System.out.println("\tDelete Appointment");
		System.out.println("\t------------------\n");
	}
	
	
	before(JPanel contentPane, final Coordinator coord):execution(void MainWindow.decorateWindow(JPanel, Coordinator)) 
	&& args(contentPane, coord)
	{
		final JButton dltApp = new JButton("Delete Appointment");
		dltApp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == dltApp)
				{
					DeleteAppointmentWindow frame = new DeleteAppointmentWindow(coord);
					frame.setVisible(true);
				}
			}
		});
		contentPane.add(dltApp);
	}

	before(): execution(void TerminalUserInterface.displayMainMenuOptions())
	{
		System.out.println("Delete Appointment:\t [del]");
	}
	
	
	before(TerminalUserInterface ui, String input): execution(void TerminalUserInterface.evaluateInput(String)) && this(ui) && args(input)
	{
		if(input.equalsIgnoreCase("del"))
		{
			deleteAppointment(ui);	
		}
	}
}
