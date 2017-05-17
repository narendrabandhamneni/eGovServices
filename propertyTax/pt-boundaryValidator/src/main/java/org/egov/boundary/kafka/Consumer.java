package org.egov.boundary.kafka;

import org.egov.boundary.model.BoundaryRequestInfo;
import org.egov.boundary.model.BoundaryResponseInfo;
import org.egov.models.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
	private KafkaTemplate<String, BoundaryRequestInfo> kafkaTemplate;
	
	@KafkaListener(topics = "${topic.property}")
	public void receive(BoundaryRequestInfo boundaryRequestInfo) {

		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(env.getProperty("boundary.boundaryUrl"))
				// Add query parameter
				.queryParam("tenantId", "default")
				.queryParam("locationName", "Kotta Peta Super Structure");

		HttpEntity<RequestInfo> entity=new HttpEntity<RequestInfo>(boundaryRequestInfo.getRequestInfo());

		ResponseEntity<BoundaryResponseInfo> searchResponse = restTemplate.exchange(builder.build(true).toUri(), HttpMethod.POST,entity , BoundaryResponseInfo.class);
		
		if(searchResponse.getStatusCodeValue()==200){
			kafkaTemplate.send(env.getProperty("topic.property"),boundaryRequestInfo);
		}

	}
}
