package org.egov.boundary.BoundaryConsumer;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.egov.boundary.model.BoundaryResponseInfo;
import org.egov.models.PropertyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@SuppressWarnings("unused")
@Service
public class Consumer {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Environment env;

	@Autowired
	private KafkaTemplate<String, PropertyRequest> kafkaTemplate;
	
	@Bean
	public Map<String,Object> consumerConfig(){
		Map<String,Object> consumerProperties=new HashMap<String,Object>();
		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, env.getProperty("autoOffsetResetConfig"));
		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, env.getProperty("bootstrap-servers"));
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "boundary");
		return consumerProperties;
	}
	
	@Bean
	public ConsumerFactory<String, PropertyRequest> consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(consumerConfig(),new StringDeserializer(),
		        new JsonDeserializer<>(PropertyRequest.class));
		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, PropertyRequest> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, PropertyRequest> factory=new ConcurrentKafkaListenerContainerFactory<String,PropertyRequest>();
		 factory.setConsumerFactory(consumerFactory());
		 return factory;
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@KafkaListener(topics="#{environment.getProperty('boundary.property')}")
	public void receive(PropertyRequest propertyRequest) {
		
		URI uri = UriComponentsBuilder.fromUriString(env.getProperty("boundary.boundaryUrl"))
				.queryParam("Boundary.tenantId", propertyRequest.getProperties().get(0).getBoundary().getTenantId())
				.queryParam("Boundary.id", propertyRequest.getProperties().get(0).getBoundary().getId()).build(true).encode().toUri();
		
		BoundaryResponseInfo boundaryResponseInfo = restTemplate.getForObject(uri, BoundaryResponseInfo.class);
		
		if(boundaryResponseInfo.getResponseInfo().getStatus().equalsIgnoreCase(env.getProperty("statusCode"))){
			kafkaTemplate.send(env.getProperty("boundary.boundaryUpdateProperty"), propertyRequest);
		} else {
			//TODO if boundary for the property is invalid 
		}

	}
}
