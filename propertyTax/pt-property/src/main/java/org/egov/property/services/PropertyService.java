package org.egov.property.services;

import java.sql.SQLException;
import java.util.List;

import org.egov.models.Address;
import org.egov.models.Floor;
import org.egov.models.Property;
import org.egov.models.PropertyBoundary;
import org.egov.models.PropertyDetail;
import org.egov.models.PropertyRequest;
import org.egov.models.VacantLandProperty;
import org.egov.property.propertyConsumer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropertyService {

	@Autowired

	private Environment env;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	Producer producer;


	public void sendPropertyToKafka(PropertyRequest propertyRequest) {
		producer.send(env.getProperty("validate.user"),propertyRequest);
	}

	@Transactional
	public void addProperty(List<Property> properties) throws SQLException {

		PropertyBoundary boundary = properties.get(0).getBoundary();


		Object[] boundaryArgs = { boundary.getTenantId(), boundary.getLongitude(), boundary.getLatitude(),boundary.getRevenueZone(), boundary.getRevenueWard(), boundary.getRevenueBlock(), boundary.getArea(),boundary.getLocality(), boundary.getStreet(), boundary.getAdminWard(), boundary.getNorthBoundedBy(),boundary.getEastBoundedBy(), boundary.getWestBoundedBy(), boundary.getSouthBoundedBy(),boundary.getCreatedBy(), boundary.getCreatedDate(), boundary.getLastModifiedBy(),boundary.getLastModifiedDate() };

		String boundarySql = "insert into egpt_boundary(tenantId,longitude,latitude,revenueZone,revenueWard,"
				+ "revenueBlock,area,locality,street,"
				+ "adminWard,northBoundedBy,eastBoundedBy,westBoundedBy,southBoundedBy,createdBy,"
				+ "createdDate,lastModifiedBy,lastModifiedDate)"
				+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		executeUpdateSQL(boundarySql, boundaryArgs);

	}

	public void executeUpdateSQL(String sql, Object[] args) throws SQLException {

		jdbcTemplate.update(sql, args);

	}


}
