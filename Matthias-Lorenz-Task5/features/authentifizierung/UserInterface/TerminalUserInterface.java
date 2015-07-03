package UserInterface;

import java.util.List;
import java.util.Scanner;

import BusinessLogic.Coordinator;

public class TerminalUserInterface implements UserInterfaceIF {

	
	public void startUserInterface(Coordinator c) 
	{
		this.coord = c;
		authentication();
		displayMainMenu(c);
	}
			
	
	private void authentication()
	{
		String username;
		String password ;
		
		for(int i = 0; i < 3; i++)
		{
			System.out.println("username: ");
			username = readInput();
			System.out.println("password: ");
			password = readInput();
			
			if(coord.authenticate(username.trim(), password.trim()))
			{
				return;
			}
			
			System.out.println("Wrong Credentials!");	
		}
		
		System.out.println("Exiting!");	
		System.exit(0);		
	}
	
	Coordinator coord;

}
