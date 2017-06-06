package org.egov.propertyWorkflow.models;

import java.util.List;

import org.egov.models.ResponseInfo;
import org.egov.models.WorkFlowDetails;

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

	private List<WorkFlowDetails> WorkflowDetails;

}
