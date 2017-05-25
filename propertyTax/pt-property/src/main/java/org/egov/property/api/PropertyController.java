package org.egov.property.api;

import org.egov.models.PropertyRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/properties/")
public class PropertyController {
	
	@RequestMapping(method=RequestMethod.POST,path="_create")
	public String createProperty(PropertyRequest propertyRequest){
	
		return "";
	}

}
