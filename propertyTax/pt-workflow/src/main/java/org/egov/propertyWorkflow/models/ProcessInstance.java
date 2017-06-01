package org.egov.propertyWorkflow.models;

import java.util.Date;
import java.util.List;

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
public class ProcessInstance   {
	
	private String id;
	private String businessKey;
	private String type;
	private Position assignee = null;
	private String comments;
	private Date createdDate;
	private Date lastupdatedSince;
	private Position owner = null;
	private String state;
	private String status;
	private String senderName;
	private String details;
	List<Task> tasks;
	private String tenantId;
	private Long initiatorPosition;
  }
