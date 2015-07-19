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
	
	
	public void displayMainMenu(Coordinator c)
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
		if(input.equalsIgnoreCase("q"))
		{
			System.out.println("Good bye!");
			System.exit(0);
			return;
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
		System.out.println("Quit:\t\t\t [q]");
	}
	
	
	public String readInput()
	{
		Scanner keyboard = new Scanner(System.in);
		String retVal = keyboard.next();
		//keyboard.close();
		
		return retVal;
	}
	
		
	public Coordinator coord;
}
