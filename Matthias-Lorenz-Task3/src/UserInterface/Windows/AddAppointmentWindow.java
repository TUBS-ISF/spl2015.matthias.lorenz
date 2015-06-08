package UserInterface.Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JButton;

import Appointment.Appointment;
import BusinessLogic.Coordinator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAppointmentWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtNote;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtAppointmentName;
	private JTextField txtYear;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddAppointmentWindow frame = new AddAppointmentWindow();
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
	public AddAppointmentWindow(final Coordinator c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
