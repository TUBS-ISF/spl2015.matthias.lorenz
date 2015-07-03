package UserInterface;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import Appointment.Appointment;
import BusinessLogic.Coordinator;

public class TerminalUserInterface implements UserInterfaceIF 
{
	public void displayMainMenuOptions()
	{	
		System.out.println("Delete Appointment:\t [del]");
		original();
	}
	
	private void evaluateInput(String input)
	{

		if(input.equalsIgnoreCase("del"))
		{
			deleteAppointment();
		}	
		else
		{
			original(input);
		}
	}
	
	private void deleteAppointment()
	{
		displayDeleteAppointmentBanner();
		
		System.out.println("Enter appointment number of appointment to delete");
		System.out.println("or [a] for abbort");	
		String temp = readInput();	
		if(temp.equalsIgnoreCase("a"))
		{
			return;
		}
		int number = Integer.parseInt(temp);
		
		List<Appointment> apps = coord.readAppointments();
		Appointment oldApp = apps.get(number);
		
		System.out.println("Deleting appointment number: " + number);
		oldApp.printAppointment();
		
		coord.deleteAppointment(oldApp);
	}
	
	
	private void displayDeleteAppointmentBanner()
	{
		System.out.println("\n\n\t------------------");
		System.out.println("\tDelete Appointment");
		System.out.println("\t------------------\n");
	}
}
