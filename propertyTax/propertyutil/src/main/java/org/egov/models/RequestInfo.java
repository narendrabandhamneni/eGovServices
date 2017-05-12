package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestInfo {
	@NonNull
	private String apiId;

	@NonNull
	private String ver;
	@NonNull
	private String ts;
	private String action;
	private String did;
	private String key;
	private String msgId;
	private String requesterId;
	private String authToken;
	
	

}
