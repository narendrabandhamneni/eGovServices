package org.egov.property.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.egov.models.Address;
import org.egov.models.Document;
import org.egov.models.DocumentType;
import org.egov.models.Floor;
import org.egov.models.Property;
import org.egov.models.PropertyDetail;
import org.egov.models.PropertyLocation;
import org.egov.models.User;
import org.egov.models.VacantLandProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class creates a property 
 * @author S Anilkumar
 *
 */
@Service
public class PersisterService {


	@Autowired
	private JdbcTemplate jdbcTemplate;


	/**
	 * 
	 * @param properties
	 * @throws SQLException
	 */
	@Transactional
	public void addProperty(List<Property> properties) throws SQLException {

		createProperty(properties);

	}

	/**
	 * 
	 * @param properties
	 */
	//creating property 
	public void createProperty(List<Property> properties) {

		//iterating property from properties
		for (Property property : properties) {

			// property insertion
			StringBuffer propertySql=new StringBuffer();

			propertySql.append("INSERT INTO egpt_Property(tenantId, upicNo, oldUpicNo, vltUpicNo,")
			.append("creationReason, assessmentDate, occupancyDate, gisRefNo,")
			.append("isAuthorised, isUnderWorkflow, channel, createdBy, createdDate, lastModifiedBy, ")
			.append("lastModifiedDate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


			final PreparedStatementCreator psc = new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
					final PreparedStatement ps = connection.prepareStatement(propertySql.toString(), new String[] { "id" });
					ps.setString(1, property.getTenantId());
					ps.setString(2, property.getUpicNo());
					ps.setString(3, property.getOldUpicNo());
					ps.setString(4, property.getVltUpicNo());
					ps.setString(5, property.getCreationReason());
					ps.setString(6, property.getAssessmentDate());
					ps.setString(7, property.getOccupancyDate());
					ps.setString(8, property.getGisRefNo());
					ps.setBoolean(9, property.getIsAuthorised());
					ps.setBoolean(10, property.getIsUnderWorkflow());
					ps.setString(11, property.getChannel());
					ps.setString(12, property.getAuditDetails().getCreatedBy());
					ps.setString(13, property.getAuditDetails().getCreatedDate());
					ps.setString(14, property.getAuditDetails().getLastModifiedBy());
					ps.setString(15, property.getAuditDetails().getLastModifiedDate());
					return ps;
				}
			};

			// The newly generated key will be saved in this object
			final KeyHolder holder = new GeneratedKeyHolder();

			jdbcTemplate.update(psc, holder);

			Integer propertyId = holder.getKey().intValue();

			//address insertion
			Address address = property.getAddress();

			StringBuffer addressSql=new StringBuffer();

			addressSql.append("INSERT INTO egpt_Address(tenantId, houseNoBldgApt, streetRoadLine, landmark, ")
			.append( "areaLocalitySector, cityTownVillage, district, subDistrict, postOffice, state, country, pinCode,")
			.append(" type, createdBy, createdDate, lastModifiedBy, lastModifiedDate,property_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


			Object[] addressArgs = { address.getTenantId(), address.getHouseNoBldgApt(), address.getStreetRoadLine(),
					address.getLandmark(), address.getAreaLocalitySector(), address.getCityTownVillage(),
					address.getDistrict(), address.getSubDistrict(), address.getPostOffice(), address.getState(),
					address.getCountry(), address.getPinCode(), address.getType(),
					address.getAuditDetails().getCreatedBy(), address.getAuditDetails().getCreatedDate(),
					address.getAuditDetails().getLastModifiedBy(), address.getAuditDetails().getLastModifiedDate(),
					propertyId };

			jdbcTemplate.update(addressSql.toString(), addressArgs);

			//property detail insertion
			PropertyDetail propertyDetails = property.getPropertydetails();

			StringBuffer propertyDetailsSql=new StringBuffer();

			propertyDetailsSql.append("INSERT INTO egpt_propertydetails(tenantId, regdDocNo, regdDocDate,")
			.append("occupancyDate, reason, status, isVerified, verificationDate, isExempted, exemptionReason,")
			.append("propertyType, category, usage, department, apartment, length, breadth, sitalArea,")
			.append(" totalBuiltupArea, undividedShare, noOfFloors, isSuperStructure, landOwner, floorType,")
			.append(" woodType, roofType, wallType,createdBy, createdDate, lastModifiedBy, ")
			.append("lastModifiedDate, property_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");



			final PreparedStatementCreator pscPropertyDetails = new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
					final PreparedStatement ps = connection.prepareStatement(propertyDetailsSql.toString(), new String[] { "id" });
					ps.setString(1, propertyDetails.getTenantId());
					ps.setString(2, propertyDetails.getRegdDocNo());
					ps.setString(3, propertyDetails.getRegdDocDate());
					ps.setString(4, propertyDetails.getOccupancyDate());
					ps.setString(5, propertyDetails.getReason());
					ps.setString(6, propertyDetails.getStatus());
					ps.setBoolean(7, propertyDetails.getIsVerified());
					ps.setString(8, propertyDetails.getVerificationDate());
					ps.setBoolean(9, propertyDetails.getIsExempted());
					ps.setString(10, propertyDetails.getExemptionReason());
					ps.setString(11, propertyDetails.getPropertyType());
					ps.setString(12, propertyDetails.getCategory());
					ps.setString(13, propertyDetails.getUsage());
					ps.setString(14, propertyDetails.getDepartment());
					ps.setString(15, propertyDetails.getApartment());
					ps.setDouble(16, propertyDetails.getLength());
					ps.setDouble(17, propertyDetails.getBreadth());
					ps.setDouble(18, propertyDetails.getSitalArea());
					ps.setDouble(19, propertyDetails.getTotalBuiltupArea());
					ps.setDouble(20, propertyDetails.getUndividedShare());
					ps.setLong(21, propertyDetails.getNoOfFloors());
					ps.setBoolean(22, propertyDetails.getIsSuperStructure());
					ps.setString(23, propertyDetails.getLandOwner());
					ps.setString(24, propertyDetails.getFloorType());
					ps.setString(25, propertyDetails.getWoodType());
					ps.setString(26, propertyDetails.getRoofType());
					ps.setString(27, propertyDetails.getWallType());
					ps.setString(28, propertyDetails.getAuditDetails().getCreatedBy());
					ps.setString(29, propertyDetails.getAuditDetails().getCreatedDate());
					ps.setString(30, propertyDetails.getAuditDetails().getLastModifiedBy());
					ps.setString(31, propertyDetails.getAuditDetails().getLastModifiedDate());
					ps.setInt(32, propertyId);
					return ps;
				}
			};

			// The newly generated key will be saved in this object
			final KeyHolder holderPropertyDetails = new GeneratedKeyHolder();

			jdbcTemplate.update(pscPropertyDetails, holderPropertyDetails);

			Integer propertyDetailsId = holderPropertyDetails.getKey().intValue();

			//iterating floor from property
			for (Floor floor : property.getPropertydetails().getFloors()) {

				//floor insertion
				StringBuffer floorSql=new StringBuffer();
				floorSql.append("insert into egpt_floors (tenantId,floorNo,unitNo,type,length,width,builtupArea,")
				.append("assessableArea,bpaBuiltupArea,category,usage,occupancy,")
				.append("structure,depreciation,occupierName,firmName,rentCollected,exemptionReason,")
				.append("isStructured,occupancyDate,constCompletionDate,bpaNo,bpaDate,manualArv,")
				.append("arv,electricMeterNo,waterMeterNo,createdBy,createdDate,lastModifiedBy,lastModifiedDate,property_details_id)")
				.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


				Object[] floorArgs = { floor.getTenantId(), floor.getFloorNo(), floor.getUnitNo(), floor.getType(),
						floor.getLength(), floor.getWidth(), floor.getBuiltupArea(), floor.getAssessableArea(),
						floor.getBpaBuiltupArea(), floor.getCategory(), floor.getUsage(), floor.getOccupancy(),
						floor.getStructure(), floor.getDepreciation(), floor.getOccupierName(), floor.getFirmName(),
						floor.getRentCollected(), floor.getExemptionReason(), floor.getIsStructured(),
						floor.getOccupancyDate(), floor.getConstCompletionDate(), floor.getBpaNo(), floor.getBpaDate(),
						floor.getManualArv(), floor.getArv(), floor.getElectricMeterNo(), floor.getWaterMeterNo(),
						floor.getAuditDetails().getCreatedBy(), floor.getAuditDetails().getCreatedDate(),
						floor.getAuditDetails().getLastModifiedBy(), floor.getAuditDetails().getLastModifiedDate(),
						propertyDetailsId };

				jdbcTemplate.update(floorSql.toString(), floorArgs);

			}

			//iterating document from property
			for (Document document : property.getPropertydetails().getDocuments()) {

				//document type insertion

				DocumentType documentType = document.getDocumentType();

				String documentTypeSql = "INSERT INTO egpt_documenttype(name,application) values (?,?)";

				final PreparedStatementCreator pscDocumentType = new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
						final PreparedStatement ps = connection.prepareStatement(documentTypeSql,
								new String[] { "id" });
						ps.setString(1, documentType.getName());
						ps.setString(2, documentType.getApplication());
						return ps;
					}
				};

				// The newly generated key will be saved in this object
				final KeyHolder holderDocumentType = new GeneratedKeyHolder();

				jdbcTemplate.update(pscDocumentType, holderDocumentType);

				Integer documentTypeId = holderDocumentType.getKey().intValue();

				// document insertion

				String documentSql = "INSERT INTO  egpt_document(documentType,fileStore,property_details_id) values (?,?,?)";

				Object[] documentArgs = { documentTypeId, document.getFileStore(), propertyDetailsId };

				jdbcTemplate.update(documentSql, documentArgs);

			}

			//vacantland property insertion
			VacantLandProperty vacantLand = property.getPropertydetails().getVacantLand();
			StringBuffer vaccantLandSql=new StringBuffer();
			vaccantLandSql.append("insert into egpt_vacantland(tenantId,surveyNumber,pattaNumber,")
			.append("marketValue,capitalValue,layoutApprovedAuth,layoutPermissionNo,layoutPermissionDate,")
			.append("resdPlotArea,nonResdPlotArea,createdBy,createdDate,lastModifiedBy,lastModifiedDate,property_details_id)")
			.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			Object[] vaccantLandArgs = { vacantLand.getTenantId(), vacantLand.getSurveyNumber(),
					vacantLand.getPattaNumber(), vacantLand.getMarketValue(), vacantLand.getCapitalValue(),
					vacantLand.getLayoutApprovedAuth(), vacantLand.getLayoutPermissionNo(),
					vacantLand.getLayoutPermissionDate(), vacantLand.getResdPlotArea(), vacantLand.getNonResdPlotArea(),
					vacantLand.getAuditDetails().getCreatedBy(), vacantLand.getAuditDetails().getCreatedDate(),
					vacantLand.getAuditDetails().getLastModifiedBy(),
					vacantLand.getAuditDetails().getLastModifiedDate(), propertyDetailsId };

			jdbcTemplate.update(vaccantLandSql.toString(), vaccantLandArgs);

			//boundary insertion
			PropertyLocation boundary = property.getBoundary();
			StringBuffer boundarySql=new StringBuffer();
			boundarySql.append("insert into egpt_propertyboundary(revenueBoundary, locationBoundary,")
			.append(" adminBoundary, northBoundedBy,eastBoundedBy, westBoundedBy,")
			.append("southBoundedBy, property_id) values (?,?,?,?,?,?,?,?);");

			Object[] boundaryArgs = { boundary.getRevenueBoundary(),boundary.getLocationBoundary(),boundary.getAdminBoundary(),
					boundary.getNorthBoundedBy(),boundary.getEastBoundedBy(),boundary.getWestBoundedBy(),
					boundary.getSouthBoundedBy(),propertyId};

			jdbcTemplate.update(boundarySql.toString(), boundaryArgs);


			//property and user relation table insertion
			for (User user : property.getOwners()) {
				StringBuffer userPropertySql = new StringBuffer();
				userPropertySql.append("insert into egpt_Property_user(property_Id, user_Id,isPrimaryOwner,")
				.append("isSecondaryOwner,ownerShipPercentage, ownerType)")
				.append("values (?,?,?,?,?,?);");
				Object[] userPropertyArgs = { propertyId, user.getId(),user.getIsPrimaryOwner(),
						user.getIsSecondaryOwner(),user.getOwnerShipPercentage(),user.getOwnerType() };
				jdbcTemplate.update(userPropertySql.toString(), userPropertyArgs);

			}

		}
	}

}
