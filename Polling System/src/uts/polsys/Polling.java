package uts.polsys;

import java.util.*;
import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "polling")
@XmlAccessorType(XmlAccessType.FIELD)
public class Polling implements Serializable{
	
	private static final long serialVersionUID = 4096308121399665531L;
	
	@XmlElement(name = "user")
	private ArrayList<User> users = new ArrayList<User>();
	
	public ArrayList<User> getUsers(){
		return users;
	}
}
