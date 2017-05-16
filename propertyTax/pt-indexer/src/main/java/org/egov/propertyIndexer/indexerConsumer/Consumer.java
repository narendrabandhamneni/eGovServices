package org.egov.propertyIndexer.indexerConsumer;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.egov.models.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Service;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;


@Service
public class Consumer {



	// TODO Hey there need to read topic name from application properties via environment


	@Autowired
	private Environment environment;

	@Autowired
	JestClient client;


	@Bean
	public Map<String,Object> consumerConfig(){
		Map<String,Object> consumerProperties=new HashMap<String,Object>();
		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, environment.getProperty("consumer.offset"));
		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, environment.getProperty("bootstrap.servers"));
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, environment.getProperty("consumer.group"));
		return consumerProperties;
	}

	@Bean
	public ConsumerFactory<String, Property> consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(consumerConfig(),new StringDeserializer(),
				new JsonDeserializer<>(Property.class));

	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Property> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Property> factory=new ConcurrentKafkaListenerContainerFactory<String,Property>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public JestClient getClient() {
		if (this.client==null){
			JestClientFactory factory = new JestClientFactory();
			factory.setHttpClientConfig(new HttpClientConfig
					.Builder("http://"+environment.getProperty("elasticsearch.host")+":"+environment.getProperty("elasticsearch.host"))
					.multiThreaded(Boolean.valueOf(environment.getProperty("multiThread")))
					.readTimeout(Integer.valueOf(environment.getProperty("timeout")))
					.build());
			this.client = factory.getObject();

		}

		return this.client;
	}

    @KafkaListener(topics={})
	public void recive(Property property){

    	Map<String,Property> propertyMap=new HashMap<String,Property>();
    	propertyMap.put("property", property);
    	
	}


}
