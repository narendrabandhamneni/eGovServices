package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <h1>Boundary</h1>
 * @author S Anilkumar
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentType {

	private Integer id;

	private String	name;	

	private String	application;	

}
