package com.app.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
	
}
