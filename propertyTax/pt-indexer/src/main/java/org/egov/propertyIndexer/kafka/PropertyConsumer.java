package org.egov.propertyIndexer.kafka;

import org.egov.propertyIndexer.model.PropertyDetails;
import org.egov.propertyIndexer.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class PropertyConsumer {
	@Autowired
	PropertyService propertyService;
	@Autowired
	private Environment environment;
	
	// TODO Hey there need to read topic name from application properties via environment
	
	
	@KafkaListener(topics = "pankaj")
	  public void receive( PropertyDetails propertyDetails) {
		propertyService.savePropertyInElasticSearch(propertyDetails);
		
	  }
}
