package uts.polsys;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Meeting implements Serializable{

	private static final long serialVersionUID = -2214715033634951514L;

	@XmlElement(name = "meetingID")
	private String meetingID;
	@XmlElement(name = "pollTitle")
	private String pollTitle;
	@XmlElement(name = "creationDate")
	private String creationDate;
	@XmlElement(name = "meetingLocation")
	private String meetingLocation;
	@XmlElement(name = "meetingDescription")
	private String meetingDescription;
	@XmlElement(name = "status")
	private String status;
	
	@XmlElement(name = "meetingDateTime")
	private ArrayList<MeetingDateTime> meetingDateTimes = new ArrayList<MeetingDateTime>();

	
	public Meeting(){
		super();
	}
	
	public Meeting(String id, String pollTitle, String meetingLocation, String meetingDescription) {
		// TODO Auto-generated constructor stub
		super();
		this.meetingID = id; //This should be auto generated
		this.pollTitle = pollTitle;
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		this.creationDate = df.format(dateobj);
		
		this.meetingLocation = meetingLocation;
		this.meetingDescription = meetingDescription;
		this.status = "open";
	}
	
	
	public Object getId() {
		// TODO Auto-generated method stub
		return meetingID;
	}
	public String getStatus() {
		// TODO Auto-generated method stub
		return this.status;
	}
	public String getPollTitle(){
		return pollTitle;
	}
	public String getCreationDate(){
		return creationDate;
	}
	public String getMeetingLocation(){
		return meetingLocation;
	}
	public String getMeetingDescription(){
		return meetingDescription;
	}

	public void closePoll() {
		// TODO Auto-generated method stub
		this.status = "closed";
		
	}

	public ArrayList<MeetingDateTime> getMeetingDateTimes() {
		// TODO Auto-generated method stub
		return meetingDateTimes;
	}

	public void createMeetingDateTime(String meetingDateTimeId, String meetingDateTime) {
		meetingDateTimes.add(new MeetingDateTime(meetingDateTimeId, meetingDateTime));
		
	}
}
