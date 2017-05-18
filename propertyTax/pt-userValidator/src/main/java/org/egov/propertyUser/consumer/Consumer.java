package org.egov.propertyUser.kafka;

import org.egov.models.RequestInfo;
import org.egov.propertyUser.model.UserRequestInfo;
import org.egov.propertyUser.model.UserResonseInfoModel;
import org.egov.propertyUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class Consumer {

	@Autowired
	UserService userService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Environment env;


	@Autowired
	private KafkaTemplate<String, UserRequestInfo> kafkaTemplate;

	@KafkaListener(topics = "${topic.property}")
	public void receive(UserRequestInfo userRequestInfo) {

		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(env.getProperty("user.serviceUrl"))
				// Add query parameter
				.queryParam("userName", userRequestInfo.getUser().getUsername())
				.queryParam("id", userRequestInfo.getUser().getId())
				.queryParam("userType", userRequestInfo.getUser().getId())
				.queryParam("tenantId", userRequestInfo.getUser().getTenantId());

		HttpEntity<RequestInfo> entity=new HttpEntity<RequestInfo>(userRequestInfo.getRequestInfo());

		ResponseEntity<UserResonseInfoModel> searchResponse=	restTemplate.exchange(builder.build(true).toUri(), HttpMethod.POST,entity , UserResonseInfoModel.class);
		if(searchResponse.getStatusCodeValue()==400){
			UserResonseInfoModel createResponse=restTemplate.postForObject(env.getProperty("user.createUrl"),userRequestInfo, UserResonseInfoModel.class);
			if(createResponse!=null){
				userRequestInfo.getUser().setId(createResponse.getUser().getId());
				kafkaTemplate.send(env.getProperty("topic.property"), userRequestInfo);
			}
		}

		else if(searchResponse.getStatusCodeValue()==200){
			userRequestInfo.getUser().setId(searchResponse.getBody().getUser().getId());
			kafkaTemplate.send(env.getProperty("topic.property"),userRequestInfo);
		}

	}
}
