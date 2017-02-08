package com.example.producer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer.service.ItemService;

@RestController
public class ItemResource {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/greet/{name}")
	public void publish(@PathVariable String name) {
		itemService.sendMessage(name);
	}

}
