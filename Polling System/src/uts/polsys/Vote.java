package uts.polsys;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Vote implements Serializable{

	private static final long serialVersionUID = 4875187255743049819L;
	@XmlElement(name = "votername")
	private String votername;
	
	public Vote(){
		super();
	}
	
	public Vote(String votername){
		this.votername = votername;
	}
	
	public String getUserId(){
		return votername;
	}
	

}
