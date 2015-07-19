//package Security;
//
//import BusinessLogic.Coordinator;
//
//public aspect dummy 
//{
//	public class DummyAuthenticator implements AuthenticatorIF
//	{
//
//		public boolean authenticate(String username, String token)
//		{
//			return true;
//		}
//
//		public String getName()
//		{
//			return "DummyChallenge";
//		}
//	}
//
//	before(Coordinator coord): execution(void Coordinator.init()) && this(coord) 
//	{
//		coord.auths.add(new DummyAuthenticator());
//	}
//
//}
