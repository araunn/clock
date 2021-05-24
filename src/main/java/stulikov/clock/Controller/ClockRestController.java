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
  String getMethodA() {
	String res = service.getMethodA();  
	LOG.debug(res);
	return res;
  }
  
  @PutMapping ("/methodB")
  String getMethodB() {
	String res = service.getMethodB();  
	LOG.debug(res);
	return res;
  }
  
  @PutMapping ("/switch") 
  String getMethodC() {
	String res = service.getSwitch();  
	LOG.debug(res);
	return res;
  }
}
