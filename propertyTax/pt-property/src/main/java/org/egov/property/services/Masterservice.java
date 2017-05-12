package org.egov.property.services;

import org.egov.property.model.MasterModel;

public interface Masterservice {
	
	public MasterModel getPropertyTypes(String tenantId,String code) throws Exception;
	
	public MasterModel getUsageMaster(String tenantId,String code) throws Exception;
	
	public MasterModel getOcupancyMaster(String tenantId,String code) throws Exception;
	
	public MasterModel getTaxRateMaster(String tenantId,String code) throws Exception;
	
	public MasterModel getWallTypeMaster(String tenantId,String code) throws Exception;
	
	public MasterModel getRoofTypeMaster(String tenantId,String code) throws Exception;
	
	public MasterModel getWoodTypeMaster(String tenantId,String code) throws Exception;
	
	public MasterModel getApartmentMaster(String tenantId,String code) throws Exception;
	
	public MasterModel getFloorTypeMaster(String tenantId,String code) throws Exception;

	
	
	
}
