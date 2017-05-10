package org.egov.property.services;



import org.egov.property.model.MasterModel;


public interface Masterservice {

	
	public MasterModel GetPropertyTypes(long tenantId,int code) throws Exception;
}
