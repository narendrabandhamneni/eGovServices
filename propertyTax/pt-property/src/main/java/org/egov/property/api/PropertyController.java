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
import org.egov.models.RequestInfoWrapper;
import org.egov.models.ResponseInfo;
import org.egov.models.ResponseInfoFactory;
import org.egov.property.propertyConsumer.Producer;
import org.egov.property.services.PersisterService;
import org.egov.property.services.PropertySearchService;
import org.egov.property.util.PropertyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@Autowired
	PropertySearchService propertySearchService;
	
	@Autowired
	PersisterService persisterService;
	
	
	@RequestMapping(method = RequestMethod.POST, path = "send")
	public void Test(@RequestBody PropertyRequest propertyRequest) {
		producer.send(environment.getProperty("property.create"), propertyRequest);
	}
	
	@RequestMapping(method=RequestMethod.POST,path="_create")
    public PropertyResponse createProperty(@Valid @RequestBody PropertyRequest propertyRequest){
        List<String> applicationList=new ArrayList<String>();
        //Boundary validations for all properties
        for(Property property :propertyRequest.getProperties()){
            propertyValidator.validatePropertyBoundary(property,propertyRequest.getRequestInfo());      
        }

        StringBuffer idGenerationUrl=new StringBuffer();
        idGenerationUrl.append(environment.getProperty("egov.services.id_service.hostname"));
        idGenerationUrl.append(environment.getProperty("egov.services.id_service.basepath"));
        idGenerationUrl.append(environment.getProperty("egov.services.id_service.createpath"));

        //generating acknowledgement number for all properties
        for(Property property:propertyRequest.getProperties()){
            List<IdRequest> idRequests = new ArrayList<>();
            IdRequest idrequest=new IdRequest();
            idrequest.setIdName(environment.getProperty(environment.getProperty("id.idName")));
            idrequest.setTenantId(propertyRequest.getProperties().get(0).getTenantId());
            IdGenerationRequest idGeneration=new IdGenerationRequest();
            idRequests.add(idrequest);
            idGeneration.setIdRequests(idRequests); 
            idGeneration.setRequestInfo(propertyRequest.getRequestInfo());
            IdGenerationResponse idResponse=restTemplate.patchForObject(idGenerationUrl.toString(), idGeneration, IdGenerationResponse.class);
            if(idResponse.getResponseInfo().getStatus().toString().equalsIgnoreCase(environment.getProperty("success"))){
                if(idResponse.getResponseInfo().getStatus().toString().equalsIgnoreCase(environment.getProperty("failed"))){
                    throw new AttributeNotFoundException(environment.getProperty("attribute.notfound"),propertyRequest.getRequestInfo());
                }
            }
            property.getPropertyDetail().setApplicationNo(idResponse.getIdResponses().get(0).getId());      
            applicationList.add(idResponse.getIdResponses().get(0).getId());
            PropertyRequest propertyRequestInfo=new PropertyRequest();
            propertyRequestInfo.setRequestInfo(propertyRequest.getRequestInfo());
            List<Property> propertyList=new ArrayList<Property>();
            propertyList.add(property);
            propertyRequestInfo.setProperties(propertyList);
            producer.send(environment.getProperty("user.create"), propertyRequestInfo);
        }

        ResponseInfo responseInfo=responseInfoFactory.createResponseInfoFromRequestInfo(propertyRequest.getRequestInfo(),true);
        PropertyResponse propertyResponse=new PropertyResponse();
        propertyResponse.setResponseInfo(responseInfo);
        propertyResponse.setProperties(propertyRequest.getProperties());    
        return propertyResponse;

    }


	/**
	 * updateProperty method validate each property before update
	 * @param PropertyRequest
	 * */
	@RequestMapping(method=RequestMethod.POST,path="_update")
	public PropertyResponse updateProperty(@Valid @RequestBody PropertyRequest propertyRequest) {
		return propertyValidator.updateProperty(propertyRequest);
	}

	@RequestMapping(value="_search",method=RequestMethod.POST)
	public PropertyResponse propertySearch(
			@RequestBody RequestInfoWrapper requestInfo,
			@RequestParam(value="tenantId",required=true) String tenantId,
			@RequestParam(value="active",required=false) Boolean active ,
			@RequestParam(value ="upicNo",required=false) String upicNo,
			@RequestParam(value ="pageSize",required=false)Integer pageSize,
			@RequestParam(value="pageNumber",required=false)Integer pageNumber,
			@RequestParam (value="sort",required=false) String[] sort,
			@RequestParam(value="oldUpicNo",required=false) String oldUpicNo,
			@RequestParam(value="mobileNumber",required=false) String mobileNumber,
			@RequestParam(value="aadhaarNumber",required=false)String aadhaarNumber,
			@RequestParam(value="houseNoBldgApt",required=false)String houseNoBldgApt,
			@RequestParam(value="revenueZone",required=false) Integer revenueZone,
			@RequestParam(value="revenueWard",required=false) Integer revenueWard,
			@RequestParam(value="locality",required=false)Integer locality,
			@RequestParam(value="ownerName",required=false)String ownerName,
			@RequestParam(value="demandFrom",required=false)Integer demandFrom,
			@RequestParam(value="demandTo",required=false)Integer demandTo){
		if (pageSize ==null)
			pageSize=-1;

		if (pageNumber == null)
			pageNumber =-1;

		if ( revenueZone == null)
			revenueZone=-1;

		if ( revenueWard == null)
			revenueWard = -1;

		if ( locality == null)
			locality =-1;

		if ( demandFrom == null)
			demandFrom = -1;

		if ( demandTo == null)
			demandTo = -1;

		return propertySearchService.searchProperty(requestInfo.getRequestInfo(),
				tenantId, 
				active, 
				upicNo, 
				pageSize, 
				pageNumber,
				sort, 
				oldUpicNo, 
				mobileNumber,
				aadhaarNumber,
				houseNoBldgApt, 
				revenueZone, 
				revenueWard, 
				locality,
				ownerName, 
				demandFrom,
				demandTo);

	}

}
