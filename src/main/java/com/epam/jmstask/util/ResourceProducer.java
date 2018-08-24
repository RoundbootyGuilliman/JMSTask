package com.epam.jmstask.util;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;

public class ResourceProducer {
	
	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	
	@Resource(lookup = "java:/myQueue")
	private Destination destination;
	
	@Produces
	private ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}
	
	@Produces
	private Destination getQueue() {
		return destination;
	}
}
