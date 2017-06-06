package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>WorkflowDetails</h1>
 * @author Narendra
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowDetails {

	private Integer workFlowId;

	private String	department;

	private String  designation;	

	private Integer	 assignee;	

	private String	 action;	

	private String	status;
}
