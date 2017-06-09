package org.egov.property.services;

import org.egov.models.DepartmentRequest;
import org.egov.models.DepartmentResponseInfo;
import org.egov.models.PropertyTypeRequest;
import org.egov.models.PropertyTypeResponse;
import org.egov.models.RequestInfo;
import org.egov.property.model.MasterModel;

public interface Masterservice {

	public MasterModel getPropertyTypes(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getUsageMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getOcupancyMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getTaxRateMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getWallTypeMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getRoofTypeMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getWoodTypeMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getApartmentMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getFloorTypeMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getStructureMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getMutationReasonMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getMutationRateMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public MasterModel getDocumentTypeMaster(String tenantId,String code,RequestInfo requestInfo) throws Exception;

	public DepartmentResponseInfo createDepartmentMaster(String tenantId, DepartmentRequest departmentRequest);

	public DepartmentResponseInfo updateDepartmentMaster(String tenantId, Long id, DepartmentRequest departmentRequest);

	public PropertyTypeResponse createPropertyTypeMaster(String tenantId, PropertyTypeRequest propertyTypeRequest);

	public PropertyTypeResponse updatePropertyTypeMaster(String tenantId, Long id,PropertyTypeRequest propertyTypeRequest);

	public DepartmentResponseInfo getDepartmentMaster(RequestInfo requestInfo, String tenantId, Integer[] ids,
			String category, String name, String code, String nameLocal, Integer pageSize, Integer offSet);

	public PropertyTypeResponse getPropertyTypeMaster(RequestInfo requestInfo, String tenantId, Integer[] ids,
			String name, String code, String nameLocal, Boolean active, Integer orderNumber, Integer pageSize,
			Integer offSet);


}
