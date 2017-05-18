package org.egov.boundary.kafka;

import java.net.URI;

import org.egov.boundary.model.BoundaryResponseInfo;
import org.egov.models.PropertyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class Consumer {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Environment env;

	@Autowired
	private KafkaTemplate<String, PropertyRequest> kafkaTemplate;
	
	@KafkaListener(topics = "${topic.property}")
	public void receive(PropertyRequest propertyRequest) {
		
		URI uri = UriComponentsBuilder.fromUriString(env.getProperty("boundary.boundaryUrl"))
				.queryParam("Boundary.tenantId", "default")
				.queryParam("Boundary.id", "1").build(true).encode().toUri();
		
		String boundaryResponseInfo=	restTemplate.getForObject(uri, String.class);
		System.out.println(boundaryResponseInfo);
//		if(boundaryResponseInfo.getResponseInfo().getStatus().equalsIgnoreCase(env.getProperty("statusCode"))){
//			kafkaTemplate.send(env.getProperty("topic.boundaryUpdateProperty"), propertyRequest);
//		}

	}
}
