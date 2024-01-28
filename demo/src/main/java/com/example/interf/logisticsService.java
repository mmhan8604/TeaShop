package com.example.interf;

import java.util.HashMap;

import com.example.classes.logisticsUpdateDTO;

public interface logisticsService {
	public HashMap<String, String> getLogistics(String email);
	public boolean update(String email,logisticsUpdateDTO lud);
}
