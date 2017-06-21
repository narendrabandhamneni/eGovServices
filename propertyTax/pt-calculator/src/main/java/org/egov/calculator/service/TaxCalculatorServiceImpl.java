package org.egov.calculator.service;

import java.util.Date;
import java.util.List;

import org.egov.calculator.exception.InvalidInputException;
import org.egov.calculator.repository.TaxCalculatorRepository;
import org.egov.models.CalculationFactor;
import org.egov.models.CalculationFactorRequest;
import org.egov.models.CalculationFactorResponse;
import org.egov.models.CalculationRequest;
import org.egov.models.CalculationResponse;
import org.egov.models.GuidanceValueRequest;
import org.egov.models.GuidanceValueResponse;
import org.egov.models.RequestInfo;
import org.egov.models.ResponseInfo;
import org.egov.models.ResponseInfoFactory;
import org.egov.models.TaxPeriodRequest;
import org.egov.models.TaxPeriodResponse;
import org.egov.models.TaxRatesRequest;
import org.egov.models.TaxRatesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description : CalculatorService interface implementation class
 * 
 * @author Pavan Kumar Kamma
 *
 */

@Service
public class TaxCalculatorServiceImpl implements TaxCalculatorService {

	@Autowired
	TaxCalculatorRepository taxCalculatorRepository;

	@Autowired
	ResponseInfoFactory responseInfoFactory;

	@Override
	@Transactional
	public CalculationFactorResponse createFactor(String tenantId,
			CalculationFactorRequest calculationFactorRequest) {

		for (CalculationFactor calculationFactor : calculationFactorRequest
				.getCalculationFactors()) {

			try {

				Long id = taxCalculatorRepository.createFactor(tenantId,
						calculationFactor);
				calculationFactor.setId(id);

			} catch (Exception e) {

				throw new InvalidInputException(
						calculationFactorRequest.getRequestInfo());

			}
		}

		CalculationFactorResponse calculationFactorResponse = new CalculationFactorResponse();

		ResponseInfo responseInfo = responseInfoFactory
				.createResponseInfoFromRequestInfo(
						calculationFactorRequest.getRequestInfo(), true);
		calculationFactorResponse.setCalculationFactors(
				calculationFactorRequest.getCalculationFactors());
		calculationFactorResponse.setResponseInfo(responseInfo);

		return calculationFactorResponse;
	}

	@Override
	@Transactional
	public CalculationFactorResponse updateFactor(String tenantId,
			CalculationFactorRequest calculationFactorRequest) {

		for (CalculationFactor calculationFactor : calculationFactorRequest
				.getCalculationFactors()) {

			try {

				long updatedTime = new Date().getTime();
				long id = calculationFactor.getId();
				calculationFactor.getAuditDetails()
						.setLastModifiedTime(updatedTime);
				taxCalculatorRepository.updateFactor(tenantId, id,
						calculationFactor);

			} catch (Exception e) {

				throw new InvalidInputException(
						calculationFactorRequest.getRequestInfo());

			}
		}

		CalculationFactorResponse calculationFactorResponse = new CalculationFactorResponse();

		ResponseInfo responseInfo = responseInfoFactory
				.createResponseInfoFromRequestInfo(
						calculationFactorRequest.getRequestInfo(), true);
		calculationFactorResponse.setCalculationFactors(
				calculationFactorRequest.getCalculationFactors());
		calculationFactorResponse.setResponseInfo(responseInfo);

		return calculationFactorResponse;
	}

	@Override
	public CalculationFactorResponse getFactor(RequestInfo requestInfo,
			String tenantId, String factorType, String validDate, String code) {

		CalculationFactorResponse calculationFactorResponse = new CalculationFactorResponse();

		try {

			List<CalculationFactor> calculationFactors = taxCalculatorRepository
					.searchFactor(tenantId, factorType, validDate, code);
			ResponseInfo responseInfo = responseInfoFactory
					.createResponseInfoFromRequestInfo(requestInfo, true);

			calculationFactorResponse.setCalculationFactors(calculationFactors);
			calculationFactorResponse.setResponseInfo(responseInfo);
		} catch (Exception e) {
			throw new InvalidInputException(requestInfo);
		}
		return calculationFactorResponse;
	}

	@Override
	public GuidanceValueResponse createGuidanceValue(String tenantId,
			GuidanceValueRequest guidanceValueRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuidanceValueResponse updateGuidanceValue(String tenantId,
			GuidanceValueRequest guidanceValueRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GuidanceValueResponse getGuidanceValue(RequestInfo requestInfo,
			String tenantId, String boundary, String structure, String usage,
			String subUsage, String occupancy, String validDate, String code)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxRatesResponse createTaxRate(String tenantId,
			TaxRatesRequest taxRatesRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public TaxRatesResponse updateTaxRate(String tenantId,
			TaxRatesRequest taxRatesRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public TaxRatesResponse getTaxRate(RequestInfo requestInfo, String tenantId,
			String taxHead, String validDate, String parentTaxHead)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public TaxPeriodResponse createTaxPeriod(String tenantId,
			TaxPeriodRequest taxPeriodRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public TaxPeriodResponse updateTaxPeriod(String tenantId,
			TaxPeriodRequest taxPeriodRequest) throws Exception {
		// TODO Auto-generated method stub
		return null;
	};

	@Override
	public TaxPeriodResponse getTaxPeriod(RequestInfo requestInfo,
			String tenantId, String validDate, String code) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */

	@Override
	public CalculationResponse calculatePropertyTax(
			CalculationRequest calculationRequest) {
		// TODO Auto-generated method stub
		return new CalculationResponse();
	};

}
