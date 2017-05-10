package org.egov.property.services;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.egov.property.model.MasterModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MasterServiceImpl  implements Masterservice{

	@Value("${jsonFile}")
	private String jsonFile;

	@Override
	public MasterModel GetPropertyTypes(long tenantId, int code) throws Exception {
		ObjectMapper objectMapper=new ObjectMapper();

		@SuppressWarnings("unchecked")
		Map<String,List<MasterModel>>	 jsonData=	objectMapper.readValue(new FileInputStream(jsonFile),Map.class);
		List<MasterModel> propertyTypeList= jsonData.get("propertyType");
		List<MasterModel>  resultPropertyType=	propertyTypeList.stream()                
				.filter(propertyType-> propertyType.getTenantId()==tenantId && propertyType.getCode()==code)     
				.collect(Collectors.toList()); 
		return resultPropertyType.get(0);
	}

}
