package uts.polsys;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable{

	private static final long serialVersionUID = 20046908560066955L;
	
	@XmlElement(name = "userid")
	private String userid;
	@XmlElement(name = "username")
	private String username;
	@XmlElement(name = "fullName")
	private String fullName;
	@XmlElement(name = "password")
	private String password;
	
	@XmlElement(name = "meeting")
	private ArrayList<Meeting> meetings = new ArrayList<Meeting>();
	
	public String getUserName(){
		return username;
	}
	
	public String getPassword(){
		return password;
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

	public String getUserId() {
		// TODO Auto-generated method stub
		return userid;
	}
	
	
}
