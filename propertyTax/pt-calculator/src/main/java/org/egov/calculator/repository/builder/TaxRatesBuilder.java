package org.egov.calculator.repository.builder;

public class TaxRatesBuilder {
	public static final String INSERT_TAXRATES_QUERY = "INSERT INTO egpt_mstr_taxrates"
			+ " (tenantid, taxHead, dependentTaxHead, fromdate, todate,"
			+ " fromValue, toValue, ratePercentage, taxFlatValue, createdby,"
			+ " lastmodifiedby, createdtime, lastmodifiedtime)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String UPDATE_TAXRATES_QUERY = "UPDATE egpt_mstr_taxrates"
			+ " SET tenantid = ?, taxHead = ?, dependentTaxHead = ?, fromdate = ?,"
			+ " todate = ?, fromValue = ?, toValue = ?, ratePercentage = ?,"
			+ " taxFlatValue = ?, lastmodifiedby = ?, lastmodifiedtime = ?"
			+ " WHERE id = ?";

	public static String getTaxRatesSearchQuery(String tenantId, String taxHead, 
			String validDate, Double validARVAmount, String parentTaxHead) {

		String selectQuery = "SELECT * FROM egpt_mstr_taxrates "
				+ " WHERE tenantId = '" + tenantId + "'"
				+ " AND taxHead = '" + taxHead + "'"
				+ " AND '" + validDate + "' BETWEEN fromdate AND  todate"
				+ " AND " + validARVAmount + " BETWEEN fromValue AND toValue"
				+ " OR dependentTaxHead = '" + parentTaxHead + "'";
		
		return selectQuery;
	}
}
