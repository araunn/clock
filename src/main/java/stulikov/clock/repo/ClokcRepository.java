package stulikov.clock.repo;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class ClokcRepository {
	
	  @PostConstruct
	   void createDB () {
		generateClockModeBases();
	  } 
	  
	HashMap<Integer,String> clockModeBases = new HashMap<Integer, String>();
	
	public void generateClockModeBases() {
		 clockModeBases.put(1, "Clock");
		 clockModeBases.put(2, "Calendar");
		 clockModeBases.put(3, "Clock Alarm");
	 }
	 
	public String getClokcMode(Integer clockMode) {
		 return clockModeBases.get(clockMode);
	 }
	
	public int getMaxModes () {
		return clockModeBases.size();
	}
}
