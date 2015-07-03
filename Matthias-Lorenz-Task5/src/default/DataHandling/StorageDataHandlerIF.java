package DataHandling; 

import java.util.List; 

import Appointment.Appointment;; 

public  interface  StorageDataHandlerIF {
	
	abstract void writeAppointment(Appointment app);

	
	abstract void writeAppointments(List<Appointment> app);

	
	
	//abstract Appointment readAppointment();
	abstract List<Appointment> readAppointments();

	
	
	abstract void deleteAppointment(Appointment app);

	
	abstract public void deleteAppointment(int number);


}
