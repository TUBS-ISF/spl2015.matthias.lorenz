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
		System.out.println("Repeat Appointment:\t [r]");
		
		original();
	}
	
	
	private void evaluateInput(String input)
	{

		if(input.equalsIgnoreCase("r"))
		{
			repeatAppointment();
		}	
		else
		{
			original(input);
		}
	}
	
	
	private void displayRepeatAppointmentBanner()
	{
		System.out.println("\n\n\t------------------");
		System.out.println("\tRepeat Appointment");
		System.out.println("\t------------------\n");
	}
	
	
	private void repeatAppointment()
	{
		displayRepeatAppointmentBanner();
		
		System.out.println("Enter appointment number of appointment to repeat");
		System.out.println("or [a] for abbort");	
		String temp = readInput();	
		if(temp.equalsIgnoreCase("a"))
		{
			return;
		}
		int number = Integer.parseInt(temp);
		
		List<Appointment> apps = coord.readAppointments();
		Appointment oldApp = apps.get(number);
		
		System.out.println("Repeating appointment number: " + number);
		oldApp.printAppointment();
		
		System.out.println("Please enter the new day of the appointment as Integer:");
		int day = Integer.parseInt(readInput());
		
		System.out.println("Please enter the new month of the appointment as Integer:");
		int month = Integer.parseInt(readInput());
		
		System.out.println("Please enter the new year of the appointment as Integer:");
		int year = Integer.parseInt(readInput());
		
		
		
		GregorianCalendar cal = new  GregorianCalendar(year, month - 1, day);
		Date appDate = cal.getTime();
		
		Appointment newApp = new Appointment(oldApp.getName(), appDate, oldApp.getNote());
		
		System.out.println("Saving new Appointment:\n");
		newApp.printAppointment();
		
		coord.saveAppointment(newApp);	
	}
}
