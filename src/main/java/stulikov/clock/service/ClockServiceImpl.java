package stulikov.clock.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stulikov.clock.Controller.ClockRestController;
import stulikov.clock.repo.ClokcRepository;
import stulikov.clock.service.api.ClockApi;

@Service
@EntityScan({"stulikov.clock"})
@Transactional(readOnly = true)
public class ClockServiceImpl implements ClockApi{
	Logger LOG = LoggerFactory.getLogger(ClockRestController.class);
    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

	@Autowired
	ClokcRepository clockRepo;

	@Value("${clockMode.count:1}")   
	int clockMode;   
	
	int maxModes;

	  @PostConstruct
	   void maxModesCount () {
		maxModes= clockRepo.getMaxModes();
	  } 
  
	@Override
	public String getTime() {
			LocalDateTime time= LocalDateTime.now();
	return "Current time: " + time.format(formatter);
		}
	
	@Override
	public String setMethodA() {
		String res = clockRepo.getClokcMode(clockMode);
		LOG.trace("Respons from DB {}", res);   
		if (res==null) {
			return "Wrong clock Mode. Not exist mode: " + clockMode;
		}
		return "Working mode: "+res+" and method: A";
	}

	@Override
	public String setMethodB() {
		String res = clockRepo.getClokcMode(clockMode);
		LOG.trace("Respons from DB {}", res);
		if (res==null) {
			return "Wrong clock Mode. Not exist mode: " + clockMode;
		}
		return "Working mode: "+res+" and method: B";
	}

	@Override
	@Transactional
	public String updateSwitch() {  
		clockMode++;
		if (clockMode > maxModes) {
			clockMode=1;
		}
		LOG.trace("Change clokMode. new value:{}",clockMode);
		String res = clockRepo.getClokcMode(clockMode);
		LOG.trace("Respons from DB {}", res);
		if (res==null) {
			clockMode=1;
			return "Wrong clock Mode. Set default mode: Clock";
		}
		return "Working method mode switching. Switched on mode: "+ res; 
	}

}
