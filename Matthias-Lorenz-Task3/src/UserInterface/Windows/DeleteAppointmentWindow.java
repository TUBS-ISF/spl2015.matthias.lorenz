package UserInterface.Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Appointment.Appointment;
import BusinessLogic.Coordinator;

public class DeleteAppointmentWindow extends JFrame {

	private JPanel contentPane;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DeleteAppointmentWindow frame = new DeleteAppointmentWindow();
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
	public DeleteAppointmentWindow(final Coordinator c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
