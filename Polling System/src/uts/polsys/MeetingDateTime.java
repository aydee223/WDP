package uts.polsys;

import java.io.Serializable;
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
	@XmlElement(name = "votes")
	private String votes;
	
	public MeetingDateTime(){
		super();
	}
	
	public MeetingDateTime(String meetingDateTimeId, String meetingDateTime) {
		this.meetingDateTimeID = meetingDateTimeId;
		this.meetingDateTime = meetingDateTime;
		this.votes = "0";
	}
	
	public String getId() {
		// TODO Auto-generated method stub
		return meetingDateTimeID;
	}
	public String getMeetingDateTime(){
		return meetingDateTime;
	}
	
	public String getVotes(){
		return votes;
	}
	public void vote() {
		// TODO Auto-generated method stub
		votes = String.valueOf(Integer.parseInt(votes)+1);
		
	}
	
}
