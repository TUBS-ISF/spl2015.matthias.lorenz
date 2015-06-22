package BusinessLogic;

import java.util.LinkedList;
import java.util.List;

import Appointment.Appointment;
import DataHandling.MainDataHandler;
import Security.AuthenticatorIF;
import Security.DummyAuthenticator;
import Security.HardcodedAuthenticator;

public class Coordinator 
{
	public Coordinator()
	{
		this.mDataHandler = new MainDataHandler();
		
		auths = new LinkedList<AuthenticatorIF>();
		
		//CHOOSE
		auths.add(new DummyAuthenticator());
		auths.add(new HardcodedAuthenticator());
	}
	
	public boolean authenticate(String username, String token)
	{
		for(AuthenticatorIF a: auths)
		{
			if(!a.authenticate(username, token))
			{
				return false;
			}
		}
		
		return true;
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
	
	private LinkedList<AuthenticatorIF> auths;
}
