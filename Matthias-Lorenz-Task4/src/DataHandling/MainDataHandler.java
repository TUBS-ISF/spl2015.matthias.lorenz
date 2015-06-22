package DataHandling;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import Appointment.Appointment;


public class MainDataHandler 
{
	public MainDataHandler()
	{
		
		this.storageDHandler = new LinkedList<StorageDataHandlerIF>();
		
		//CHOOSE
		//storageDHandler.add(new MySQLDataHandler());
		storageDHandler.add(new DiskDataHandler());
	}
	
	public void saveAppointment(Appointment app)
	{
		if(storageDHandler.isEmpty())
		{
			System.err.println("Trying to write, but no StorageHandler present!\n");
			return;
		}
		
		for(StorageDataHandlerIF sh : storageDHandler)
		{
			sh.writeAppointment(app);
		}
	}
	
	public List<Appointment> getAppointments()
	{
		if(storageDHandler.isEmpty())
		{
			System.err.println("Trying to read, but no StorageHandler present!\n");
			return null;
		}
		
		return storageDHandler.get(0).readAppointments();
	}
	
	
	public void deleteAppointment(Appointment app)
	{
		if(storageDHandler.isEmpty())
		{
			System.err.println("Trying to delete, but no StorageHandler present!\n");
			return;
		}
		
		for(StorageDataHandlerIF sh : storageDHandler)
		{
			sh.deleteAppointment(app);
		}
	}
	
	public void deleteAppointment(int number)
	{
		if(storageDHandler.isEmpty())
		{
			System.err.println("Trying to delete, but no StorageHandler present!\n");
			return;
		}
		
		for(StorageDataHandlerIF sh : storageDHandler)
		{
			sh.deleteAppointment(number);
		}
	}
	
	HashSet<String> config;
	List<StorageDataHandlerIF> storageDHandler;
}
