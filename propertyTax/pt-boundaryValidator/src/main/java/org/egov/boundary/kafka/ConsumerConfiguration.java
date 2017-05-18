package org.egov.boundary.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.egov.boundary.model.BoundaryRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableKafka
public class ConsumerConfiguration {
	@Autowired
	private Environment envorniment;
	
	@Bean
	public Map<String,Object> consumerConfig(){
		Map<String,Object> consumerProperties=new HashMap<String,Object>();
		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, envorniment.getProperty("autoOffsetResetConfig"));
		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, envorniment.getProperty("bootstrap-servers"));
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "boundary");
		return consumerProperties;
	}
	
	@Bean
	public ConsumerFactory<String, BoundaryRequestInfo> consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(consumerConfig(),new StringDeserializer(),
		        new JsonDeserializer<>(BoundaryRequestInfo.class));
		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, BoundaryRequestInfo> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, BoundaryRequestInfo> factory=new ConcurrentKafkaListenerContainerFactory<String,BoundaryRequestInfo>();
		 factory.setConsumerFactory(consumerFactory());
		 return factory;
	}
	
	@Bean
	public Consumer consumer() {
		return new Consumer();
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
