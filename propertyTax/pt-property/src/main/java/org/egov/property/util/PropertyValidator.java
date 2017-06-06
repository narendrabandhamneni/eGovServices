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

/**
 * This Service to validate the property attributes
 * @author Pavan Kumar Kamma
 *
 */

@Service
public class PropertyValidator {

	@Autowired
	private Environment env;

	@Autowired
	RestTemplate restTemplate;

	/**
	 * Description : This validates the property boundary
	 * @param property
	 * @throws InvalidPropertyBoundaryException
	 */
	public void validatePropertyBoundary(Property property) throws InvalidPropertyBoundaryException{

		PropertyLocation propertyLocation = property.getBoundary();
		List<String> fields = propertyLocation.getAllBoundaries();
		for(String field:fields){
			validateBoundaryFields(property, field);
		}
	}

	/**
	 * Description : This validates the each boundary field of the property
	 * @param property
	 * @param field
	 * @return true
	 * @throws InvalidPropertyBoundaryException
	 */
	public Boolean validateBoundaryFields(Property property, String field) throws InvalidPropertyBoundaryException{

		PropertyLocation propertyLocation = property.getBoundary();
		Long id;

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
			if(boundaryResponseInfo.getResponseInfo()!=null && boundaryResponseInfo.getBoundary().size()!=0){
				return true;
			} else {
				throw new InvalidPropertyBoundaryException();
			}
		} catch (HttpClientErrorException ex){
			throw new InvalidPropertyBoundaryException();
		}
	}
}
