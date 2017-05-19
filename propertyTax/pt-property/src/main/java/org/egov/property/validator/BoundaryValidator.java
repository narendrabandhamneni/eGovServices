package org.egov.property.validator;

import java.net.URI;

import org.egov.boundary.model.BoundaryResponseInfo;
import org.egov.models.PropertyRequest;
import org.egov.property.exception.InvalidPropertyBoundaryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class BoundaryValidator {
	
	private Environment env;
	
	@Autowired
	RestTemplate restTemplate;
	
	public void validatePropertyBoundary(PropertyRequest propertyRequest) throws InvalidPropertyBoundaryException{
		
		URI uri = UriComponentsBuilder.fromUriString(env.getProperty("boundary.boundaryUrl"))
				.queryParam("Boundary.tenantId", propertyRequest.getProperties().get(0).getBoundary().getTenantId())
				.queryParam("Boundary.id", propertyRequest.getProperties().get(0).getBoundary().getId()).build(true).encode().toUri();
		
		BoundaryResponseInfo boundaryResponseInfo = restTemplate.getForObject(uri, BoundaryResponseInfo.class);
		
		if(boundaryResponseInfo.getResponseInfo().getStatus().equalsIgnoreCase(env.getProperty("statusCode"))){
			//property is valid
		} else {
			throw new InvalidPropertyBoundaryException();
		}

	}
}
