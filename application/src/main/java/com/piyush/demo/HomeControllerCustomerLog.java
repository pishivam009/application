package com.piyush.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControllerCustomerLog {
	
	@Autowired
	LogModelRepo logmodelrepo;
	
	@GetMapping("/getAllLog")
	public List<LogModel> getAllLog() {
		System.out.println("All log");
		return logmodelrepo.findAll();
	}
	
	@GetMapping("/getLog")
	public List<LogModel> getLogByDate(@RequestParam(value="date") String date) {
		return logmodelrepo.getByDate(date);
	}
	
	@GetMapping("/checkIn")
	public void checkIn(@RequestParam(value="name") String name) {
		LogModel lm= new LogModel();
		lm.setName(name);
		lm.setLogType("IN");
		
		LocalDate d= LocalDate.now();
		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String sd=d.format(df);
		LocalTime t=LocalTime.now();
		DateTimeFormatter tf=DateTimeFormatter.ofPattern("hh:mm:ss");
		String st=t.format(tf);
		
		lm.setDate(sd);
		lm.setTime(st);
		lm.setId(name+st);
		
		logmodelrepo.save(lm);
		
	}
	
	@GetMapping("/checkOut")
	public void checkOut(@RequestParam(value="name") String name) {
		LogModel lm= new LogModel();
		lm.setName(name);
		lm.setLogType("OUT");
		
		LocalDate d= LocalDate.now();
		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String sd=d.format(df);
		LocalTime t=LocalTime.now();
		DateTimeFormatter tf=DateTimeFormatter.ofPattern("hh:mm:ss");
		String st=t.format(tf);
		
		lm.setDate(sd);
		lm.setTime(st);
		lm.setId(name+st);
		
		logmodelrepo.save(lm);
		
	}
}
