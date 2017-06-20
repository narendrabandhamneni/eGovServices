package org.egov.id.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.egov.id.PtIdGenerationApplication;
import org.egov.id.api.IdGenerationController;
import org.egov.id.model.IdGenerationRequest;
import org.egov.id.model.IdGenerationResponse;
import org.egov.id.model.IdResponse;
import org.egov.id.model.ResponseInfo;
import org.egov.id.service.IdGenerationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(IdGenerationController.class)
@ContextConfiguration(classes = {PtIdGenerationApplication.class})
public class IdGenerationControllerTest {

	@MockBean
	private IdGenerationService idGenerationService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testShouldGenerateId() {

		List<IdResponse> idResponses = new ArrayList<>();
		IdResponse idResponse = new IdResponse();
		idResponse.setId("AP-PT-2017/06/20-000011-13");

		IdGenerationResponse idGenerationResponse = new IdGenerationResponse();
		idResponses.add(idResponse);

		idGenerationResponse.setResponseInfo(new ResponseInfo());
		idGenerationResponse.setIdResponses(idResponses);

		try {
			when(idGenerationService
					.generateIdResponse(any(IdGenerationRequest.class)))
							.thenReturn(idGenerationResponse);

			mockMvc.perform(post("/id/_genearate")
					.contentType(MediaType.APPLICATION_JSON)
					.content(getFileContents("idGenerationRequest.json")))
					.andExpect(status().isOk())
					.andExpect(content().contentTypeCompatibleWith(
							MediaType.APPLICATION_JSON))
					.andExpect(content().json(
							getFileContents("idGenerationResponse.json")));

		} catch (Exception e) {

			assertTrue(Boolean.FALSE);
		}

		assertTrue(Boolean.TRUE);
	}

	private String getFileContents(String fileName) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		return new String(Files.readAllBytes(
				new File(classLoader.getResource(fileName).getFile())
						.toPath()));
	}
}
