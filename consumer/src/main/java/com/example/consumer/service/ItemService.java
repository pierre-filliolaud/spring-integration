package com.example.consumer.service;

import org.springframework.stereotype.Service;

import com.example.domain.Item;

@Service
public class ItemService {
	
	public Item findCutomItem() {
		return new Item("name", "desc");
	}

}
