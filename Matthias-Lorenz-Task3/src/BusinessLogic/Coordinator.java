package BusinessLogic;

import java.util.List;

import Appointment.Appointment;
import DataHandling.MainDataHandler;

public class Coordinator 
{
	public Coordinator()
	{
		this.mDataHandler = new MainDataHandler();
	}
	
	
	public void saveAppointment(Appointment app)
	{
		mDataHandler.saveAppointment(app);
	}
	
	
	public List<Appointment> readAppointments()
	{
		return mDataHandler.getAppointments();
	}
	
	
	public void deleteAppointment(Appointment app)
	{
		mDataHandler.deleteAppointment(app);
	}
	
	public void deleteAppointment(int number)
	{
		mDataHandler.deleteAppointment(number);
	}
	
	private MainDataHandler mDataHandler;
}
