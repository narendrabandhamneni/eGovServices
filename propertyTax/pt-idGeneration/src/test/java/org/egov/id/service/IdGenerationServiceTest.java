package org.egov.id.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.egov.id.PtIdGenerationApplication;
import org.egov.models.IdGenerationRequest;
import org.egov.models.IdGenerationResponse;
import org.egov.models.IdRequest;
import org.egov.models.RequestInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {PtIdGenerationApplication.class})
public class IdGenerationServiceTest {

	@Autowired
	IdGenerationService idGenerationService;

	@Test
	public void generateId() {

		List<IdRequest> idRequests = new ArrayList<>();
		IdRequest idRequest = new IdRequest();
		idRequest.setFormat("AP-PT-[yyyy/MM/dd]-[SEQ_ACK_NUM]-[d{2}]");
		idRequest.setIdName("propertytax.acknumber");
		idRequest.setTenantId("ap.propertytax.acknumber");
		idRequests.add(idRequest);

		RequestInfo requestInfo = getRequestInfoObject();
		IdGenerationRequest idGenerationRequest = new IdGenerationRequest();
		idGenerationRequest.setIdRequests(idRequests);
		idGenerationRequest.setRequestInfo(requestInfo);
		try {
			IdGenerationResponse idGenerationResponse = idGenerationService
					.generateIdResponse(idGenerationRequest);
			if (idGenerationResponse.getIdResponses().size() == 0)
				assertTrue(false);

			assertTrue(true);

		} catch (Exception e) {
			assertTrue(false);
		}
	}

	private RequestInfo getRequestInfoObject() {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setApiId("emp");
		requestInfo.setVer("1.0");
		requestInfo.setTs(new Long(122366));
		requestInfo.setDid("1");
		requestInfo.setKey("abcdkey");
		requestInfo.setMsgId("20170310130900");
		requestInfo.setRequesterId("rajesh");
		requestInfo.setAuthToken("b5da31a4-b400-4d6e-aa46-9ebf33cce933");

		return requestInfo;
	}

}
