package uts.polsys;

import java.io.*;
import java.util.ArrayList;

import javax.xml.bind.*;



public class PolSysApp implements Serializable {

	/**
	 * Some inconsitancies with my naming conventions and Rosas data
	 * might be confusing, a poll is a Meeting or a poll for a meeting
	 * so if i call getAllPolls it returns all of the meetings
	 */
	private static final long serialVersionUID = 4117755568727158460L;
	private String filePath;
	private Polling polling;
	private User sessionUser;
	
	public PolSysApp(){
		super();
	}
	
	//this marshals the data from the filePath provided
	public void setFilePath(String filePath) throws JAXBException, IOException {
		
		JAXBContext jc = JAXBContext.newInstance(Polling.class);
		Unmarshaller u = jc.createUnmarshaller();
		FileInputStream fin = new FileInputStream(filePath);
		polling = (Polling)u.unmarshal(fin);
		fin.close();
		this.filePath = filePath;
	}
	
	public void saveData() throws JAXBException, IOException{
		JAXBContext jc = JAXBContext.newInstance(Polling.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//uses the filepath provided by setFilePath
		FileOutputStream fos = new FileOutputStream(filePath);
		m.marshal(polling, fos);
		fos.close();
	}
	
	public ArrayList<User> getUsers(){
		//System.out.println(polling.getUsers().isEmpty());
		return polling.getUsers();
	}
	
	//for task login and logout
	public String login(String username, String password){
		for(User user : polling.getUsers()){
			if(user.getUserName().equals(username) &&
					user.getPassword().equals(password)){
				sessionUser = user;
			}
		}
		return sessionUser.getUserName();
		
	}
	// for task create a new poll
	public void createNewPoll(String id, String pollTitle, String meetingLocation, String meetingDescription) throws JAXBException, IOException{
		sessionUser.createNewPoll(id, pollTitle, meetingLocation, meetingDescription);
		saveData();
	}
	//to add meeting times to a poll
	public void createPollMeetingTime(String pollId, String meetingDateTimeId, String meetingDateTime) throws JAXBException, IOException{
		getPoll(pollId).createMeetingDateTime(meetingDateTimeId, meetingDateTime);
		saveData();
	}
	
	//for task close a poll
	public void closePoll(String pollId) throws JAXBException, IOException{
		sessionUser.closePoll(pollId);
		saveData();
	}
	
	//creates a list of all open Polls (meeting object)
	//you will use this for selecting which poll to vote on
	public ArrayList<Meeting> getAllOpenPolls(){
		ArrayList<Meeting> allOpenPolls = new ArrayList<Meeting>();
		//nested for loop as we want all of the open polls for all of the users
		for(User u : polling.getUsers()){
			for(Meeting m : u.getPolls()){
				if(m.getStatus().equals("open")){
					allOpenPolls.add(m);
				}
			}
		}
		return allOpenPolls;
	}
	
	//return specified poll(meeting object)
	public Meeting getPoll(String pollId){
		for(Meeting m : getAllOpenPolls()){
			if(m.getId().equals(pollId)){
				return m;
			}
		}
		return null;
	}
	
	//returns all of the meeting date times so you can see what options you have for
	//voting on a particular poll
	public ArrayList<MeetingDateTime> getPollVotingOptions(String pollId){
		for(Meeting m : getAllOpenPolls()){
			if(m.getId().equals(pollId)){
				return m.getMeetingDateTimes();
			}
		}
		return null;
	}
	
	//returns a specific meeting date time from a specific poll (meeting)
	public MeetingDateTime getMeetingDateTime(String pollId, String meetingDateTimeID){
		for(Meeting m : getAllOpenPolls()){
			if(m.getId().equals(pollId)){
				for(MeetingDateTime mdt : m.getMeetingDateTimes()){
					if(mdt.getId().equals(meetingDateTimeID)){
						return mdt;
					}
				}
			}
		}
		return null;
	}
	
	public void voteOnPoll(String pollId, String meetingDateTimeID) throws JAXBException, IOException{
		MeetingDateTime mdt = getMeetingDateTime(pollId, meetingDateTimeID);
		if(mdt != null){
			mdt.vote();
			System.out.println("called");
			
		}
		saveData();
	}
	
	// for task View a list of their own existing polls 
	public ArrayList<Meeting> getSessionUsersPolls(){
		return sessionUser.getPolls();
	}
	
	
	public String getFilePath() {
		return filePath;
	}
}
