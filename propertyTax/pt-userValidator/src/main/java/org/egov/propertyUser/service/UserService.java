package org.egov.propertyUser.service;

import org.egov.propertyUser.model.UserRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	

	@Autowired
	private KafkaTemplate<String, UserRequestInfo> kafkaTemplate;
	
	@Autowired
	
	private Environment env;

	public void sendUserToKafka(UserRequestInfo userRequestInfo) {
		kafkaTemplate.send(env.getProperty("topic.property"), userRequestInfo);
	
	}

	
	
	
}
