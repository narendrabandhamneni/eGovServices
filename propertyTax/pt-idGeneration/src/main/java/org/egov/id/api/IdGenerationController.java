package org.egov.id.api;

import org.egov.id.model.IdGenerationRequest;
import org.egov.id.model.IdGenerationResponse;
import org.egov.id.service.IdGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdGenerationController {

	@Autowired
	IdGenerationService idGenerationService;

	@RequestMapping(method=RequestMethod.POST, value="id/_create")
	public IdGenerationResponse generateId(@RequestBody IdGenerationRequest idGenReq){

		return idGenerationService.generateId(idGenReq);

	}

}
