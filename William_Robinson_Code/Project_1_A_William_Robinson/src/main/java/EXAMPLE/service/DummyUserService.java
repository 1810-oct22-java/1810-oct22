package EXAMPLE.service;
import java.util.ArrayList;
import EXAMPLE.pojos.ers_user;

public class DummyUserService {

	/*
	 * Dummy service layer with an in memory store of users
	 */
	
	static ArrayList<ers_user> users = new ArrayList<ers_user>();
	
	static {
		//users.add(new ers_user("Genesis", "123", "Genesis is awesome"));
		//users.add(new ers_user("test", "user", "testing servlet capabilities"));
		//users.add(new ers_user("anotherUser", "user", "three for good measure"));
	}
	
	//get all users
	public ArrayList<ers_user> getUsers(){
		
		return users;
	}
	
	//get by username
	private ers_user getByUsername(String name) {
		//working with streams!
		
		/*//could do enhanced for loop....
		for(User u : users) {
			if(u.getUsername().equals(name)) return u;
		} */
		
		//OR USE REALLY COMPLEX STREAMS 
		ers_user u = users.stream() //turns users into a stream
				.filter( x -> x.getErs_username().equalsIgnoreCase(name)) //test from Predicate F.I.	
				.findAny()
				.orElse(null);
		
		return u;
	}
	
	
	//validate password by username
	public ers_user validateUser(String name, String password) {
		ers_user u = getByUsername(name);
		if(u == null) return null;
		else if(u.getErs_password().equals(password)) return u; //only case where user is logged in 
		else {
			return null;
		}
	}
	
}
