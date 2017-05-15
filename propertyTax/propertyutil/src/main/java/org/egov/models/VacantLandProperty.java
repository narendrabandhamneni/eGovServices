package org.egov.models ;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * VacantLandProperty
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VacantLandProperty   {

	private String id ;


	private String surveyNumber ;


	private String pattaNumber ;


	private Double marketValue ;


	private Double capitalValue ;

	private String layoutApprovedAuth ;

	private String layoutPermissionNo ;


	private LocalDate layoutPermissionDate ;

	private Double resdPlotArea ;

	private Double nonResdPlotArea ;


	private String createdBy ;


	private LocalDate createdDate ;


	private String lastModifiedBy ;

	private LocalDate lastModifiedDate ;

	@NonNull
	private String tenantId ;


}

