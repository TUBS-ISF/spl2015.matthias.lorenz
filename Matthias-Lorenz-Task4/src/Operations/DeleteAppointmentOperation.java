package Operations;

import java.util.List;

import Appointment.Appointment;
import BusinessLogic.Coordinator;

public class DeleteAppointmentOperation implements OperationIF
{

	public String getName()
	{
		return "Delete Appointment";
	}

	public List<Appointment> doOperation(Coordinator c, Appointment a, int i)
	{
		if(a == null)
		{
			c.deleteAppointment(i);
		}
		else
		{
			c.deleteAppointment(a);
		}
		
		return null;
	}

}
