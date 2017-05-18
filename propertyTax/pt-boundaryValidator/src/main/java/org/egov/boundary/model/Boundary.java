package org.egov.boundary.model;

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
public class Boundary {
	
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
	
	private String materializedPath;
	
	private BoundaryType  boundaryType;
	
}
