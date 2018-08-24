package com.epam.jmstask.jms;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

//@MessageDriven(mappedName = "java:/myQueue")
public class Consumer implements MessageListener {
	
	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("MESSAGE RECEIVED: " + message.getBody(String.class));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
