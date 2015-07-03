package BusinessLogic;


import Security.DummyAuthenticator;


public class Coordinator 
{
	public void init()
	{		
		original();
		auths.add(new DummyAuthenticator());
	}

}
