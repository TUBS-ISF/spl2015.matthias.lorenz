package Security;

import java.util.HashMap;
import BusinessLogic.Coordinator;


public aspect hardcoded 
{
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
			return "Hardcoded Challenge";
		}
	}
	

	before(Coordinator coord): execution(void Coordinator.init()) && this(coord) 
	{
		coord.auths.add(new HardcodedAuthenticator());
	}
}
