package org.egov.id.api;

import java.util.ArrayList;
import java.util.List;

import org.egov.id.util.IdGenerationService;
import org.egov.models.IdGenerationRequest;
import org.egov.models.IdGenerationResponse;
import org.egov.models.IdRequest;
import org.egov.models.IdResponse;
import org.egov.models.RequestInfo;
import org.egov.models.ResponseInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * api's related to the IdGeneration Controller
 * @author Pavan Kumar Kamma
 */
@RestController
@RequestMapping(path = "/id/")
public class IdGenerationController {

	@Autowired
	IdGenerationService idGenerationService;

	@Autowired
	private ResponseInfoFactory responseInfoFactory;

	/**
	 * description: generate unique ID for property
	 * @param IdGenerationRequest
	 * @return IdGenerationResponse
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, path = "_genearate")
	public IdGenerationResponse generateIdResponse(@RequestBody IdGenerationRequest idGenerationRequest) throws Exception {

		RequestInfo requestInfo = idGenerationRequest.getRequestInfo();
		List<IdRequest> idRequests = idGenerationRequest.getIdRequests();
		List<IdResponse> idResponses = new ArrayList<>();
		IdGenerationResponse idGenerationResponse = new IdGenerationResponse();
		for(IdRequest idRequest: idRequests){
			String generatedId = "";
			if(idRequest.getFormat()!=null && !idRequest.getFormat().isEmpty()){
				generatedId = idGenerationService.getFormattedId(idRequest);
			} else {
				generatedId = idGenerationService.getGeneratedId(idRequest);
			}
			IdResponse idResponse = new IdResponse();
			idResponse.setId(generatedId);
			idResponses.add(idResponse);
			idGenerationResponse.setIdResponses(idResponses);
		}
		idGenerationResponse.setResponseInfo(responseInfoFactory.createResponseInfoFromRequestInfo(requestInfo, true));

		return idGenerationResponse;
	}

}
