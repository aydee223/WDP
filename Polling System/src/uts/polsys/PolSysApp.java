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
	
	
/*	//commented by rosa
	//for task login and logout
	//public String login(String username, String password){
	//added by rosa
	public User login(String username, String password){
		for(User user : polling.getUsers()){
			if(user.getUserName().equals(username) &&
					user.getPassword().equals(password)){
				sessionUser = user;
				//added by rosa
				return sessionUser;
			}
		}
		//return sessionUser.getUserName();
		//added by rosa
		return null;
	}
*/
	
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
		return getPollsByStatus("open");
	}
	
	public ArrayList<Meeting> getAllClosedPolls(){
		return getPollsByStatus("closed");
	}
	
	public ArrayList<Meeting> getPollsByStatus(String status){
		ArrayList<Meeting> polls = new ArrayList<Meeting>();
		for(User u : polling.getUsers()){
			for(Meeting m : u.getPolls()){
				if(m.getStatus().equals(status)){
					polls.add(m);
				}
			}
		}
		return polls;
	}
	
	//creates a list of all Polls (meeting object)
	public ArrayList<Meeting> getAllPolls() {
		ArrayList<Meeting> allPolls = new ArrayList<Meeting>();
		for(User u : polling.getUsers()){
			for(Meeting m : u.getPolls()){
				allPolls.add(m);
			}
		}
		return allPolls;
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
	
	public void voteOnPoll(String pollId, String meetingDateTimeID, String voterName) throws JAXBException, IOException{
		MeetingDateTime mdt = getMeetingDateTime(pollId, meetingDateTimeID);
		if(mdt != null){
			//mdt.vote(sessionUser.getUserId());
			//voter does not have to be logged in to vote, voter name is supplied in form
			mdt.vote(voterName);
			
		}
		saveData();
	}
	
	// for task View a list of their own existing polls 
	public ArrayList<Meeting> getSessionUsersPolls(){
		return sessionUser.getPolls();
	}
	
	//get all the polls by a user
	public ArrayList<Meeting> getPollsByUser(String userid){

		for(User u : polling.getUsers()){
			//System.out.println(u.getUserId() + "and " + userid);
			if(u.getUserId().equals(userid)){
				return u.getPolls();
			}
		}
		return null;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public Polling getPolling() {
		// TODO Auto-generated method stub
		return this.polling;
	}


}
