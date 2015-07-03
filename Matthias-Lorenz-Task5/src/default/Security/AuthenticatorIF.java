package Security; 

public  interface  AuthenticatorIF {
	
	abstract boolean authenticate(String username, String token);

	
	abstract String getName();


}
