package BusinessLogic;

import java.util.LinkedList;
import java.util.List;

import Appointment.Appointment;
import DataHandling.MainDataHandler;
import Security.AuthenticatorIF;

public class Coordinator 
{
	
	public void init()
	{
		original();
		auths = new LinkedList<AuthenticatorIF>();
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
	
	
	private LinkedList<AuthenticatorIF> auths;
}
