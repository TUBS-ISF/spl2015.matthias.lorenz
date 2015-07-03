package DataHandling;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import Appointment.Appointment;


public class MainDataHandler 
{
	
	public void addHandlers()
	{
		original();
		storageDHandler.add(new MySQLDataHandler());
	}
}
