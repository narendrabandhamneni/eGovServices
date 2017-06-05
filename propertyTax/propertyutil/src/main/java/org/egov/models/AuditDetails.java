package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * <h1>AuditDetails</h1>
 * common class for create author and data
 * @author S Anilkumar
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDetails {

	private String createdBy;

	private String createdDate;

	private String lastModifiedBy;

	private String lastModifiedDate;
}
