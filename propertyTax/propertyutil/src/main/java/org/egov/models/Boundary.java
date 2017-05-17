package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Boundary
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Boundary   {
 
  private String id;
  
  private String name;
  
  private String boundaryNum;
  
  private String fromDate;
  
  private String toDate;
  
  private String isHistory;
  
  private String bndryId;
  
  private String localName;
  
  private String longitude;
  
  private String latitude;
  
  private BoundaryType  boundaryType;
  
  private String materializedPath;
  
}

