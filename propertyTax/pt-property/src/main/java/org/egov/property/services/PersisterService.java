package org.egov.property.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.egov.models.Address;
import org.egov.models.Document;
import org.egov.models.DocumentType;
import org.egov.models.Floor;
import org.egov.models.OwnerInfo;
import org.egov.models.Property;
import org.egov.models.PropertyDetail;
import org.egov.models.PropertyLocation;
import org.egov.models.Unit;
import org.egov.models.User;
import org.egov.models.VacantLandDetail;
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
	 * Description : This method will use for insert property related data in database
	 * @param properties
	 */
	public void createProperty(List<Property> properties) {

		//iterating property from properties
		for (Property property : properties) {

			// property insertion
			StringBuffer propertySql=new StringBuffer();

			propertySql.append("INSERT INTO egpt_Property(tenantId, upicNumber, oldUpicNumber, vltUpicNumber,")
			.append("creationReason, assessmentDate, occupancyDate, gisRefNo,")
			.append("isAuthorised, isUnderWorkflow, channel, createdBy,lastModifiedBy, createdTime ")
			.append("lastModifiedTime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


			final PreparedStatementCreator psc = new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
					final PreparedStatement ps = connection.prepareStatement(propertySql.toString(), new String[] { "id" });
					ps.setString(1, property.getTenantId());
					ps.setString(2, property.getUpicNumber());
					ps.setString(3, property.getOldUpicNumber());
					ps.setString(4, property.getVltUpicNumber());
					ps.setString(5, property.getCreationReason().toString());
					ps.setString(6, property.getAssessmentDate());
					ps.setString(7, property.getOccupancyDate());
					ps.setString(8, property.getGisRefNo());
					ps.setBoolean(9, property.getIsAuthorised());
					ps.setBoolean(10, property.getIsUnderWorkflow());
					ps.setString(11, property.getChannel().toString());
					ps.setString(12, property.getAuditDetails().getCreatedBy());
					ps.setString(13, property.getAuditDetails().getLastModifiedBy());
					ps.setBigDecimal(14, property.getAuditDetails().getCreatedTime());
					ps.setBigDecimal(15, property.getAuditDetails().getLastModifiedTime());
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

			addressSql.append("INSERT INTO egpt_Address(tenantId, latitude, longitude, addressId, ")
			.append( "addressNumber, addressLine1, addressLine2, landmark, city, pincode, detail,")
			.append(" createdBy, lastModifiedBy, createdTime, lastModifiedTime, property_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


			Object[] addressArgs = { address.getTenantId(), address.getLatitude(), address.getLongitude(),
					address.getAddressId(), address.getAddressNumber(), address.getAddressLine1(),
					address.getAddressLine2(), address.getLandmark(), address.getCity(), address.getPincode(),
					address.getDetail(),address.getAuditDetails().getCreatedBy(), address.getAuditDetails().getLastModifiedBy(),
					address.getAuditDetails().getCreatedTime(), address.getAuditDetails().getLastModifiedTime(),
					propertyId };

			jdbcTemplate.update(addressSql.toString(), addressArgs);

			//property detail insertion
			PropertyDetail propertyDetails = property.getPropertyDetail();

			StringBuffer propertyDetailsSql=new StringBuffer();

			propertyDetailsSql.append("INSERT INTO egpt_propertydetails(source, regdDocNo, regdDocDate,")
			.append("reason, status, isVerified, verificationDate, isExempted, exemptionReason,")
			.append("propertyType, category, usage, department, apartment, siteLength, siteBreadth, sitalArea,")
			.append(" totalBuiltupArea, undividedShare, noOfFloors, isSuperStructure, landOwner, floorType,")
			.append(" woodType, roofType, wallType, stateId, applicationNo, createdBy, lastModifiedBy, ")
			.append("createdDate, lastModifiedDate, property_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");



			final PreparedStatementCreator pscPropertyDetails = new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
					final PreparedStatement ps = connection.prepareStatement(propertyDetailsSql.toString(), new String[] { "id" });
					ps.setString(1, propertyDetails.getSource().toString());
					ps.setString(2, propertyDetails.getRegdDocNo());
					ps.setString(3, propertyDetails.getRegdDocDate());
					ps.setString(4, propertyDetails.getReason());
					ps.setString(5, propertyDetails.getStatus().toString());
					ps.setBoolean(6, propertyDetails.getIsVerified());
					ps.setString(7, propertyDetails.getVerificationDate());
					ps.setBoolean(8, propertyDetails.getIsExempted());
					ps.setString(9, propertyDetails.getExemptionReason());
					ps.setString(10, propertyDetails.getPropertyType());
					ps.setString(11, propertyDetails.getCategory());
					ps.setString(12, propertyDetails.getUsage());
					ps.setString(13, propertyDetails.getDepartment());
					ps.setString(14, propertyDetails.getApartment());
					ps.setDouble(15, propertyDetails.getSiteLength());
					ps.setDouble(16, propertyDetails.getSiteBreadth());
					ps.setDouble(17, propertyDetails.getSitalArea());
					ps.setDouble(18, propertyDetails.getTotalBuiltupArea());
					ps.setDouble(19, propertyDetails.getUndividedShare());
					ps.setLong(20, propertyDetails.getNoOfFloors());
					ps.setBoolean(21, propertyDetails.getIsSuperStructure());
					ps.setString(22, propertyDetails.getLandOwner());
					ps.setString(23, propertyDetails.getFloorType());
					ps.setString(24, propertyDetails.getWoodType());
					ps.setString(25, propertyDetails.getRoofType());
					ps.setString(26, propertyDetails.getWallType());
					ps.setString(27, propertyDetails.getStateId());
					ps.setString(28, propertyDetails.getApplicationNo());
					ps.setString(29, propertyDetails.getAuditDetails().getCreatedBy());
					ps.setString(30, propertyDetails.getAuditDetails().getLastModifiedBy());
					ps.setBigDecimal(31, propertyDetails.getAuditDetails().getCreatedTime());					
					ps.setBigDecimal(32, propertyDetails.getAuditDetails().getLastModifiedTime());
					ps.setInt(33, propertyId);
					return ps;
				}
			};

			// The newly generated key will be saved in this object
			final KeyHolder holderPropertyDetails = new GeneratedKeyHolder();

			jdbcTemplate.update(pscPropertyDetails, holderPropertyDetails);

			Integer propertyDetailsId = holderPropertyDetails.getKey().intValue();

			//iterating floor from property
			for (Floor floor : property.getPropertyDetail().getFloors()) {

				//floor insertion
				String floorSql="INSERT INTO egpt_floors(floorNo,createdBy, lastModifiedBy, createdTime, lastModifiedTime, property_details_id) values (?,?)";

				final PreparedStatementCreator pscFloor = new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
						final PreparedStatement ps = connection.prepareStatement(floorSql, new String[] { "id" });
						ps.setString(1, floor.getFloorNo());
						ps.setString(2, floor.getAuditDetails().getCreatedBy());						
						ps.setString(3, floor.getAuditDetails().getLastModifiedBy());
						ps.setBigDecimal(4, floor.getAuditDetails().getCreatedTime());
						ps.setBigDecimal(5, floor.getAuditDetails().getLastModifiedTime());
						ps.setInt(6, propertyDetailsId);
						return ps;
					}
				};

				// The newly generated key will be saved in this object
				final KeyHolder holderFloor = new GeneratedKeyHolder();

				jdbcTemplate.update(pscFloor, holderFloor);

				Integer floorId = holderPropertyDetails.getKey().intValue();

				//unit insertion
				for(Unit unit : floor.getUnits()){

					StringBuffer unitSql=new StringBuffer();

					unitSql.append("INSERT INTO egpt_unit(unitNo,unitType,length,width,builtupArea,assessableArea,")
					.append("bpaBuiltupArea,bpaNo,bpaDate,usage,occupancy,occupierName,firmName,rentCollected, structure, age,")
					.append("exemptionReason, isStructured, occupancyDate, constCompletionDate, manualArv, arv,")
					.append(" electricMeterNo, waterMeterNo, createdBy, lastModifiedBy, createdTime, lastModifiedTime,")
					.append("floor_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");


					Object[] unitArgs = { unit.getUnitNo(), unit.getUnitType(), unit.getLength(), unit.getWidth(),
							unit.getBuiltupArea(), unit.getAssessableArea(), unit.getBpaBuiltupArea(), unit.getBpaNo(),
							unit.getBpaDate(),unit.getUsage(),unit.getOccupancy(),unit.getOccupierName(), unit.getFirmName(),
							unit.getRentCollected(),unit.getStructure(), unit.getAge(), unit.getExemptionReason(),
							unit.getIsStructured(), unit.getOccupancyDate(), unit.getConstCompletionDate(), unit.getManualArv(),
							unit.getAge(), unit.getElectricMeterNo(), unit.getWaterMeterNo(),
							unit.getAuditDetails().getCreatedBy(), unit.getAuditDetails().getLastModifiedBy(),
							unit.getAuditDetails().getCreatedTime(), unit.getAuditDetails().getLastModifiedTime(),
							floorId};

					jdbcTemplate.update(unitSql.toString(), unitArgs);

				}


			}

			//iterating document from property
			for (Document document : property.getPropertyDetail().getDocuments()) {

				//document type insertion

				DocumentType documentType = document.getDocumentType();

				String documentTypeSql = "INSERT INTO egpt_documenttype(name,application,createdBy, lastModifiedBy, createdTime, lastModifiedTime) values (?,?,?,?,?,?)";

				final PreparedStatementCreator pscDocumentType = new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
						final PreparedStatement ps = connection.prepareStatement(documentTypeSql,
								new String[] { "id" });
						ps.setString(1, documentType.getName());
						ps.setString(2, documentType.getApplication().toString());
						ps.setString(3, documentType.getAuditDetails().getCreatedBy());
						ps.setString(4, documentType.getAuditDetails().getLastModifiedBy());
						ps.setBigDecimal(5, documentType.getAuditDetails().getCreatedTime());
						ps.setBigDecimal(6, documentType.getAuditDetails().getLastModifiedTime());
						return ps;
					}
				};

				// The newly generated key will be saved in this object
				final KeyHolder holderDocumentType = new GeneratedKeyHolder();

				jdbcTemplate.update(pscDocumentType, holderDocumentType);

				Integer documentTypeId = holderDocumentType.getKey().intValue();

				// document insertion

				String documentSql = "INSERT INTO  egpt_document(documentType,fileStore, createdBy, lastModifiedBy, createdTime, lastModifiedTime, property_details_id) values (?,?,?,?,?,?,?)";

				Object[] documentArgs = { documentTypeId, document.getFileStore(),
						document.getAuditDetails().getCreatedBy(),
						document.getAuditDetails().getLastModifiedBy(),
						document.getAuditDetails().getCreatedTime(),
						document.getAuditDetails().getLastModifiedTime(),
						propertyDetailsId };

				jdbcTemplate.update(documentSql, documentArgs);

			}

			//vacantland property insertion
			VacantLandDetail vacantLand = property.getVacantLand();
			StringBuffer vaccantLandSql=new StringBuffer();
			vaccantLandSql.append("insert into egpt_vacantland(surveyNumber,pattaNumber,")
			.append("marketValue,capitalValue,layoutApprovedAuth,layoutPermissionNo,layoutPermissionDate,")
			.append("resdPlotArea,nonResdPlotArea,createdBy, lastModifiedBy, createdTime,lastModifiedTime,property_id)")
			.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			Object[] vaccantLandArgs = {vacantLand.getSurveyNumber(),
					vacantLand.getPattaNumber(), vacantLand.getMarketValue(), vacantLand.getCapitalValue(),
					vacantLand.getLayoutApprovedAuth(), vacantLand.getLayoutPermissionNo(),
					vacantLand.getLayoutPermissionDate(), vacantLand.getResdPlotArea(), vacantLand.getNonResdPlotArea(),
					vacantLand.getAuditDetails().getCreatedBy(), 
					vacantLand.getAuditDetails().getLastModifiedBy(),
					vacantLand.getAuditDetails().getCreatedTime(),
					vacantLand.getAuditDetails().getLastModifiedTime(), propertyId };

			jdbcTemplate.update(vaccantLandSql.toString(), vaccantLandArgs);

			//boundary insertion
			PropertyLocation boundary = property.getBoundary();
			StringBuffer boundarySql=new StringBuffer();
			boundarySql.append("insert into propertylocation(revenueBoundary, locationBoundary,")
			.append(" adminBoundary, northBoundedBy,eastBoundedBy, westBoundedBy,")
			.append("southBoundedBy,createdBy, lastModifiedBy, createdTime,lastModifiedTime, property_id) values (?,?,?,?,?,?,?,?,?,?,?,?);");

			Object[] boundaryArgs = { boundary.getRevenueBoundary(),boundary.getLocationBoundary(),boundary.getAdminBoundary(),
					boundary.getNorthBoundedBy(),boundary.getEastBoundedBy(),boundary.getWestBoundedBy(),
					boundary.getSouthBoundedBy(),
					boundary.getAuditDetails().getCreatedBy(), 
					boundary.getAuditDetails().getLastModifiedBy(),
					boundary.getAuditDetails().getCreatedTime(),
					boundary.getAuditDetails().getLastModifiedTime(),
					propertyId};

			jdbcTemplate.update(boundarySql.toString(), boundaryArgs);


			//property and user relation table insertion
			for (OwnerInfo owner : property.getOwners()) {
				StringBuffer userPropertySql = new StringBuffer();
				userPropertySql.append("insert into egpt_Property_user(property_Id, user_Id,isPrimaryOwner,")
				.append("isSecondaryOwner,ownerShipPercentage, ownerType, createdBy, lastModifiedBy, createdTime,lastModifiedTime)")
				.append("values (?,?,?,?,?,?,?,?,?,?);");
				Object[] userPropertyArgs = { propertyId, owner.getId(),
						owner.getIsPrimaryOwner(),
						owner.getAuditDetails().getCreatedBy(),
						owner.getAuditDetails().getLastModifiedBy(),
						owner.getAuditDetails().getCreatedTime(),
						owner.getAuditDetails().getLastModifiedTime(),
						owner.getIsSecondaryOwner(),
						owner.getOwnerShipPercentage(),
						owner.getOwnerType() };

				jdbcTemplate.update(userPropertySql.toString(), userPropertyArgs);

			}

		}
	}

}
