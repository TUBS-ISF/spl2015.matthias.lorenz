package Security; 

public  class  DummyAuthenticator  implements AuthenticatorIF {
	

	public boolean authenticate(String username, String token)
	{
		return true;
	}

	

	public String getName()
	{
		// TODO Auto-generated method stub
		return "DummyChallenge";
	}


}
