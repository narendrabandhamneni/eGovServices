package org.egov.id.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.egov.id.model.Attribute;
import org.egov.id.model.IdGenerationRequest;
import org.egov.id.model.IdGenerationResponse;
import org.egov.id.model.IdRequest;
import org.egov.id.model.IdResponse;
import org.egov.id.model.IdResultSet;
import org.egov.id.model.IdResultSetRowMapper;
import org.egov.models.RequestInfo;
import org.egov.models.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IdGenerationService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean containsAttribute(List<Attribute> attributeList, String key) {
		for (Attribute attribute : attributeList) {
			if (attribute.getKey().equalsIgnoreCase(key)) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public IdGenerationResponse generateId(IdGenerationRequest idGenReq){

		RequestInfo requestInfo = idGenReq.getRequestInfo();
		IdRequest idRequest = idGenReq.getIdRequest();
		List<Attribute> attributes = new ArrayList<Attribute>(idRequest.getAttributes());
		IdGenerationResponse idGenRes = new IdGenerationResponse();
		ResponseInfo responseInfo = new ResponseInfo();
		IdResponse idResponse = new IdResponse();

		//preparing random text
		Random random = new Random();
		int k=random.nextInt(25)+65;
		int l = random.nextInt(25)+65;
		String randomTxt = Character.toString((char) k)+(char)l;

		String sql = "SELECT * FROM adempiere.id_generator WHERE (idtype='" + idRequest.getIdType() + "' and entity='"+ idRequest.getEntity() +"' and tenentid='"+ idRequest.getTenentId() +"')";

		IdResultSet resultSet;
		try {
			resultSet = (IdResultSet)jdbcTemplate.queryForObject(sql, new IdResultSetRowMapper());
		} catch (Exception e) {
			throw e;
		}

		String regex = resultSet.getRegex();
		List<String> matchList = new ArrayList<String>();
		Pattern regExpPattern = Pattern.compile("\\{(.*?)\\}");
		Matcher regexMatcher = regExpPattern.matcher(regex);

		while (regexMatcher.find()) {//Finds Matching Pattern in String
			matchList.add(regexMatcher.group(1));//Fetching Group from String
		}

		for(String str:matchList) {
			if(str.equalsIgnoreCase("RandNo") || str.equalsIgnoreCase("seqNumber")){
				if(str.equalsIgnoreCase("RandNo")){
					regex = regex.replace("{RandNo}", randomTxt);
				} else {
					regex = regex.replace("{seqNumber}", resultSet.getCurrentseqnum());
				}
			} else {
				if(containsAttribute(attributes, str)){
					for(Attribute a:attributes){  
						if(a.getKey().equalsIgnoreCase(str)){
							regex = regex.replace("{"+str+"}", a.getValue());
						} 
					}
				} else {
					//throw the exception for attribute not found
					throw new IllegalStateException("attribute "+ str +" Not found");
				}
			}
		}

		//preparing Responseinfo
		responseInfo.setApiId(requestInfo.getApiId());
		responseInfo.setMsgId(requestInfo.getMsgId());
		responseInfo.setResMsgId(null);
		responseInfo.setStatus("201");
		responseInfo.setTs(requestInfo.getTs());
		responseInfo.setVer(requestInfo.getVer());

		//preparing idGenerationResponse
		idGenRes.setResponseInfo(responseInfo);
		idResponse.setId(regex.toString().toUpperCase());
		idGenRes.setIdResponse(idResponse);

		return idGenRes;
	}
}
