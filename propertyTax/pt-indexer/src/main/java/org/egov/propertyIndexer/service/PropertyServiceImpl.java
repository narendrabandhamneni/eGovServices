package org.egov.propertyindexer.service;

import org.egov.propertyindexer.entity.PropertyDetailsElasticSearch;
import org.egov.propertyindexer.model.PropertyDetails;
import org.egov.propertyindexer.repository.PropertyElasticSearchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class PropertyServiceImpl  implements PropertyService{

	@Autowired
	private KafkaTemplate<String, PropertyDetails> kafkaTemplate;
	
	@Autowired
	private Environment environment;

	@Autowired
	PropertyElasticSearchRepository propertyElasticSearchRepository;
	
	@Override
	public void savePropertyInElasticSearch(PropertyDetails prop) {

		ModelMapper mapper=new ModelMapper();
	
		PropertyDetailsElasticSearch propetyDetailsData=mapper.map(prop,PropertyDetailsElasticSearch.class);
		propetyDetailsData=propertyElasticSearchRepository.save(propetyDetailsData);
		

		//return mapper.map(propetyDetailsData, PropertyDetails.class);

	}

	@Override
	public String sendPropertyToKafka(PropertyDetails propertyDetails) {
		kafkaTemplate.send(environment.getProperty("kafka.topics.save.property"), propertyDetails);
		
		return"Sucessfully sent message to kafka queue ";
	}

}
