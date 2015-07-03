package BusinessLogic; 
import java.util.List; 

import Appointment.Appointment; 
import DataHandling.MainDataHandler; 

import java.util.LinkedList; 
import Security.AuthenticatorIF; 


import Security.DummyAuthenticator; 


public   class  Coordinator {
	
	public Coordinator()
	{
		init();
	}

	
	
	 private void  init__wrappee__terminsoftware  ()
	{
		this.mDataHandler = new MainDataHandler();
	}

	
	
	 private void  init__wrappee__authentifizierung  ()
	{
		init__wrappee__terminsoftware();
		auths = new LinkedList<AuthenticatorIF>();
	}

	
	public void init()
	{		
		init__wrappee__authentifizierung();
		auths.add(new DummyAuthenticator());
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

	
	
	
	private LinkedList<AuthenticatorIF> auths;


}
