package org.egov.propertyWorkflow.consumer;
import java.util.HashMap;
import java.util.Map;

import org.egov.models.RequestInfo;
import org.egov.models.WorkFlowDetails;
import org.egov.propertyWorkflow.models.Position;
import org.egov.propertyWorkflow.models.ProcessInstance;
import org.egov.propertyWorkflow.models.ProcessInstanceRequest;
import org.egov.propertyWorkflow.models.ProcessInstanceResponse;
import org.egov.propertyWorkflow.models.Task;
import org.egov.propertyWorkflow.models.TaskRequest;
import org.egov.propertyWorkflow.models.TaskResponse;
import org.egov.propertyWorkflow.models.WorkflowDetailsRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class WorkFlowUtil {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	Environment environment;

	public ProcessInstance startWorkflow(WorkflowDetailsRequestInfo workflowDetailsRequestInfo) {

		ProcessInstanceRequest processInstanceRequest = getProcessInstanceRequest(workflowDetailsRequestInfo);

		String url = environment.getProperty("workFlow.startUrl")+"?tenantId="+workflowDetailsRequestInfo.getTenantId();
		
		Map<String,Object> processRequest=new HashMap<String,Object>();
		processRequest.put("processInstanceRequest", processInstanceRequest);

		ProcessInstanceResponse processInstanceRes = null;
		try{
			processInstanceRes = restTemplate.postForObject(url, processRequest, ProcessInstanceResponse.class);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		

		return processInstanceRes.getProcessInstance();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TaskResponse updateWorkflow(WorkflowDetailsRequestInfo workflowDetailsRequestInfo) throws JsonProcessingException {

		TaskRequest taskRequest = getTaskRequest(workflowDetailsRequestInfo);
		WorkFlowDetails workflowDetails=workflowDetailsRequestInfo.getWorkflowDetails();
		String url = environment.getProperty("workflow.updateUrl");

		// URI parameters
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("id", workflowDetails.getAction());

		// Query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
								.queryParam("tenantId", workflowDetailsRequestInfo.getTenantId());
		MultiValueMap taskRequestMap = new LinkedMultiValueMap();
		taskRequestMap.put("taskRequest",taskRequest);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<MultiValueMap> requestEntity= 
				new HttpEntity<MultiValueMap>(taskRequestMap,headers);

		ResponseEntity<TaskResponse> responseEntity =	restTemplate.exchange(builder.buildAndExpand(uriParams).toUri() , HttpMethod.POST,
				requestEntity, TaskResponse.class);


		return responseEntity.getBody();
	}

	private ProcessInstanceRequest getProcessInstanceRequest(WorkflowDetailsRequestInfo workflowDetailsRequest) {

		WorkFlowDetails workflowDetails = workflowDetailsRequest.getWorkflowDetails();
		RequestInfo requestInfo = workflowDetailsRequest.getRequestInfo();
		ProcessInstanceRequest processInstanceRequest = new ProcessInstanceRequest();
		ProcessInstance processInstance = new ProcessInstance();
		Position assignee=new Position();
		assignee.setId((long)workflowDetails.getAssignee());
		processInstance.setBusinessKey(environment.getProperty("businessKey"));
		processInstance.setType(environment.getProperty("businessKey"));
		processInstance.setAssignee(assignee);
		processInstance.setComments(environment.getProperty("create.property.comments"));
		processInstanceRequest.setProcessInstance(processInstance);
		processInstanceRequest.setRequestInfo(requestInfo);

		return processInstanceRequest;
	}

	private TaskRequest getTaskRequest(WorkflowDetailsRequestInfo workflowDetailsRequest) {
		WorkFlowDetails workflowDetails = workflowDetailsRequest.getWorkflowDetails();
		RequestInfo requestInfo = workflowDetailsRequest.getRequestInfo();
		TaskRequest taskRequest = new TaskRequest();
		Task task = new Task();
		Position assignee = new Position();
		taskRequest.setRequestInfo(requestInfo);
		task.setBusinessKey(environment.getProperty("businessKey"));
		task.setType(environment.getProperty("businessKey"));
		//currently workflowId not available in model
		task.setId(workflowDetails.getAction().toString());
		task.setAction(workflowDetails.getAction());
		task.setStatus(workflowDetails.getStatus());
		assignee.setId((long)workflowDetails.getAssignee());
		task.setAssignee(assignee);

		taskRequest.setTask(task);

		return taskRequest;
	}
}
