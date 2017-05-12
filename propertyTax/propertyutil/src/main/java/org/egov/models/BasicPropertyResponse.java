package org.egov.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BasicPropertyResponse {
	private ResponseInfo responseInfo;
	private List<BasicProperty> basicProperties;
	private BasicProperty basicProperty;
	private Object page;
	
	
	

}
