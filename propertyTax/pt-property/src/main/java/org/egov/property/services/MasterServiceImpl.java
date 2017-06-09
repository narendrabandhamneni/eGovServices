package org.egov.property.services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.egov.models.Department;
import org.egov.models.DepartmentRequest;
import org.egov.models.DepartmentResponseInfo;
import org.egov.models.PropertyType;
import org.egov.models.PropertyTypeRequest;
import org.egov.models.PropertyTypeResponse;
import org.egov.models.RequestInfo;
import org.egov.models.ResponseInfo;
import org.egov.models.ResponseInfoFactory;
import org.egov.property.exception.InvalidInputException;
import org.egov.property.exception.PropertySearchException;
import org.egov.property.model.ExcludeFileds;
import org.egov.property.model.MasterListModel;
import org.egov.property.model.MasterModel;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Description : MasterService interface implementation class 
 * @author Narendra
 *
 */

@Service
public class MasterServiceImpl  implements Masterservice{

	@Autowired
	private MasterListModel masterList;


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired

	private ResponseInfoFactory responseInfoFactory;

	/**
	 *Description : This method for getting property types
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */
	@Override
	public MasterModel getPropertyTypes(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getPropertyType(),tenantId,code,requestInfo);
	}

	/**
	 *Description : This method for getting usage master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */

	@Override
	public MasterModel getUsageMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getUsageMaster(),tenantId,code,requestInfo);
	}

	/**
	 *Description : This method for getting ocupancy master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */


	@Override
	public MasterModel getOcupancyMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getOccupancyMaster(),tenantId,code,requestInfo);
	}

	/**
	 *Description : This method for getting tax rate details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */


	@Override
	public MasterModel getTaxRateMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getTaxRateMaster(),tenantId,code,requestInfo);
	}

	/**
	 *Description : This method for getting wall type master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */


	@Override
	public MasterModel getWallTypeMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getWallTypeMaster(),tenantId,code,requestInfo);
	}

	/**
	 *Description : This method for getting roof type master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */


	@Override
	public MasterModel getRoofTypeMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getRoofTypeMaster(),tenantId,code,requestInfo);
	}


	/**
	 *Description : This method for getting wood type master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */


	@Override
	public MasterModel getWoodTypeMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getWoodTypeMaster(),tenantId,code,requestInfo);
	}

	/**
	 *Description : This method for getting apartment master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */


	@Override
	public MasterModel getApartmentMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getApartmentMaster(),tenantId,code,requestInfo);
	}

	/**
	 *Description : This method for getting floor master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */


	@Override
	public MasterModel getFloorTypeMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getFloorTypeMaster(),tenantId,code,requestInfo);
	}

	/**
	 * Description : this method will get data from yaml
	 * @param masterData
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return
	 */

	public MasterModel getMaster(List<MasterModel> masterData,String tenantId,String code,RequestInfo requestInfo){
		List<MasterModel> modelList = null;
		if(tenantId!=null && code!=null){
			modelList= masterData.stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		}
		else if(tenantId==null || tenantId.isEmpty()){
			modelList= masterData.stream().filter(m->m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		}
		else if(code==null || code.isEmpty()){
			modelList= masterData.stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)).collect(Collectors.toList());
		}
		if(modelList.size()==0)
			throw new InvalidInputException(requestInfo);
		return modelList.get(0);
	}

	/**
	 *Description : This method for getting strcture master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */


	@Override
	public MasterModel getStructureMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getStructureMaster(),tenantId,code,requestInfo);
	}

	/**
	 * Description : This method for getting usage mutation reason master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */


	@Override
	public MasterModel getMutationReasonMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getMutationReasonMaster(),tenantId,code,requestInfo);
	}


	/**
	 * Description : This method for getting mutation rate master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */


	@Override
	public MasterModel getMutationRateMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getMutationRateMaster(),tenantId,code,requestInfo);
	}

	/**
	 *Description : This method for getting document type master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterModel
	 * @throws Exception
	 */

	@Override
	public MasterModel getDocumentTypeMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getDocumentTypeMaster(),tenantId,code,requestInfo);
	}

	/**
	 * Description : This method will use for creating department type
	 * @param tenantId
	 * @param departmentRequest
	 * @return
	 */

	@Override
	@Transactional
	public DepartmentResponseInfo createDepartmentMaster(String tenantId, DepartmentRequest departmentRequest) {
		// TODO Auto-generated method stub

		for(Department department:departmentRequest.getDepartments()){

			Long createdTime=new Date().getTime();

			Gson gson=new GsonBuilder().setExclusionStrategies(new ExcludeFileds()).serializeNulls().create();

			String data=gson.toJson(department);

			StringBuffer depeartmentQuery=new StringBuffer();
			depeartmentQuery.append("insert into egpt_department_master(tenantId,code,data,");
			depeartmentQuery.append("createdBy, lastModifiedBy, createdTime,lastModifiedTime)");
			depeartmentQuery.append(" values(?,?,?,?,?,?,?)");


			final PreparedStatementCreator psc = new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
					final PreparedStatement ps = connection.prepareStatement(depeartmentQuery.toString(), new String[] { "id" });
					ps.setString(1, department.getTenantId());
					ps.setString(2, department.getCode());
					PGobject jsonObject = new PGobject();
					jsonObject.setType("json");
					jsonObject.setValue(data);
					ps.setObject(3,jsonObject);
					ps.setString(4, department.getAuditDetails().getCreatedBy());
					ps.setString(5, department.getAuditDetails().getLastModifiedBy());
					ps.setLong(6, createdTime);
					ps.setLong(7, createdTime);
					return ps;
				}
			};

			// The newly generated key will be saved in this object
			final KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(psc, holder);
			department.setId(Long.valueOf(holder.getKey().intValue()));

		}
		ResponseInfo responseInfo=responseInfoFactory.createResponseInfoFromRequestInfo(departmentRequest.getRequestInfo(),true);

		DepartmentResponseInfo departmentResponse=new DepartmentResponseInfo();
		departmentResponse.setDepartments(departmentRequest.getDepartments());
		departmentResponse.setResponseInfo(responseInfo);
		return departmentResponse;
	}

	@Override
	@Transactional
	public DepartmentResponseInfo updateDepartmentMaster(String tenantId, Long id, DepartmentRequest departmentRequest) {

		for(Department department:departmentRequest.getDepartments()){

			Long modifiedTime=new Date().getTime();

			Gson gson=new GsonBuilder().setExclusionStrategies(new ExcludeFileds()).serializeNulls().create();

			String data=gson.toJson(department);

			String departmentTypeUpdate = "UPDATE egpt_department_master set tenantId = ?, code = ?,data = ?, lastModifiedBy = ?, lastModifiedTime = ? where id = " +id;


			final PreparedStatementCreator psc = new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
					final PreparedStatement ps = connection.prepareStatement(departmentTypeUpdate, new String[] { "id" });
					ps.setString(1, department.getTenantId());	
					ps.setString(2,department.getCode());
					ps.setString(3, data);
					ps.setString(4, department.getAuditDetails().getLastModifiedBy());
					ps.setLong(5, modifiedTime);
					return ps;
				}
			};
			jdbcTemplate.update(psc);

		}
		ResponseInfo responseInfo=responseInfoFactory.createResponseInfoFromRequestInfo(departmentRequest.getRequestInfo(),true);

		DepartmentResponseInfo departmentResponse=new DepartmentResponseInfo();
		departmentResponse.setDepartments(departmentRequest.getDepartments());
		departmentResponse.setResponseInfo(responseInfo);
		return departmentResponse;
	}


	@Override
	public DepartmentResponseInfo getDepartmentMaster(RequestInfo requestInfo, String tenantId, Integer[] ids, String category, String name, String code, String nameLocal, Integer pageSize, Integer offSet) {

		StringBuffer departmentSearchSql = new StringBuffer();

		departmentSearchSql.append("select * from egpt_department_master where tenantid ='"+tenantId+"'");

		if (ids!=null && ids.length>0){

			String  departmentIds= "";

			int count = 1;
			for (Integer id : ids){
				if (count<ids.length)
					departmentIds = departmentIds+id+",";
				else
					departmentIds = departmentIds+id;

				count++;
			}

			departmentSearchSql.append(" AND id IN ("+departmentIds+")");

		}

		StringBuffer dataSearch = new StringBuffer();

		if (code!=null && !code.isEmpty())
			departmentSearchSql.append(" AND code = '"+code+"'");

		if(name!=null || category!=null || nameLocal!=null)
			dataSearch.append(" AND data = '");

		if (name!=null && !name.isEmpty())
			dataSearch.append("{ \"name\":\""+name+"\"");

		if (nameLocal!=null && !nameLocal.isEmpty()){
			if(name!=null && !name.isEmpty())
				dataSearch.append(" , {\"nameLocal\":\""+nameLocal+"\"");
			else
				dataSearch.append("{\"nameLocal\":\""+nameLocal+"\"");	
		}
		if ( category!=null &&  !category.isEmpty()  ){
			if( nameLocal!=null && !nameLocal.isEmpty())
				dataSearch.append(" ,  {\"category\":\""+category+"\"");
			else if( name!=null && !name.isEmpty())
				dataSearch.append(" ,  {\"category\":\""+category+"\"");
			else
				dataSearch.append("{\"category\":\""+category+"\"");
		}	

		if(name!=null || category!=null || nameLocal!=null)
			dataSearch.append("}'");

		departmentSearchSql.append( dataSearch.toString());
		if ( pageSize == null )
			pageSize = 30;
		if ( offSet ==null)
			offSet = 0;


		DepartmentResponseInfo departmentResponse = new DepartmentResponseInfo();

		try {

			List<Department> department = jdbcTemplate.query(departmentSearchSql.toString(), new BeanPropertyRowMapper(Department.class));
			ResponseInfo responseInfo=responseInfoFactory.createResponseInfoFromRequestInfo(requestInfo,true);

			departmentResponse.setDepartments(department);
			departmentResponse.setResponseInfo(responseInfo);
		}
		catch (Exception e) {
			throw new PropertySearchException("invalid input",requestInfo);
		}
		return departmentResponse;

	}


	/**
	 * Description : This method will use for creating property type
	 * @param tenantId
	 * @param propertyTypeRequest
	 * @return
	 */

	@Override
	public PropertyTypeResponse createPropertyTypeMaster(String tenantId, PropertyTypeRequest propertyTypeRequest) {
		// TODO Auto-generated method stub

		for(PropertyType propertyType:propertyTypeRequest.getPropertyTypes()){

			Long createdTime = new Date().getTime();

			String propertyTypeSql="insert into egpt_propertytypes_master(tenantId,name,code,nameLocal,description,active,orderNumber,"
					+ "createdBy,lastmodifiedby, createdtime, lastmodifiedtime) values(?,?,?,?,?,?,?,?,?,?,?)";	
			final PreparedStatementCreator psc = new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
					final PreparedStatement ps = connection.prepareStatement(propertyTypeSql, new String[] { "id" });
					ps.setString(1, propertyType.getTenantId());
					ps.setString(2, propertyType.getName());
					ps.setString(3, propertyType.getCode());
					ps.setString(4, propertyType.getNameLocal());
					ps.setString(5, propertyType.getDescription() );
					ps.setBoolean(6, propertyType.getActive());
					ps.setInt(7, propertyType.getOrderNumber());
					ps.setString(8, propertyType.getAuditDetails().getCreatedBy());
					ps.setString(9, propertyType.getAuditDetails().getLastModifiedBy());
					ps.setLong(10, createdTime);
					ps.setLong(11, createdTime);
					return ps;
				}
			};

			// The newly generated key will be saved in this object
			final KeyHolder holder = new GeneratedKeyHolder();
			jdbcTemplate.update(psc, holder);
			propertyType.setId(Long.valueOf(holder.getKey().intValue()));


		}
		ResponseInfo responseInfo=responseInfoFactory.createResponseInfoFromRequestInfo(propertyTypeRequest.getRequestInfo(),true);

		PropertyTypeResponse propertyTypeResponse = new PropertyTypeResponse();

		propertyTypeResponse.setPropertyTypes(propertyTypeRequest.getPropertyTypes());

		propertyTypeResponse.setResponseInfo(responseInfo);

		return propertyTypeResponse;
	}


	/**
	 * Description : This method will use for update property type
	 * @param tenantId
	 * @param propertyTypeResponse
	 * @return
	 */
	@Override
	public PropertyTypeResponse updatePropertyTypeMaster(String tenantId, Long id,PropertyTypeRequest propertyTypeRequest) {

		for(PropertyType propertyType: propertyTypeRequest.getPropertyTypes()){

			Long modifiedTime=new Date().getTime();

			String PropertyTypeUpdateSql = "update egpt_propertytypes_master set tenantId = ?, name = ?, code = ?, nameLocal = ?, description = ?, active = ?,"
					+ "orderNumber = ?, lastmodifiedby = ?, lastmodifiedtime = ?   where id = id and tenantId = tenantId  ";
			final PreparedStatementCreator psc = new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
					final PreparedStatement ps = connection.prepareStatement(PropertyTypeUpdateSql, new String[] { "id" });
					ps.setString(1, propertyType.getTenantId());
					ps.setString(2, propertyType.getName());
					ps.setString(3,propertyType.getCode());
					ps.setString(4, propertyType.getNameLocal());
					ps.setString(6, propertyType.getDescription());
					ps.setBoolean(7, propertyType.getActive());
					ps.setInt(8, propertyType.getOrderNumber());
					ps.setString(9, propertyType.getAuditDetails().getLastModifiedBy());
					ps.setLong(10, modifiedTime);
					return ps;
				}
			};
			jdbcTemplate.update(psc);

		}
		ResponseInfo responseInfo=responseInfoFactory.createResponseInfoFromRequestInfo(propertyTypeRequest.getRequestInfo(),true);

		PropertyTypeResponse propertyTypeResponse=new PropertyTypeResponse();
		propertyTypeResponse.setPropertyTypes(propertyTypeRequest.getPropertyTypes());
		propertyTypeResponse.setResponseInfo(responseInfo);
		return propertyTypeResponse;
	}



	@Override
	public PropertyTypeResponse getPropertyTypeMaster(RequestInfo requestInfo, String tenantId, Integer[] ids, String name, String code, String nameLocal, Boolean active, Integer orderNumber, Integer pageSize, Integer offSet) {

		StringBuffer propertyTypeSearchSql = new StringBuffer();

		propertyTypeSearchSql.append("select * from egpt_propertytypes_master where tenantid ='"+tenantId+"'");



		if (ids!=null && ids.length>0){

			String  propertyTypeIds= "";

			int count = 1;
			for (Integer id : ids){
				if (count<ids.length)
					propertyTypeIds = propertyTypeIds+id+",";
				else
					propertyTypeIds = propertyTypeIds+id;

			}


			propertyTypeSearchSql.append(" AND id IN ("+propertyTypeIds+")");



		}



		if ( name!=null && !name.isEmpty() )
			propertyTypeSearchSql.append(" AND name ="+name);

		if (code!=null && !code.isEmpty())
			propertyTypeSearchSql.append(" AND code ="+code);

		if ( nameLocal!=null && !nameLocal.isEmpty())
			propertyTypeSearchSql.append(" AND  namelocal = "+nameLocal);

		if ( active!=null )
			propertyTypeSearchSql.append(" AND active ="+active);
		if ( orderNumber!=null)
			propertyTypeSearchSql.append(" AND orderNumber ="+orderNumber);

		if ( pageSize == -1 )
			pageSize = 30;
		if ( offSet == -1 )
			offSet = 0;


		PropertyTypeResponse propertyTypeResponse = new PropertyTypeResponse();

		try {

			List<PropertyType> propertyTypes = jdbcTemplate.query(propertyTypeSearchSql.toString(), new BeanPropertyRowMapper(Department.class));
			ResponseInfo responseInfo=responseInfoFactory.createResponseInfoFromRequestInfo(requestInfo,true);

			propertyTypeResponse.setPropertyTypes(propertyTypes);
			propertyTypeResponse.setResponseInfo(responseInfo);
		}
		catch (Exception e) {
			throw new PropertySearchException("invalid input",requestInfo);
		}
		return propertyTypeResponse;

	}


}
