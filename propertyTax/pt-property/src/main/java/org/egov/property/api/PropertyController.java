package org.egov.property.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.egov.models.AttributeNotFoundException;
import org.egov.models.IdGenerationRequest;
import org.egov.models.IdGenerationResponse;
import org.egov.models.IdRequest;
import org.egov.models.Property;
import org.egov.models.PropertyRequest;
import org.egov.models.PropertyResponse;
import org.egov.models.ResponseInfo;
import org.egov.models.ResponseInfoFactory;
import org.egov.property.propertyConsumer.Producer;
import org.egov.property.util.PropertyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * Property Controller have the api's related to property
 * @author Narendra
 */
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

	@Autowired
	ResponseInfoFactory responseInfoFactory;


	/**
	 * description:cretae property api for creating new property
	 * @param propertyRequest
	 * @return propertyResponse
	 */

	@RequestMapping(method=RequestMethod.POST,path="_create")
	public PropertyResponse createProperty(@Valid @RequestBody PropertyRequest propertyRequest){
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
			if(idResponse.getResponseInfo().getStatus().toString().equalsIgnoreCase(environment.getProperty("success"))){
				if(idResponse.getResponseInfo().getStatus().toString().equalsIgnoreCase(environment.getProperty("failed"))){
					throw new AttributeNotFoundException(environment.getProperty("attribute.notfound"),propertyRequest.getRequestInfo());
				}
			}
			property.getPropertyDetail().setApplicationNo(idResponse.getIdResponse().getId());		
			applicationList.add(idResponse.getIdResponse().getId());
			PropertyRequest propertyRequestInfo=new PropertyRequest();
			propertyRequestInfo.setRequestInfo(propertyRequest.getRequestInfo());
			List<Property> propertyList=new ArrayList<Property>();
			propertyList.add(property);
			propertyRequestInfo.setProperties(propertyList);
			producer.send(environment.getProperty("property.create"), propertyRequestInfo);
		}

		ResponseInfo responseInfo=responseInfoFactory.createResponseInfoFromRequestInfo(propertyRequest.getRequestInfo(),true);
		PropertyResponse propertyResponse=new PropertyResponse();
		propertyResponse.setResponseInfo(responseInfo);
		propertyResponse.setProperties(propertyRequest.getProperties());	
		return propertyResponse;

	}


}
