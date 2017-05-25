package org.egov.id.service;

import java.util.Random;

import org.egov.id.model.IdGenerationRequest;
import org.egov.id.model.IdGenerationResponse;
import org.springframework.stereotype.Service;

@Service
public class IdGenerationService {
	public IdGenerationResponse generateId(IdGenerationRequest idGenReq){
		Random random = new Random();
		return new IdGenerationResponse();
	}
}
