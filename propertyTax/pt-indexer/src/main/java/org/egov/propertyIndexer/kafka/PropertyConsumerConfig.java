package org.egov.propertyIndexer.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.egov.propertyIndexer.model.PropertyDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;


@Configuration
@EnableKafka
public class PropertyConsumerConfig {
	
	
	@Autowired
	private Environment environment;
	
	
	@Bean
	public Map<String,Object> consumerConfig(){
		Map<String,Object> consumerProperties=new HashMap<String,Object>();
		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, environment.getProperty("kafka.consumer.config.auto_offset_reset"));
		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, environment.getProperty("kafka.bootstrap-servers"));
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "mukunda");
		return consumerProperties;
	}
	
	@Bean
	public ConsumerFactory<String, PropertyDetails> consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(consumerConfig(),new StringDeserializer(),
		        new JsonDeserializer<>(PropertyDetails.class));
		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, PropertyDetails> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, PropertyDetails> factory=new ConcurrentKafkaListenerContainerFactory<String,PropertyDetails>();
		 factory.setConsumerFactory(consumerFactory());
		 return factory;
	}
	
	@Bean
	public PropertyConsumer receiver(){
		return new PropertyConsumer();
	}
}
