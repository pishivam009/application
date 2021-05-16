package com.piyush.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface LogModelRepo extends JpaRepository<LogModel, String>{

	List<LogModel> getByDate(String date);

}
