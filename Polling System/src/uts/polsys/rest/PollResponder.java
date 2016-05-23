package uts.polsys.rest;

import uts.polsys.*;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import uts.polsys.Meeting;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PollResponder {
	
	public PollResponder(){
		super();
	}
	public PollResponder(ArrayList<Meeting> meetings){
		super();
		this.meetings = meetings;
	}
	
	@XmlElement(name = "meeting")
	private ArrayList<Meeting> meetings = new ArrayList<Meeting>();
	
	
}
