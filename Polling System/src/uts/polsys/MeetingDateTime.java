package uts.polsys;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MeetingDateTime implements Serializable{

	private static final long serialVersionUID = -6171546281865860717L;
	
	@XmlElement(name = "meetingDateTimeID")
	private String meetingDateTimeID;
	@XmlElement(name = "meetingDateTime")
	private String meetingDateTime;
	
	@XmlElement(name = "vote")
	private ArrayList<Vote> votes = new ArrayList<Vote>();
	
	public MeetingDateTime(){
		super();
	}
	
	public MeetingDateTime(String meetingDateTimeId, String meetingDateTime) {
		this.meetingDateTimeID = meetingDateTimeId;
		this.meetingDateTime = meetingDateTime;
	}
	
	public String getId() {
		// TODO Auto-generated method stub
		return meetingDateTimeID;
	}
	public String getMeetingDateTime(){
		return meetingDateTime;
	}
	
	//returns the array list of vote objects that contain the user id
	//this seems inneficient
	public ArrayList<Vote> getVotes(){
		return votes;
	}
	
	//returns the amount of votes for this meeting date time
	public int getVoteCount(){
		return votes.size();
	}
	public void vote(String userid) {
		// TODO Auto-generated method stub
		//votes = String.valueOf(Integer.parseInt(votes)+1);
		//changed votes to an object to keep track of users
		//each userid recorded will count as a vote
		votes.add(new Vote(userid));
	}
	
}
