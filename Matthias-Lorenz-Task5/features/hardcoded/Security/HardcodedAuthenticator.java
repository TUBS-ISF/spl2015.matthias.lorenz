package Security;

import java.util.HashMap;

public class HardcodedAuthenticator implements AuthenticatorIF
{
	private HashMap<String, String> credStorage;
	
	public HardcodedAuthenticator()
	{
		credStorage = new HashMap<String, String>();
		
		credStorage.put("user", "1234");
		credStorage.put("root", "geheim");
		credStorage.put("admin", "swordfish");	
	}
	
	public boolean authenticate(String username, String token)
	{	
		if(credStorage.containsKey(username) && credStorage.get(username).equals(token))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public String getName()
	{
		// TODO Auto-generated method stub
		return "Hardcoded Challenge";
	}
}
