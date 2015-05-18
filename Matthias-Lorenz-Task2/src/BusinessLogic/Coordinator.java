package BusinessLogic;

import java.util.HashSet;
import java.util.List;

import Appointment.Appointment;
import DataHandling.MainDataHandler;

public class Coordinator 
{
	public Coordinator(HashSet<String> config)
	{
		this.config = config;
		this.mDataHandler = new MainDataHandler(config);
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
	

	private HashSet<String> config;
	private MainDataHandler mDataHandler;
}
