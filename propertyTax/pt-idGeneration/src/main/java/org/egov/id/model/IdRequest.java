package org.egov.id.model;

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
public class IdRequest {
	
	private String idType;
	
	private String entity;
	
	private String tenentId;
	
	private List<Attribute> attributes;
	
}
