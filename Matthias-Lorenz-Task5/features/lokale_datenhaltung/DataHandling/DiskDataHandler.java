package DataHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import Appointment.Appointment;

public class DiskDataHandler implements StorageDataHandlerIF {

	public void writeAppointment(Appointment app) 
	{
		List<Appointment> appsToWrite = new LinkedList<Appointment>();
		appsToWrite.add(app);
		
		writeAppointments(appsToWrite);
	}

	/*
	public Appointment readAppointment() 
	{
		FileInputStream fIn;
		ObjectInputStream oIn;
		
		try 
		{
			fIn = new FileInputStream("defaultDB.adb");
			oIn = new ObjectInputStream(fIn);
	
			return (Appointment) oIn.readObject();
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	*/
	
	public void writeAppointments(List<Appointment> app) 
	{
		List<Appointment> appsToWrite = new LinkedList<Appointment>(app);
		appsToWrite.addAll(readAppointments());
		
		FileOutputStream fOut;
		ObjectOutputStream oOut;
		
		try 
		{
			fOut = new FileOutputStream("defaultDB.adb");
			oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(appsToWrite);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public List<Appointment> readAppointments() 
	{
		FileInputStream fIn;
		ObjectInputStream oIn;
		
		try 
		{
			fIn = new FileInputStream("defaultDB.adb");
			oIn = new ObjectInputStream(fIn);
	
			List<Appointment> retVal = (List<Appointment>) oIn.readObject();
			
			oIn.close();
			fIn.close();
			
			return retVal;
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			return new LinkedList<Appointment>();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Appointment> retVal = new LinkedList<Appointment>();
		
		return retVal;	
	}

	
	
	public void deleteAppointment(Appointment app) 
	{
		List<Appointment> appsToWrite = readAppointments();
		appsToWrite.remove(app);
		
		FileOutputStream fOut;
		ObjectOutputStream oOut;
		
		try 
		{
			fOut = new FileOutputStream("defaultDB.adb");
			oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(appsToWrite);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAppointment(int number)
	{
		List<Appointment> appsToWrite = readAppointments();
		appsToWrite.remove(number);
		
		FileOutputStream fOut;
		ObjectOutputStream oOut;
		
		try 
		{
			fOut = new FileOutputStream("defaultDB.adb");
			oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(appsToWrite);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
