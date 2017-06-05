package org.egov.property.util;

import java.net.URI;
import java.util.List;

import org.egov.models.Property;
import org.egov.models.PropertyLocation;
import org.egov.property.exception.InvalidPropertyBoundaryException;
import org.egov.property.model.BoundaryResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PropertyValidator {

	@Autowired
	private Environment env;

	@Autowired
	RestTemplate restTemplate;

	public void validatePropertyBoundary(Property property) throws InvalidPropertyBoundaryException{

		PropertyLocation propertyLocation = property.getBoundary();
		List<String> fields = propertyLocation.getAllBoundaries();
		for(String field:fields){
			validateBoundaryFields(property, field);
		}
	}
	
	public Boolean validateBoundaryFields(Property property, String field) throws InvalidPropertyBoundaryException{
		
		PropertyLocation propertyLocation = property.getBoundary();
		String id;
		if(field.equalsIgnoreCase("revenueBoundary")){
			id = propertyLocation.getRevenueBoundary().getId();
		} else if(field.equalsIgnoreCase("locationBoundary")){
			id = propertyLocation.getLocationBoundary().getId();
		} else {
			id = propertyLocation.getAdminBoundary().getId();
		}
		
		URI uri = UriComponentsBuilder.fromUriString(env.getProperty("boundary.boundaryUrl"))
				.queryParam("Boundary.tenantId", property.getTenantId())
				.queryParam("Boundary.id", id).build(true).encode().toUri();

		try {
			BoundaryResponseInfo boundaryResponseInfo = restTemplate.getForObject(uri, BoundaryResponseInfo.class);
			if(boundaryResponseInfo.getResponseInfo().getStatus().equalsIgnoreCase(env.getProperty("statusCode")) && boundaryResponseInfo.getBoundary().size()!=0){
				return true;
			} else {
				throw new InvalidPropertyBoundaryException();
			}
		} catch (HttpClientErrorException ex){
			throw new InvalidPropertyBoundaryException();
		}
	}
}
