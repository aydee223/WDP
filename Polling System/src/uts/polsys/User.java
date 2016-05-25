package uts.polsys;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable{

	private static final long serialVersionUID = 20046908560066955L;
	
	@XmlElement(name = "userId")
	private String userId;
	@XmlElement(name = "username")
	private String username;
	@XmlElement(name = "fullName")
	private String fullName;
	@XmlElement(name = "password")
	private String password;

	// added by rosa
	public User() {
		super();
	}
	// added by rosa
	public User(String userId, String username, String fullName, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.fullName = fullName;
		this.password = password;
	}

	@XmlElement(name = "meeting")
	private ArrayList<Meeting> meetings = new ArrayList<Meeting>();

	public String getUserId() {
		return userId;
	}
	//added by rosa
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName(){
		return username;
	}
	//added by rosa
	public void setUsername(String username) {
		this.username = username;
	}
	//added by rosa
	public String getFullName() {
		return fullName;
	}
	//added by rosa
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword(){
		return password;
	}
	//added by rosa
	public void setPassword(String password) {
		this.password = password;
	}


	public void createNewPoll(String id, String pollTitle, String meetingLocation, String meetingDescription) {
		// TODO Auto-generated method stub
		meetings.add(new Meeting(id, pollTitle, meetingLocation, meetingDescription));
		
	}

	public boolean closePoll(String pollId) {
		// TODO Auto-generated method stub
		for(Meeting m : meetings){
			if(m.getId().equals(pollId)){
				m.closePoll();
				return true;
			}
		}
		return false;
	}

	public ArrayList<Meeting> getPolls() {
		return this.meetings;
	}

	
	
}
