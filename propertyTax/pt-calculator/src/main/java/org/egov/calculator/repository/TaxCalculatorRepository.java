package org.egov.calculator.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.egov.calculator.repository.builder.FactorQueryBuilder;
import org.egov.calculator.util.TimeStampUtil;
import org.egov.models.CalculationFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * Description : TaxCalculatorRepository class
 * 
 * @author Pavan Kumar Kamma
 *
 */
@Repository
public class TaxCalculatorRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Long createFactor(String tenantId,
			CalculationFactor calculationFactor) {

		Long createdTime = new Date().getTime();
		String factorInsertSql = FactorQueryBuilder.FACTOR_CREATE_QUERY;

		final PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(
					final Connection connection) throws SQLException {
				final PreparedStatement ps = connection
						.prepareStatement(factorInsertSql, new String[]{"id"});

				ps.setString(1, calculationFactor.getTenantId());
				ps.setString(2, calculationFactor.getFactorCode());
				ps.setString(3, calculationFactor.getFactorType());
				ps.setDouble(4, calculationFactor.getFactorValue());
				ps.setTimestamp(5, TimeStampUtil
						.getTimeStamp(calculationFactor.getFromDate()));
				ps.setTimestamp(6, TimeStampUtil
						.getTimeStamp(calculationFactor.getToDate()));
				ps.setString(7,
						calculationFactor.getAuditDetails().getCreatedBy());
				ps.setString(8, calculationFactor.getAuditDetails()
						.getLastModifiedBy());
				ps.setLong(9, createdTime);
				ps.setLong(10, createdTime);
				return ps;
			}
		};

		// The newly generated key will be saved in this object
		final KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc, holder);

		return Long.valueOf(holder.getKey().intValue());

	}

	public void updateFactor(String tenantId, Long id,
			CalculationFactor calculationFactor) {

		String factorInsertSql = FactorQueryBuilder.FACTOR_UPDATE_QUERY;

		final PreparedStatementCreator psc = new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(
					final Connection connection) throws SQLException {
				final PreparedStatement ps = connection
						.prepareStatement(factorInsertSql, new String[]{"id"});

				ps.setString(1, calculationFactor.getTenantId());
				ps.setString(2, calculationFactor.getFactorCode());
				ps.setObject(3, calculationFactor.getFactorType());
				ps.setDouble(4, calculationFactor.getFactorValue());
				ps.setTimestamp(5, TimeStampUtil
						.getTimeStamp(calculationFactor.getFromDate()));
				ps.setTimestamp(6, TimeStampUtil
						.getTimeStamp(calculationFactor.getToDate()));
				ps.setLong(7, calculationFactor.getAuditDetails()
						.getLastModifiedTime());
				ps.setLong(8, calculationFactor.getId());
				return ps;
			}
		};

		// The newly generated key will be saved in this object
		final KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc, holder);
	}

	public List<CalculationFactor> searchFactor(String tenantId,
			String factorType, String validDate, String code) {

		String factorSearchSql = FactorQueryBuilder
				.getFactorSearchQuery(tenantId, factorType, validDate, code);

		List<CalculationFactor> calculationFactors = new ArrayList<CalculationFactor>();

		calculationFactors = jdbcTemplate.query(factorSearchSql.toString(),
				new BeanPropertyRowMapper(CalculationFactor.class));

		return calculationFactors;

	}
}
