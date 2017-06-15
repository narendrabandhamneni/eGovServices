package org.egov.id.api;

import org.egov.id.util.IdGenerationService;
import org.egov.models.IdGenerationRequest;
import org.egov.models.IdGenerationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * api's related to the IdGeneration Controller
 * 
 * @author Pavan Kumar Kamma
 */
@RestController
@RequestMapping(path = "/id/")
public class IdGenerationController {

	@Autowired
	IdGenerationService idGenerationService;

	/**
	 * description: generate unique ID for property
	 * 
	 * @param IdGenerationRequest
	 * @return IdGenerationResponse
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST, path = "_genearate")
	public IdGenerationResponse generateIdResponse(@RequestBody IdGenerationRequest idGenerationRequest)
			throws Exception {

		IdGenerationResponse idGenerationResponse = idGenerationService.generateIdResponse(idGenerationRequest);

		return idGenerationResponse;
	}

}
