package org.egov.propertyUser.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.egov.propertyUser.model.UserRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;



@Configuration
public class ProducerConfiguration {
	@Autowired
	private Environment envorniment;
	
	@Bean
	public Map<String,Object> producerConfig(){
		Map<String,Object> producerProperties=new HashMap<String,Object>();
		producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, envorniment.getProperty("bootstrap-servers"));
		producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return producerProperties;
	}
	
	@Bean
	public ProducerFactory<String, UserRequestInfo> producerFactory(){
		return new DefaultKafkaProducerFactory<>(producerConfig());
	}
	
	@Bean
	public KafkaTemplate<String, UserRequestInfo> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	@Bean
	public Producer producer(){
		return new Producer();
	}
}
