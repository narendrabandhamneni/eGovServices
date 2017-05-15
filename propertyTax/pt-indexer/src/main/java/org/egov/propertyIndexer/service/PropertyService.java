package org.egov.propertyindexer.service;

import org.egov.propertyindexer.model.PropertyDetails;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Prasad
 * 
 */
@Service
public interface PropertyService {
	
	/**
	 * 
	 * @param propertyDetails
	 * @return {@link PropertyDetails}
	 */
	
	// TODO Need to check with team ,about what should be the response ,after saving data in ES
	
	public void savePropertyInElasticSearch(PropertyDetails propertyDetails);

	/**
	 * 
	 * @param propertyDetails
	 * @return {@link String}
	 */
	
	// TODO Need to check with team ,about what should be the response ,after sending message to kafka server
	
	public String sendPropertyToKafka(PropertyDetails propertyDetails);

}
