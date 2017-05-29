package org.egov.id.api;

import org.egov.id.factory.ResponseInfoFactory;
import org.egov.id.model.IdGenerationRequest;
import org.egov.id.model.IdGenerationResponse;
import org.egov.id.model.IdResponse;
import org.egov.id.service.IdGenerationService;
import org.egov.models.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdGenerationController {

	@Autowired
	IdGenerationService idGenerationService;
	
	@Autowired
	private ResponseInfoFactory responseInfoFactory;

	@RequestMapping(method=RequestMethod.POST, value="id/_create")
	public IdGenerationResponse generateIdResponse(@RequestBody IdGenerationRequest idGenReq){
		
		RequestInfo requestInfo = idGenReq.getRequestInfo();
		IdGenerationResponse idGenerationResponse = new IdGenerationResponse();
		IdResponse idResponse = new IdResponse();
		
		String generatedId = idGenerationService.generateId(idGenReq);
		idResponse.setId(generatedId);
		idGenerationResponse.setIdResponse(idResponse);
		idGenerationResponse.setResponseInfo(responseInfoFactory.createResponseInfoFromRequestInfo(requestInfo, true));
		
		return idGenerationResponse;
	}

}
