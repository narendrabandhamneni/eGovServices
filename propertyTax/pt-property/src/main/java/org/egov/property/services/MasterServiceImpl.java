package org.egov.property.services;
import java.util.List;
import java.util.stream.Collectors;

import org.egov.models.RequestInfo;
import org.egov.property.exception.InvalidInputException;
import org.egov.property.model.MasterListModel;
import org.egov.property.model.MasterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MasterServiceImpl  implements Masterservice{

	@Autowired
	private MasterListModel masterList;

	@Override
	public MasterModel getPropertyTypes(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getPropertyType(),tenantId,code,requestInfo);
	}

	@Override
	public MasterModel getUsageMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getUsageMaster(),tenantId,code,requestInfo);
	}

	@Override
	public MasterModel getOcupancyMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getOccupancyMaster(),tenantId,code,requestInfo);
	}

	@Override
	public MasterModel getTaxRateMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getTaxRateMaster(),tenantId,code,requestInfo);
	}

	@Override
	public MasterModel getWallTypeMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getWallTypeMaster(),tenantId,code,requestInfo);
	}

	@Override
	public MasterModel getRoofTypeMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getRoofTypeMaster(),tenantId,code,requestInfo);
	}

	@Override
	public MasterModel getWoodTypeMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getWoodTypeMaster(),tenantId,code,requestInfo);
	}

	@Override
	public MasterModel getApartmentMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getApartmentMaster(),tenantId,code,requestInfo);
	}

	@Override
	public MasterModel getFloorTypeMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getFloorTypeMaster(),tenantId,code,requestInfo);
	}

	public MasterModel getMaster(List<MasterModel> masterData,String tenantId,String code,RequestInfo requestInfo){
		List<MasterModel> modelList= masterData.stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		if(modelList.size()==0)
			throw new InvalidInputException(requestInfo);
		return modelList.get(0);
	}

	@Override
	public MasterModel getStructureMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getStructureMaster(),tenantId,code,requestInfo);
	}

	@Override
	public MasterModel getMutationReasonMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getMutationReasonMaster(),tenantId,code,requestInfo);
	}



	@Override
	public MasterModel getMutationRateMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getMutationRateMaster(),tenantId,code,requestInfo);
	}



	@Override
	public MasterModel getDocumentTypeMaster(String tenantId, String code,RequestInfo requestInfo) throws Exception {
		return	getMaster(masterList.getDocumentTypeMaster(),tenantId,code,requestInfo);
	}

}
