package org.egov.property.api;

import org.egov.models.PropertyRequest;
import org.egov.models.Property;
import org.egov.property.validator.PropertyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/properties/")
public class PropertyController {
	
	@Autowired
	PropertyValidator propertyValidator;
	@RequestMapping(method=RequestMethod.POST,path="_create")
	public String createProperty(PropertyRequest propertyRequest){
		for(Property property :propertyRequest.getProperties()){
			propertyValidator.validatePropertyBoundary(property);
		}
		return "";
	}

}
