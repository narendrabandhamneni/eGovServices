package org.egov.propertyWorkflow.models;

import java.util.List;

import org.egov.models.ResponseInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TaskResponse   {
  @JsonProperty("responseInfo")
  private ResponseInfo responseInfo;

  @JsonProperty("tasks")
  private List<Task> tasks;

  @JsonProperty("task")
  private Task task;

}