package org.egov.id.service;

import java.time.LocalDateTime;
import java.util.Random;

import org.egov.id.model.IdGenerationRequest;
import org.egov.id.model.IdGenerationResponse;
import org.egov.id.model.IdResponse;
import org.egov.models.RequestInfo;
import org.egov.models.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class IdGenerationService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public IdGenerationResponse generateId(IdGenerationRequest idGenReq){
		
		RequestInfo requestInfo = idGenReq.getRequestInfo();
		IdGenerationResponse idGenRes = new IdGenerationResponse();
		ResponseInfo responseInfo = new ResponseInfo();
		IdResponse idResponse = new IdResponse();
		
		//String ackNumberSeq = "seq_eglams_acknowledgementnumber";
		//String sql = "SELECT nextval('" + ackNumberSeq + "')";

		LocalDateTime localDateTime = LocalDateTime.now();
		Integer year = localDateTime.getYear();
		
		Random random = new Random();
		int k=random.nextInt(25)+65;
		int l = random.nextInt(25)+65;
		String suffix = Character.toString((char) k)+(char)l;
		Long resultSet = null;
		try{
			//replace it with a generic agreement repository which will take query, input object,response object
			//resultSet = jdbcTemplate.queryForObject(sql, Long.class);
			resultSet = 0000012345L;
		}catch (Exception e) {
			throw e;
		}
		StringBuilder baseValue = new StringBuilder(String.format("%05d", resultSet));
		baseValue.append("-" + year);
		baseValue.append("-"+suffix);
		
		responseInfo.setApiId(requestInfo.getApiId());
		responseInfo.setMsgId(requestInfo.getMsgId());
		responseInfo.setResMsgId(null);
		responseInfo.setStatus("201");
		responseInfo.setTs(requestInfo.getTs());
		responseInfo.setVer(requestInfo.getVer());
		idGenRes.setResponseInfo(responseInfo);
		idResponse.setId(baseValue.toString().toUpperCase());
		idGenRes.setIdResponse(idResponse);
		
		return idGenRes;
	}
}
