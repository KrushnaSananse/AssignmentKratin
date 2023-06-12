package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Nutrition;
import com.app.pojo.Reminder;
import com.app.service.NutritionService;
import com.app.service.ReminderService;

@CrossOrigin
@RestController
@RequestMapping("/nutrition")
public class NutritionController {
	
	@Autowired
	private NutritionService nutritionService;
	
	@PostMapping("/save")
    public ResponseEntity<?> saveNutrition(@RequestBody Nutrition nutrition) {
		System.out.println("Nutrition"+ nutrition);
		nutritionService.saveNutrition(nutrition);
    	return new ResponseEntity<>("Entry Saved Successfully",HttpStatus.OK);
    }
	
	@GetMapping("/getNutrition")
	public List<Nutrition> getNutrition(){
		return nutritionService.getAllNutrition();	
	}
	
}
