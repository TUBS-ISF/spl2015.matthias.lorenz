package UserInterface;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import Appointment.Appointment;
import BusinessLogic.Coordinator;

public class TerminalUserInterface implements UserInterfaceIF {

	
	public void startUserInterface(Coordinator c) 
	{
		this.coord = c;
		displayMainMenu(c);
	}
	
	
	private void displayMainMenu(Coordinator c)
	{
		while(true)
		{
			displayBanner();
			displayMainMenuOptions();	
			evaluateInput(readInput());
		}	
	}
	
	private void evaluateInput(String input)
	{
		if(input.equalsIgnoreCase("n"))
		{
			newAppointmentMenu();
		}
		else if(input.equalsIgnoreCase("d"))
		{
			displayAppointments();	
		}
		else if(input.equalsIgnoreCase("q"))
		{
			System.out.println("Good bye!");
			System.exit(0);
			return;
		}
		else if(input.equalsIgnoreCase("c"))
		{
			System.out.println("Not supported yet. :*(");
			
		}
		else
		{
			System.out.println("Illegal argument!");
		}
		
	}
	
	
	private void displayBanner()
	{
		System.out.println("\n\n-----------------------------");
		System.out.println("Terminator - Terminverwaltung");
		System.out.println("-----------------------------\n");
	}
	
	
	public void displayMainMenuOptions()
	{
		System.out.println("New Appointment:\t [n]");
		System.out.println("Display Appointments:\t [d]");	
		
		System.out.println("Copy Appointment:\t [c]");
		
		System.out.println("Quit:\t\t\t [q]");
	}
	
	
	private String readInput()
	{
		Scanner keyboard = new Scanner(System.in);
		String retVal = keyboard.next();
		//keyboard.close();
		
		return retVal;
	}
	
	
	private void newAppointmentMenu()
	{
		displayNewAppointmentMenu();
		
		System.out.println("Please enter a name for the appointment:");
		String name = readInput();
		
		System.out.println("Please enter the day of the appointment as Integer:");
		int day = Integer.parseInt(readInput());
		
		System.out.println("Please enter the month of the appointment as Integer:");
		int month = Integer.parseInt(readInput());
		
		System.out.println("Please enter the year of the appointment as Integer:");
		int year = Integer.parseInt(readInput());
		
		System.out.println("Please enter a note for the appointment:");
		String note = readInput();
		
		GregorianCalendar cal = new  GregorianCalendar(year, month - 1, day);
		Date appDate = cal.getTime();
		
		Appointment newApp = new Appointment(name, appDate, note);
		
		System.out.println("Saving Appointment:\n");
		newApp.printAppointment();
		
		coord.saveAppointment(newApp);
	}
	
	
	private void displayNewAppointmentMenu()
	{
		System.out.println("\n\n\t----------------------");
		System.out.println("\tCreate new Appointment");
		System.out.println("\t----------------------\n");
	}
	
	
	private void displayAppointments()
	{
		List<Appointment> apps = coord.readAppointments();
		
		if(apps == null || apps.isEmpty())
		{
			System.out.println("No Appointment found.");
			return;
		}
		
		int i = 0;
		
		for(Appointment a : apps)
		{
			System.out.println("\n\nAppointment number: " + i);
			System.out.println("----------------------");
			a.printAppointment();
			i++;
		}	
	}
		
	Coordinator coord;
}
