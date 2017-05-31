package org.egov.propertyWorkflow.models;

import java.util.List;

import org.egov.models.RequestInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProcessInstanceRequest {
	
	
	private RequestInfo requestInfo;

	
	private List<ProcessInstance> processInstances;

	
	private ProcessInstance processInstance;
}
