package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>Document</h1>
 * @author Narendra
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {

	private Integer id;

	private DocumentType documentType;

	private String fileStore;
}
