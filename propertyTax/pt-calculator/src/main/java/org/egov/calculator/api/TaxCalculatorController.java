package org.egov.calculator.api;

import org.egov.models.CalculationFactorResponse;
import org.springframework.web.bind.annotation.RequestMapping;

public class TaxCalculatorController {

	@RequestMapping(path="/factor/_create")
	public CalculationFactorResponse createFactor()
	{
		return null;
		
	}
	
}
