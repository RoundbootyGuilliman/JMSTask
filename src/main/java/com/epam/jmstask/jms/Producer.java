package com.epam.jmstask.jms;

import com.epam.jmstask.rest.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import java.util.Date;

@Stateless
public class Producer {
	
	@Inject
	private ConnectionFactory connectionFactory;
	@Inject
	private Destination queue;
	
	public void sendMessage(Object object) {
		try (JMSContext context = connectionFactory.createContext()) {
			context.createProducer().send(queue, "MESSAGE: " + object);
		}
	}
}
