package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Nutrition;

public interface NutritionRepository extends JpaRepository<Nutrition, Long> {
	
	
}
