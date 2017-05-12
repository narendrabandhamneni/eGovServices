package org.egov.property.services;
import java.util.List;
import java.util.stream.Collectors;

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
	public MasterModel getPropertyTypes(String tenantId, String code) throws Exception {
		List<MasterModel> modelList= masterList.getPropertyType().stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		if(modelList.size()==0)
			throw new InvalidInputException();
		return modelList.get(0);
	}

	

	@Override
	public MasterModel getUsageMaster(String tenantId, String code) throws Exception {
		List<MasterModel> modelList= masterList.getUsageMaster().stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		if(modelList.size()==0)
			throw new InvalidInputException();
		return modelList.get(0);
	}

	@Override
	public MasterModel getOcupancyMaster(String tenantId, String code) throws Exception {
		List<MasterModel> modelList= masterList.getOccupancyMaster().stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		if(modelList.size()==0)
			throw new InvalidInputException();
		return modelList.get(0);
	}

	@Override
	public MasterModel getTaxRateMaster(String tenantId, String code) throws Exception {
		List<MasterModel> modelList= masterList.getTaxRateMaster().stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		if(modelList.size()==0)
			throw new InvalidInputException();
		return modelList.get(0);
	}

	@Override
	public MasterModel getWallTypeMaster(String tenantId, String code) throws Exception {
		List<MasterModel> modelList= masterList.getWallTypeMaster().stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		if(modelList.size()==0)
			throw new InvalidInputException();
		return modelList.get(0);
	}

	@Override
	public MasterModel getRoofTypeMaster(String tenantId, String code) throws Exception {
		List<MasterModel> modelList= masterList.getRoofTypeMaster().stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		if(modelList.size()==0)
			throw new InvalidInputException();
		return modelList.get(0);
	}

	@Override
	public MasterModel getWoodTypeMaster(String tenantId, String code) throws Exception {
		List<MasterModel> modelList= masterList.getWoodTypeMaster().stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		if(modelList.size()==0)
			throw new InvalidInputException();
		return modelList.get(0);
	}

	@Override
	public MasterModel getApartmentMaster(String tenantId, String code) throws Exception {
		List<MasterModel> modelList= masterList.getApartmentMaster().stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		if(modelList.size()==0)
			throw new InvalidInputException();
		return modelList.get(0);
	}

	@Override
	public MasterModel getFloorTypeMaster(String tenantId, String code) throws Exception {
		List<MasterModel> modelList= masterList.getFloorTypeMaster().stream().filter(m->m.getTenantId().equalsIgnoreCase(tenantId)&& m.getCode().equalsIgnoreCase(code)).collect(Collectors.toList());
		if(modelList.size()==0)
			throw new InvalidInputException();
		return modelList.get(0);
	}
	

}
