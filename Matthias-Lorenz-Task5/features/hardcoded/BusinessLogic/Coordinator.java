package BusinessLogic;

import java.util.LinkedList;
import java.util.List;

import Appointment.Appointment;
import DataHandling.MainDataHandler;
import Security.AuthenticatorIF;
import Security.HardcodedAuthenticator;

public class Coordinator 
{	
	public void init()
	{
		original();
		auths.add(new HardcodedAuthenticator());
	}

}
