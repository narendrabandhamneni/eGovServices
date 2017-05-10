package org.egov.property.api;


import org.egov.property.model.MasterModel;
import org.egov.property.services.Masterservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path="/property")
public class PropertyMasterController {

	@Autowired
	Masterservice masterService;
	
	@RequestMapping(path="/propertyType/_search",method=RequestMethod.GET)
	public MasterModel GetPropertyTypes(@RequestParam long tenantId,@RequestParam int code){
		try{
		 
		return	masterService.GetPropertyTypes(tenantId, code);

		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return new MasterModel();
	}
}
