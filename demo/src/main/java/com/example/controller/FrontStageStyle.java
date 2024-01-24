package com.example.controller;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.frontStage.BigDiv;
import com.example.frontStage.fullView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FrontStageStyle {
	
	@PostMapping("/FrontStageSet/update")
	public String setStyle(@RequestBody  LinkedList<BigDiv> li) {
		System.out.println(li);
		
		  ObjectMapper objectMapper = new ObjectMapper();
          String jsonMessage = null;
		try {
			jsonMessage = objectMapper.writeValueAsString("ok");
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          return jsonMessage;
		
	}
}
