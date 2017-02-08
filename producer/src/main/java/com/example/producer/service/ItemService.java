package com.example.producer.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.example.domain.Item;
import com.example.producer.channel.ProducerChannels;

@Service
@EnableBinding(ProducerChannels.class)
//@EnableBinding(Source.class)
public class ItemService {
	
	private final MessageChannel consumer;

//	public ItemService() {
//		// TODO Auto-generated constructor stub
//	}
	
	public ItemService(ProducerChannels channels) {
		this.consumer = channels.consumer();
	}
	
	public void sendMessage(String name) {
		String greeting = "Hello, " + name + "!";
		Item item = new Item(name, greeting);
		Message<Item> msg = MessageBuilder.withPayload(item).build();
		this.consumer.send(msg);
	}
	
//    @InboundChannelAdapter(Source.OUTPUT)
//    public Item sendMessage2(String name) {
//		String greeting = "Hello, " + name + "!";
//		Item item = new Item(name, greeting);
//		return item;
//	}

}
