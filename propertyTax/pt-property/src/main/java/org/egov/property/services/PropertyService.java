package org.egov.property.services;

import java.sql.SQLException;
import java.util.List;

import org.egov.models.Address;
import org.egov.models.Floor;
import org.egov.models.Property;
import org.egov.models.PropertyDetail;
import org.egov.models.PropertyRequest;
import org.egov.models.User;
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
		producer.send(env.getProperty("validate.user"), propertyRequest);
	}

	@SuppressWarnings("unused")
	@Transactional
	public void addProperty(List<Property> properties) throws SQLException {

		try {

			for (Property props : properties) {

				PropertyDetail propertyDetail = props.getPropertydetails();
				if (propertyDetail != null) {

					for (Floor floor : propertyDetail.getFloors()) {

						// floor insertion

						Floor floorObj = props.getPropertydetails().getFloors().get(0);
						// Floor floorObj = (Floor)
						// props.getPropertydetails().getFloors();

						String floorSql = "insert into egpt_floors (tenantId,floorNo,unitNo,type,length,width,builtupArea,"
								+ "assessableArea,bpaBuiltupArea,category,usage,occupancy,"
								+ "structure,depreciation,occupierName,firmName,rentCollected,exemptionReason,"
								+ "isStructured,occupancyDate,constCompletionDate,bpaNo,bpaDate,manualArv,"
								+ "arv,electricMeterNo,waterMeterNo,createdBy,createdDate,lastModifiedBy,lastModifiedDate)"
								+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

						Object[] floorArgs = { floorObj.getTenantId(), floorObj.getFloorNo(), floorObj.getUnitNo(),
								floorObj.getType(), floorObj.getLength(), floorObj.getWidth(),
								floorObj.getBuiltupArea(), floorObj.getAssessableArea(), floorObj.getBpaBuiltupArea(),
								floorObj.getCategory(), floorObj.getUsage(), floorObj.getOccupancy(),
								floorObj.getStructure(), floorObj.getDepreciation(), floorObj.getOccupierName(),
								floorObj.getFirmName(), floorObj.getRentCollected(), floorObj.getExemptionReason(),
								floorObj.getIsStructured(), floorObj.getOccupancyDate(),
								floorObj.getConstCompletionDate(), floorObj.getBpaNo(), floorObj.getBpaDate(),
								floorObj.getManualArv(), floorObj.getArv(), floorObj.getElectricMeterNo(),
								floorObj.getWaterMeterNo(), floorObj.getCreatedBy(), floorObj.getCreatedDate(),
								floorObj.getLastModifiedBy(), floorObj.getLastModifiedDate() };
						executeUpdateSQL(floorSql, floorArgs);

						// floor next sequence id

						String floorIdQuery = "select nextval('egpt_floors_id_seq')";

						Integer floorId = jdbcTemplate.queryForObject(floorIdQuery, Integer.class);

						// vacantLand insertion

						VacantLandProperty vacantLand = props.getPropertydetails().getVacantLand();

						String vaccantLandSql = "insert into egpt_vacantland(tenantId,surveyNumber,pattaNumber,"
								+ "marketValue,capitalValue,layoutApprovedAuth,layoutPermissionNo,layoutPermissionDate,"
								+ "resdPlotArea,nonResdPlotArea,createdBy,createdDate,lastModifiedBy,lastModifiedDate) "
								+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						Object[] vaccantLandArgs = { vacantLand.getTenantId(), vacantLand.getSurveyNumber(),
								vacantLand.getPattaNumber(), vacantLand.getMarketValue(), vacantLand.getCapitalValue(),
								vacantLand.getLayoutApprovedAuth(), vacantLand.getLayoutPermissionNo(),
								vacantLand.getLayoutPermissionDate(), vacantLand.getResdPlotArea(),
								vacantLand.getNonResdPlotArea(), vacantLand.getCreatedBy(), vacantLand.getCreatedDate(),
								vacantLand.getLastModifiedBy(), vacantLand.getLastModifiedDate() };

						executeUpdateSQL(vaccantLandSql, vaccantLandArgs);

						// vacantLand next sequence id

						String vacantLandIdQuery = "select nextval('egpt_vacantland_id_seq')";

						Integer vacantLandId = jdbcTemplate.queryForObject(vacantLandIdQuery, Integer.class);

						// property details insertion

						PropertyDetail propertyDetails = props.getPropertydetails();

						// extracting current floor id and vacantland id
						Integer fId = floorId - 1;
						Integer vId = vacantLandId - 1;

						String propertyDetailsSql = "INSERT INTO egpt_propertydetail(tenantId, regdDocNo, regdDocDate,"
								+ " occupancyDate, reason, status, isVerified, verificationDate, isExempted, exemptionReason,"
								+ " propertyType, category, usage, department, apartment, length, breadth, sitalArea,"
								+ " totalBuiltupArea, undividedShare, noOfFloors, isSuperStructure, landOwner, floorType,"
								+ " woodType, roofType, wallType, vacantLand, floors) "
								+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						Object[] propertyDetailsArgs = { propertyDetails.getTenantId(), propertyDetails.getRegdDocNo(),
								propertyDetails.getRegdDocDate(), propertyDetails.getOccupancyDate(),
								propertyDetails.getReason(), propertyDetails.getStatus(),
								propertyDetails.getIsVerified(), propertyDetails.getVerificationDate(),
								propertyDetails.getIsExempted(), propertyDetails.getExemptionReason(),
								propertyDetails.getPropertyType(), propertyDetails.getCategory(),
								propertyDetails.getUsage(), propertyDetails.getDepartment(),
								propertyDetails.getApartment(), propertyDetails.getLength(),
								propertyDetails.getBreadth(), propertyDetails.getSitalArea(),
								propertyDetails.getTotalBuiltupArea(), propertyDetails.getUndividedShare(),
								propertyDetails.getNoOfFloors(), propertyDetails.getIsSuperStructure(),
								propertyDetails.getLandOwner(), propertyDetails.getFloorType(),
								propertyDetails.getWoodType(), propertyDetails.getRoofType(),
								propertyDetails.getWallType(), vId, fId };

						executeUpdateSQL(propertyDetailsSql, propertyDetailsArgs);

						// property detail next sequence id

						String propertyDetailsIdQuery = "select nextval('egpt_propertydetail_id_seq')";

						Integer propertyDetailsId = jdbcTemplate.queryForObject(propertyDetailsIdQuery, Integer.class);

						// address insertion
						Address address = props.getAddress();

						String addressSql = "INSERT INTO egpt_Address(tenantId, houseNoBldgApt, streetRoadLine, landmark, "
								+ "areaLocalitySector, cityTownVillage, district, subDistrict, postOffice, state, country, pinCode,"
								+ " type, createdBy, createdDate, lastModifiedBy, lastModifiedDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						Object[] addressArgs = { address.getTenantId(), address.getHouseNoBldgApt(),
								address.getStreetRoadLine(), address.getLandmark(), address.getAreaLocalitySector(),
								address.getCityTownVillage(), address.getDistrict(), address.getSubDistrict(),
								address.getPostOffice(), address.getState(), address.getCountry(), address.getPinCode(),
								address.getType(), address.getCreatedBy(), address.getCreatedDate(),
								address.getLastModifiedBy(), address.getLastModifiedDate() };

						executeUpdateSQL(addressSql, addressArgs);

						// address next sequence id
						String addressIdQuery = "select nextval('egpt_address_id_seq')";

						Integer addressId = jdbcTemplate.queryForObject(addressIdQuery, Integer.class);

						String getBoundaryId = props.getBoundary().getId();

						// current address id and property detail id
						Integer getAddressId = addressId - 1;
						Integer getPropertyDetailId = propertyDetailsId - 1;

						// property insertion

						String propertySql = "INSERT INTO egpt_Property(tenantId, upicNo, oldUpicNo, vltUpicNo,"
								+ " creationReason, address, propertyDetail, assessmentDate, occupancyDate, gisRefNo,"
								+ " isAuthorised, isUnderWorkflow, boundary, channel, createdBy, createdDate, lastModifiedBy, "
								+ "lastModifiedDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

						Object[] propertyArgs = { props.getTenantId(), props.getUpicNo(), props.getOldUpicNo(),
								props.getVltUpicNo(), props.getCreationReason(), getAddressId, getPropertyDetailId,
								props.getAssessmentDate(), props.getOccupancyDate(), props.getGisRefNo(),
								props.getIsAuthorised(), props.getIsUnderWorkflow(), getBoundaryId, props.getChannel(),
								props.getCreatedBy(), props.getCreatedDate(), props.getLastModifiedBy(),
								props.getLastModifiedDate() };

						executeUpdateSQL(propertySql, propertyArgs);

						// property next sequence id

						String propertyIdQuery = "select nextval('egpt_property_id_seq')";

						Integer propertyId = jdbcTemplate.queryForObject(propertyIdQuery, Integer.class);

						// current property id
						Integer getPropertyId = propertyId - 1;

						for (User user : props.getOwners()) {
							String getUserId = user.getId();
							String userPropertySql = "insert into egpt_Property_user(propertyId, userId) values (?,?)";
							Object[] userPropertyArgs = { getPropertyId, getUserId };
							executeUpdateSQL(userPropertySql, userPropertyArgs);

						}

					}

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * insertion common logic
	 * 
	 * @param sql
	 *            - insert query
	 * @param args
	 *            - sending insert query arguments
	 * @throws SQLException
	 */
	public void executeUpdateSQL(String sql, Object[] args) throws SQLException {

		try {

			int i = jdbcTemplate.update(sql, args);

			System.out.println("Test Execution value" + i);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}

}
