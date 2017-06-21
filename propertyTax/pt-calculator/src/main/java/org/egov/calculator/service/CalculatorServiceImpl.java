package org.egov.calculator.service;

import org.egov.models.CalculationFactorRequest;
import org.egov.models.CalculationFactorResponse;
import org.egov.models.CalculationRequest;
import org.egov.models.CalculationResponse;
import org.egov.models.GuidanceValueRequest;
import org.egov.models.GuidanceValueResponse;
import org.egov.models.TaxRatesRequest;
import org.egov.models.TaxRatesResponse;
import org.kie.api.runtime.KieSession;
import org.egov.models.TaxPeriodRequest;
import org.egov.models.TaxPeriodResponse;
import org.egov.models.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description : CalculatorService interface implementation class
 * 
 * @author Pavan Kumar Kamma
 *
 */

@Service
public class CalculatorServiceImpl implements CalculatorService {
	
	@Autowired
	private KieSession kieSession;
	
	@Autowired
	private KieSession kieSession1;
	
	@Autowired
	private KieSession kieSession2;

	@Override
	public CalculationFactorResponse createFactor(String tenantId, CalculationFactorRequest calculationFactorRequest)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalculationFactorResponse updateFactor(String tenantId, CalculationFactorRequest calculationFactorRequest)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalculationFactorResponse getFactor(RequestInfo requestInfo, String tenantId, String factorType,
			String validDate, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuidanceValueResponse createGuidanceValue(String tenantId, GuidanceValueRequest guidanceValueRequest)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuidanceValueResponse updateGuidanceValue(String tenantId, GuidanceValueRequest guidanceValueRequest)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuidanceValueResponse getGuidanceValue(RequestInfo requestInfo, String tenantId, String boundary,
			String structure, String usage, String subUsage, String occupancy, String validDate, String code)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxRatesResponse createTaxRate(String tenantId, TaxRatesRequest taxRatesRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public TaxRatesResponse updateTaxRate(String tenantId, TaxRatesRequest taxRatesRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public TaxRatesResponse getTaxRate(RequestInfo requestInfo, String tenantId, String taxHead, String validDate,
			String parentTaxHead) throws Exception {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public TaxPeriodResponse createTaxPeriod(String tenantId, TaxPeriodRequest taxPeriodRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public TaxPeriodResponse updateTaxPeriod(String tenantId, TaxPeriodRequest taxPeriodRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public TaxPeriodResponse getTaxPeriod(RequestInfo requestInfo, String tenantId, String validDate, String code)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */

	@Override
	public CalculationResponse calculatePropertyTax(CalculationRequest calculationRequest) {
		// TODO Auto-generated method stub
		return new CalculationResponse();
	};

}
