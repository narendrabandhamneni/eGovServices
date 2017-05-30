package org.egov.property.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.egov.models.IdGenerationRequest;
import org.egov.models.IdGenerationResponse;
import org.egov.models.IdRequest;
import org.egov.models.Property;
import org.egov.models.PropertyRequest;
import org.egov.property.propertyConsumer.Producer;
import org.egov.property.util.PropertyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="/properties/")
public class PropertyController {

	@Autowired
	PropertyValidator propertyValidator;

	@Autowired
	Producer producer;

	@Autowired
	Environment environment;

	@Autowired
	RestTemplate restTemplate;


	@RequestMapping(method=RequestMethod.POST,path="_create")
	public List<String> createProperty(@Valid @RequestBody PropertyRequest propertyRequest){
        List<String> applicationList=new ArrayList<String>();
        
        //Boundary validations for all properties
		for(Property property :propertyRequest.getProperties()){
			propertyValidator.validatePropertyBoundary(property);		
		}
		
		//generating acknowledgement number for all properties
		for(Property property:propertyRequest.getProperties()){
			IdRequest idrequest=new IdRequest();
			idrequest.setEntity(environment.getProperty(environment.getProperty("id.entity")));
			idrequest.setIdType(environment.getProperty("id.type"));
			idrequest.setTenentId(propertyRequest.getProperties().get(0).getTenantId());
			IdGenerationRequest idGeneration=new IdGenerationRequest();
			idGeneration.setIdRequest(idrequest);
			idGeneration.setRequestInfo(propertyRequest.getRequestInfo());
			IdGenerationResponse idResponse=restTemplate.patchForObject(environment.getProperty("id.creation"), idGeneration, IdGenerationResponse.class);
			property.getPropertydetails().setApplicationNo(idResponse.getIdResponse().getId());		
			applicationList.add(idResponse.getIdResponse().getId());
		}
		producer.send(environment.getProperty("property.create"), propertyRequest);
		
		return applicationList;
	}


}
