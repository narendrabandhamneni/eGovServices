package org.egov.propertyWorkflow.models;

import org.egov.models.RequestInfo;
import org.egov.models.WorkflowDetails;

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

public class WorkflowDetailsRequestInfo {

	private String tenantId;

	private RequestInfo requestInfo;

	private WorkflowDetails workflowDetails;

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public RequestInfo getRequestInfo() {
		return requestInfo;
	}

	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}

	public WorkflowDetails getWorkflowDetails() {
		return workflowDetails;
	}

	public void setWorkflowDetails(WorkflowDetails workflowDetails) {
		this.workflowDetails = workflowDetails;
	}
	
	
}
