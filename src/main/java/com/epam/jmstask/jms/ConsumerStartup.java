package com.epam.jmstask.jms;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;


@Startup
@Singleton
//@JMSConnectionFactoryDefinition(name = "java:/ConnectionFactory")
//@JMSDestinationDefinition(name = "java:/myQueue", interfaceName = "javax.jms.Queue")
public class ConsumerStartup {
	
	@Inject
	private ConnectionFactory connectionFactory;
	@Inject
	private Destination queue;
	
	@PostConstruct
	private void execute() {
		
		System.out.println("STARTED");
		
		JMSContext context = connectionFactory.createContext();
		context.createConsumer(queue).setMessageListener(new Consumer());
	}
}
