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
	
}
