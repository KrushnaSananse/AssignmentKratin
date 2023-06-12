package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojo.Reminder;
import com.app.service.ReminderService;

@CrossOrigin
@RestController
@RequestMapping("/reminder")
public class ReminderController {
	
	@Autowired
	private ReminderService remainService;
	
    @PostMapping("/saveReminder")
    public ResponseEntity<?> saveAppointment(@RequestBody Reminder reminder) {
        remainService.saveReminder(reminder);
		return ResponseEntity.ok().body("Reminder saved successfully");
    }
    	
	@GetMapping("/getAllRemainders")
	public ResponseEntity<?> GetAllRemainders(){
		return new ResponseEntity<>(remainService.getAllRemainders(),HttpStatus.OK) ;
	}

}
