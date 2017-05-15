package org.egov.propertyindexer.controller;

import org.egov.propertyindexer.model.PropertyDetails;
import org.egov.propertyindexer.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Prasad
 * 
 * This class will delegate calls to the respected api's based on the incoming request end points
 */
@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	
	@RequestMapping(value="/send",method=RequestMethod.POST)
	public String send(@RequestBody PropertyDetails propertyDetails){
		return propertyService.sendPropertyToKafka(propertyDetails);
		
	}

}
