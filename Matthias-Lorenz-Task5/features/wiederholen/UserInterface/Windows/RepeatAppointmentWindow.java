package UserInterface.Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class RepeatAppointmentWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtNote;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtAppointmentName;
	private JTextField txtYear;
	private JTextField txtAppointmentNumber;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RepeatAppointmentWindow frame = new RepeatAppointmentWindow();
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
	public RepeatAppointmentWindow(final Coordinator c) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//-----------------
		JSplitPane splitPaneName = new JSplitPane();
		
		txtAppointmentName = new JTextField();
		txtAppointmentName.setText("Appointment Name");
		splitPaneName.setRightComponent(txtAppointmentName);
		txtAppointmentName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		splitPaneName.setLeftComponent(lblName);
		
		
		
		JSplitPane splitPaneDay = new JSplitPane();
		
		txtDay = new JTextField();
		txtDay.setText("10");
		splitPaneDay.setRightComponent(txtDay);
		txtDay.setColumns(10);
		
		JLabel lblDay = new JLabel("Day");
		splitPaneDay.setLeftComponent(lblDay);
		
		
		
		JSplitPane splitPaneMonth = new JSplitPane();
		
		txtMonth = new JTextField();
		txtMonth.setText("10");
		splitPaneMonth.setRightComponent(txtMonth);
		txtMonth.setColumns(10);
		
		JLabel lblMonth = new JLabel("Month");
		splitPaneMonth.setLeftComponent(lblMonth);
		
		
		
		JSplitPane splitPaneYear = new JSplitPane();
			
		txtYear = new JTextField();
		txtYear.setText("1999");
		splitPaneYear.setRightComponent(txtYear);
		txtYear.setColumns(10);
	
		JLabel lblY = new JLabel("Year");
		splitPaneYear.setLeftComponent(lblY);
		
		
		
		JSplitPane splitPaneNote = new JSplitPane();
		
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
		
		
		//----------------
		
		JSplitPane splitPaneRepeat = new JSplitPane();
		contentPane.add(splitPaneRepeat);
		
		txtAppointmentNumber = new JTextField();
		txtAppointmentNumber.setText("0");
		splitPaneRepeat.setRightComponent(txtAppointmentNumber);
		txtAppointmentNumber.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number");
		splitPaneRepeat.setLeftComponent(lblNumber);
		
		final JButton btnRepeatAppointment = new JButton("Repeat Appointment");
		btnRepeatAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource() == btnRepeatAppointment)
				{
					List<Appointment> appointments= c.readAppointments();
					Appointment tmp = appointments.get(Integer.parseInt(txtAppointmentNumber.getText()));
					
					txtAppointmentName.setText(tmp.getName());
					txtNote.setText(tmp.getNote());
				}
			}
		});
		
		contentPane.add(btnRepeatAppointment);	
		
		contentPane.add(splitPaneName);
		contentPane.add(splitPaneDay);
		contentPane.add(splitPaneMonth);
		contentPane.add(splitPaneYear);
		contentPane.add(splitPaneNote);
		contentPane.add(btnAddAppointment);	
	}

}
