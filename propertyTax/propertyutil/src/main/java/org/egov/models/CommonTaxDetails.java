package org.egov.models;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonTaxDetails {

	@NotNull
	private String occupancyDate;
	
	@NotNull
	private String	effectiveDate;	
	
	private Double	depreciation;	
	
	private Double	rebateValue;
	
	@NotNull
	private Double	calculatedARV;	
	
	private Double	manualARV;	
	
	private Double	residentialARV;
	
	private Double	nonResidentialARV;	
	
	@NotNull
	private Double	totalTax;	
		
	private List<HeadWiseTax>	headWiseTaxes;	

	
}
