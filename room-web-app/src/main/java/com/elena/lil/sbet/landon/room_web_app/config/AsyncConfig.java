package com.elena.lil.sbet.landon.room_web_app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.elena.lil.sbet.landon.room_web_app.async.RoomCleanerListener;
import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class AsyncConfig {
	private static final String QUEUE_NAME = "room-cleaner";
	private static final String ECHANGE_NAME = "operations";
	
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, false);
	}
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(ECHANGE_NAME);
	}
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("landon.rooms.cleaner");
	}
	
	@Bean
	public MessageListenerAdapter listenerAdapter(RoomCleanerListener listener) {
		return new MessageListenerAdapter(listener, "receiveMessage");
	}
	@Bean
	public SimpleMessageListenerContainer  container(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE_NAME);
		container.setMessageListener(listenerAdapter);
		return container;
		
		
	}
	
	

}
