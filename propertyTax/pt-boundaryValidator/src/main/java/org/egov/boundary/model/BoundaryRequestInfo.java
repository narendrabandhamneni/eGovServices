package org.egov.boundary.model;

import org.egov.models.RequestInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuppressWarnings("unused")
public class BoundaryRequestInfo {
	
	private String tenantId;
	
	private RequestInfo requestInfo;
	
	private Boundary boundary;
}
