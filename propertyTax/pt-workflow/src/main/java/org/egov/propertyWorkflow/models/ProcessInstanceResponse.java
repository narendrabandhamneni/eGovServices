package org.egov.propertyWorkflow.models;

import java.util.List;

import org.egov.models.ResponseInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ProcessInstanceResponse   {

	private ResponseInfo responseInfo ;

	private List<ProcessInstance> processInstances ;


	private ProcessInstance processInstance;

}