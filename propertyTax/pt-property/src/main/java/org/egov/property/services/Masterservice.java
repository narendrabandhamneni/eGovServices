package org.egov.property.services;

import org.egov.models.DepartmentRequest;
import org.egov.models.DepartmentResponseInfo;
import org.egov.models.FloorTypeRequest;
import org.egov.models.FloorTypeResponse;
import org.egov.models.PropertyTypeRequest;
import org.egov.models.PropertyTypeResponse;
import org.egov.models.RequestInfo;
import org.egov.models.RoofTypeRequest;
import org.egov.models.RoofTypeResponse;
import org.egov.models.WoodTypeRequest;
import org.egov.models.WoodTypeResponse;
import org.egov.property.model.MasterModel;

public interface Masterservice {



	public DepartmentResponseInfo createDepartmentMaster(String tenantId, DepartmentRequest departmentRequest);

	public DepartmentResponseInfo updateDepartmentMaster(String tenantId, Long id, DepartmentRequest departmentRequest);

	public DepartmentResponseInfo getDepartmentMaster(RequestInfo requestInfo, String tenantId, Integer[] ids,
			String category, String name, String code, String nameLocal, Integer pageSize, Integer offSet);
	
	public FloorTypeResponse getFloorTypeMaster(RequestInfo requestInfo, String tenantId,Integer []ids, String name ,String code,String nameLocal, Integer pageSize, Integer offSet) throws Exception;

	public FloorTypeResponse createFloorType(FloorTypeRequest floorTypeRequest,String tenantId) throws Exception;

	public FloorTypeResponse updateFloorType(FloorTypeRequest floorTypeRequest,String tenantId,Integer id) throws Exception;

	// Wood Types

	public WoodTypeResponse getWoodTypes (RequestInfo requestInfo,String tenantId,Integer []ids, String name ,String code,String nameLocal, Integer pageSize, Integer offSet) throws Exception;

	public WoodTypeResponse createWoodType(WoodTypeRequest woodTypeRequest,String tenantId) throws Exception;

	public WoodTypeResponse updateWoodType(WoodTypeRequest woodTypeRequest,String tenantId,Integer id) throws Exception;


	// Roof Types

	public RoofTypeResponse getRoofypes (RequestInfo requestInfo,String tenantId,Integer []ids, String name ,String code,String nameLocal, Integer pageSize, Integer offSet) throws Exception;

	public RoofTypeResponse createRoofype(RoofTypeRequest roofTypeRequest,String tenantId) throws Exception;

	public RoofTypeResponse updateRoofType(RoofTypeRequest roofTypeRequest,String tenantId,Integer id) throws Exception;



}
