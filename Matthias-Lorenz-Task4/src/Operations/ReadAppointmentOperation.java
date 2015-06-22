package Operations;

import java.util.List;

import Appointment.Appointment;
import BusinessLogic.Coordinator;

public class ReadAppointmentOperation implements OperationIF
{

	public String getName()
	{
		return "Read Appointments";
	}

	public List<Appointment> doOperation(Coordinator c, Appointment a, int i)
	{
		return c.readAppointments();
	}
	

}
