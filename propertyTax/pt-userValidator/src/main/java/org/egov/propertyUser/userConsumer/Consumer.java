package org.egov.propertyUser.userConsumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.egov.models.Property;
import org.egov.models.PropertyRequest;
import org.egov.models.User;
import org.egov.models.UserAuthResponseInfo;
import org.egov.models.UserRequest;
import org.egov.propertyUser.model.UserRequestInfo;
import org.egov.propertyUser.model.UserResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * Consumer class will use for listing  property object from kafka server. 
 * Authenticate the user
 * Search the user
 * Create the user
 * If user exist update the user id 
 * otherwise create the user
 * 
 * @author: S Anilkumar
 */

@RestController
@SuppressWarnings("unused")
public class Consumer {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Environment environment;

	@Autowired
	private Producer producer;


	/*
	 * This method for creating rest template
	 */
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}



	/**
	 * This method for getting consumer configuration bean
	 */
	@Bean
	public Map<String,Object> consumerConfig(){
		Map<String,Object> consumerProperties=new HashMap<String,Object>();
		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, environment.getProperty("autoOffsetResetConfig"));
		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, environment.getProperty("bootstrap-servers"));
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "user");
		return consumerProperties;
	}

	/**
	 * This method will return the consumer factory bean based on consumer configuration
	 */
	@Bean
	public ConsumerFactory<String, PropertyRequest> consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(consumerConfig(),new StringDeserializer(),
				new JsonDeserializer<>(PropertyRequest.class));

	}

	/**
	 * This bean will return kafka listner object based on consumer factory
	 */
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, PropertyRequest> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, PropertyRequest> factory=new ConcurrentKafkaListenerContainerFactory<String,PropertyRequest>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}


	/**
	 * This method will listen property object from producer and check user authentication
	 *  Updating auth token in UserAuthResponseInfo
	 *  Search user
	 *  Create user
	 */
	@KafkaListener(topics ="#{environment.getProperty('validate.user')}")
	public void receive(PropertyRequest propertyRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization",environment.getProperty("authkey") );

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("username", environment.getProperty("oauth.username"));
		map.add("password", environment.getProperty("password"));
		map.add("grant_type", environment.getProperty("grant_type"));
		map.add("scope", environment.getProperty("scope"));
		map.add("tenantId",propertyRequest.getProperties().get(0).getOwners().get(0).getTenantId());

		HttpEntity<MultiValueMap<String, String>> requestEntity= 
				new HttpEntity<MultiValueMap<String, String>>(map, headers);

		// authentication verification
		UserAuthResponseInfo userAuthResponseInfo=	restTemplate.postForObject(environment.getProperty("user.auth"), requestEntity, UserAuthResponseInfo.class);

		propertyRequest.getRequestInfo().setAuthToken(userAuthResponseInfo.getAccess_token());

		for(Property property:propertyRequest.getProperties()){
			for(User user: property.getOwners()){
				if(user.getId() !=null){

					Map<String,Object> userSearchRequestInfo=new HashMap<String,Object >();
					userSearchRequestInfo.put("username",user.getUserName());
					userSearchRequestInfo.put("tenantId",user.getTenantId());
					userSearchRequestInfo.put("RequestInfo",propertyRequest.getRequestInfo());

					//search user
					UserResponseInfo userResponse= restTemplate.postForObject(environment.getProperty("user.searchUrl"), userSearchRequestInfo, UserResponseInfo.class);

					if(userResponse.getResponseInfo()!=null){
						if(userResponse.getUser()==null){
							UserRequestInfo userRequestInfo=new UserRequestInfo();
							userRequestInfo.setRequestInfo(propertyRequest.getRequestInfo());
							userRequestInfo.setUser(user);
							UserResponseInfo userCreateResponse = restTemplate.postForObject(environment.getProperty("user.createUrl"),
									userRequestInfo, UserResponseInfo.class);	
						}
						else{
							user.setId(userResponse.getUser().get(0).getId());
						}
					}

				}else{
					UserRequestInfo userRequestInfo=new UserRequestInfo();
					userRequestInfo.setRequestInfo(propertyRequest.getRequestInfo());
					userRequestInfo.setUser(user);

					//create user
					UserResponseInfo userCreateResponse = restTemplate.postForObject(environment.getProperty("user.createUrl"),
							userRequestInfo, UserResponseInfo.class);
					user.setId(userCreateResponse.getUser().get(0).getId());
				}
				producer.kafkaTemplate.send(environment.getProperty("update.user"), propertyRequest);
			}
		}

	}

}
