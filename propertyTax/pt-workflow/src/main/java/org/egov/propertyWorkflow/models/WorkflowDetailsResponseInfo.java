package org.egov.propertyWorkflow.models;

import java.util.List;

import org.egov.models.ResponseInfo;
import org.egov.models.WorkflowDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class WorkflowDetailsResponseInfo {

	private ResponseInfo ResponseInfo;

	private List<WorkflowDetails> WorkflowDetails;

	public ResponseInfo getResponseInfo() {
		return ResponseInfo;
	}

	public void setResponseInfo(ResponseInfo responseInfo) {
		ResponseInfo = responseInfo;
	}

	public List<WorkflowDetails> getWorkflowDetails() {
		return WorkflowDetails;
	}

	public void setWorkflowDetails(List<WorkflowDetails> workflowDetails) {
		WorkflowDetails = workflowDetails;
	}
	
	
}
