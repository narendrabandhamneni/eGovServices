package org.egov.propertyWorkflow.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Position   {
	
  private Long id;
  private String name;
  private DepartmentDesignation deptdesig;
  private Boolean isPostOutsourced;
  private Boolean active;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public DepartmentDesignation getDeptdesig() {
	return deptdesig;
}
public void setDeptdesig(DepartmentDesignation deptdesig) {
	this.deptdesig = deptdesig;
}
public Boolean getIsPostOutsourced() {
	return isPostOutsourced;
}
public void setIsPostOutsourced(Boolean isPostOutsourced) {
	this.isPostOutsourced = isPostOutsourced;
}
public Boolean getActive() {
	return active;
}
public void setActive(Boolean active) {
	this.active = active;
}
  
  
}

