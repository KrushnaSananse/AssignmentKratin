package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.NutritionRepository;
import com.app.pojo.Nutrition;


@Service
@Transactional
public class NutritionService {

	@Autowired
	private NutritionRepository nutritionRepo;

	public Nutrition saveNutrition(Nutrition nutrition) {
		return nutritionRepo.save(nutrition);
	}
	
	public List<Nutrition> getAllNutrition(){
		return nutritionRepo.findAll();
	}
}
