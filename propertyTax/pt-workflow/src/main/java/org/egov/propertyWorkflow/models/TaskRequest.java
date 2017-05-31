package org.egov.propertyWorkflow.models;

import org.egov.models.RequestInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TaskRequest   {
  private RequestInfo requestInfo;
  private Task task;
}