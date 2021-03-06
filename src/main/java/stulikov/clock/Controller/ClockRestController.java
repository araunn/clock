package stulikov.clock.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stulikov.clock.service.api.ClockApi;

@RestController 
@RequestMapping("clock")
public class ClockRestController {
  Logger LOG = LoggerFactory.getLogger(ClockRestController.class);

  @Autowired
  ClockApi service;
  
  @GetMapping ("/time")
  String getActualTime() {
	String res = service.getTime();  
	LOG.debug(res);
	return res;
  }
  
  @PutMapping ("/methodA")
  String setMethodA() {
	String res = service.setMethodA();  
	LOG.debug(res);
	return res;
  }
  
  @PutMapping ("/methodB")
  String setMethodB() {
	String res = service.setMethodB();  
	LOG.debug(res);
	return res;
  }
  
  @PutMapping ("/switch") 
  String updateSwitch() {
	String res = service.updateSwitch();  
	LOG.debug(res);
	return res;
  }
}
