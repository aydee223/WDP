package uts.polsys;

import java.util.*;
import java.io.Serializable;
import javax.xml.bind.annotation.*;

//commented by rosa
//import uts.wsd.User;

@XmlRootElement(name = "polling")
@XmlAccessorType(XmlAccessType.FIELD)
public class Polling implements Serializable{
	
	private static final long serialVersionUID = 4096308121399665531L;
	
	@XmlElement(name = "user")
	private ArrayList<User> users = new ArrayList<User>();
	
	public ArrayList<User> getUsers(){
		return users;
	}

	//added by rosa
    public User login(String username, String password) {
        // For each user in the list...
        for (User user : users) {
        	System.out.println("Users user is " + user);
            if (user.getUserName().equals(username) && user.getPassword().equals(password))
                return user; // Login correct. Return this user.
        }
        return null; // Login incorrect. Return null.
    }
/*
    public void addUser(User user) {
        users.add(user);
    }
    
    public void removeUser(User user) {
        users.remove(user);
    }
 */
}
