package org.egov.property.api;

import org.egov.models.DepartmentRequest;
import org.egov.models.DepartmentResponseInfo;
import org.egov.models.FloorTypeRequest;
import org.egov.models.FloorTypeResponse;
import org.egov.models.OccuapancyMasterRequest;
import org.egov.models.OccuapancyMasterResponse;
import org.egov.models.PropertyTypeRequest;
import org.egov.models.PropertyTypeResponse;
import org.egov.models.RequestInfoWrapper;
import org.egov.models.ResponseInfoFactory;
import org.egov.models.RoofTypeRequest;
import org.egov.models.RoofTypeResponse;
import org.egov.models.StructureClassRequest;
import org.egov.models.StructureClassResponse;
import org.egov.models.UsageMasterRequest;
import org.egov.models.UsageMasterResponse;
import org.egov.models.WallTypeRequest;
import org.egov.models.WallTypeResponse;
import org.egov.models.WoodTypeRequest;
import org.egov.models.WoodTypeResponse;
import org.egov.property.services.Masterservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller have the all api's related to master
 * @author Narendra
 *
 */


@RestController
@RequestMapping(path="/property")
public class PropertyMasterController {

	@Autowired
	Masterservice masterService;

	@Autowired
	ResponseInfoFactory responseInfoFactory;


	@RequestMapping(path="/departments/_create",method=RequestMethod.POST)
	public DepartmentResponseInfo createDepartmentMaster(@RequestParam String tenantId, @RequestBody DepartmentRequest departmentRequest){

		return	masterService.createDepartmentMaster(tenantId,departmentRequest);

	}

	@RequestMapping(path="/departments/{id}/_update",method=RequestMethod.POST)
	public DepartmentResponseInfo updateDepartmentMaster(@RequestParam String tenantId, @PathVariable Long id,@RequestBody DepartmentRequest departmentRequest){

		return	masterService.updateDepartmentMaster(tenantId,id,departmentRequest);

	}

	@RequestMapping(path="/departments/_search",method=RequestMethod.POST)
	public DepartmentResponseInfo getDeparmentMaster(@RequestBody RequestInfoWrapper requestInfo ,
			@RequestParam(required=true) String tenantId,
			@RequestParam(required=false) Integer[] ids,
			@RequestParam(required=false) String category,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String code,
			@RequestParam(required=false) String nameLocal,
			@RequestParam(required=false) Integer pageSize,
			@RequestParam(required=false) Integer offSet
			) throws Exception {
		return masterService.getDepartmentMaster(requestInfo.getRequestInfo(),tenantId,ids, category, name ,code,nameLocal,pageSize,offSet);

	}

	/**
	 * Description : This api for getting floor master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterResponseInfo
	 * @throws Exception
	 */


	@RequestMapping(path="/floortypes/_search",method=RequestMethod.POST)
	public FloorTypeResponse getFloorTypeMaster(@RequestBody RequestInfoWrapper requestInfo ,
			@RequestParam(required=true) String tenantId,
			@RequestParam(required=false) Integer[] ids,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String code,
			@RequestParam(required=false) String nameLocal,
			@RequestParam(required=false) Integer pageSize,
			@RequestParam(required=false) Integer offSet
			) throws Exception {
			return masterService.getFloorTypeMaster(requestInfo.getRequestInfo(),tenantId,ids,name ,code,nameLocal,pageSize,offSet);
	
	}
	
	/**
	 * <p> This API will create the floorType<p>
	 * @param floorTypeRequest
	 * @param tenantId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path="/floortypes/_create",method=RequestMethod.POST)
	public FloorTypeResponse createFloorType (  @RequestBody FloorTypeRequest floorTypeRequest,
			@RequestParam (required = true) String tenantId) throws Exception{
		return masterService.createFloorType(floorTypeRequest, tenantId);
	}
	
	/**
	 * <p> This API will update the floor Type<p>
	 * @param floorTypeRequest
	 * @param tenantId
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path="floortypes/{id}/_update")
	public FloorTypeResponse updateFloorType( @RequestBody FloorTypeRequest floorTypeRequest ,
				@RequestParam(required=true) String tenantId ,
				@PathVariable Integer id) throws Exception{
		
		return masterService.updateFloorType(floorTypeRequest, tenantId, id);
	}
	
	/**
	 * <p> This API will search the wood types</p>
	 * @param requestInfo
	 * @param tenantId
	 * @param ids
	 * @param name
	 * @param code
	 * @param nameLocal
	 * @param pageSize
	 * @param offSet
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path="/woodtypes/_search",method=RequestMethod.POST)
	public WoodTypeResponse searchWoodType( @RequestBody RequestInfoWrapper requestInfo,
			@RequestParam(required=true) String tenantId,
			@RequestParam(required=false) Integer[] ids,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String code,
			@RequestParam(required=false) String nameLocal,
			@RequestParam(required=false) Integer pageSize,
			@RequestParam(required=false) Integer offSet
			) throws Exception{
		
		
		
		return masterService.getWoodTypes(requestInfo.getRequestInfo(), tenantId, ids, name, code, nameLocal, pageSize, offSet);
				
			}
	
	
	/**
	 * <p> This API will create the wood type response<p>
	 * @param woodTypeRequest
	 * @param tenantId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path="/woodtypes/_create",method=RequestMethod.POST)
	public WoodTypeResponse createWoodType (  @RequestBody WoodTypeRequest woodTypeRequest,
			@RequestParam (required = true) String tenantId) throws Exception{
		
		return masterService.createWoodType(woodTypeRequest, tenantId);
	}
	
	
	/**
	 * <p> This API will update the woodType<p>
	 * @param woodTypeRequest
	 * @param tenantId
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path="/woodtypes/{id}/_update")
	public WoodTypeResponse updateWoodType( @RequestBody WoodTypeRequest woodTypeRequest ,
				@RequestParam(required=true) String tenantId ,
				@PathVariable Integer id) throws Exception{
		
		return masterService.updateWoodType(woodTypeRequest, tenantId, id);
	}
	
	
	// Roof types
	/**
	 * <p> This Api 
	 * @param requestInfo
	 * @param tenantId
	 * @param ids
	 * @param name
	 * @param code
	 * @param nameLocal
	 * @param pageSize
	 * @param offSet
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(path="/rooftypes/_search",method=RequestMethod.POST)
	public RoofTypeResponse searchRoofType( @RequestBody RequestInfoWrapper requestInfo,
			@RequestParam(required=true) String tenantId,
			@RequestParam(required=false) Integer[] ids,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String code,
			@RequestParam(required=false) String nameLocal,
			@RequestParam(required=false) Integer pageSize,
			@RequestParam(required=false) Integer offSet
			) throws Exception{
		
		return masterService.getRoofypes(requestInfo.getRequestInfo(), tenantId, ids, name, code, nameLocal, pageSize, offSet);
		
				
			}
	
	
	@RequestMapping(path="/rooftypes/_create",method=RequestMethod.POST)
	public RoofTypeResponse createRoofType (  @RequestBody RoofTypeRequest roofTypeRequest,
			@RequestParam (required = true) String tenantId) throws Exception{
		
		return masterService.createRoofype(roofTypeRequest, tenantId);
	}
	
	
	
	@RequestMapping(path="/rooftypes/{id}/_update",method=RequestMethod.POST)
	public RoofTypeResponse updateRoofType( @RequestBody RoofTypeRequest roofTypeRequest ,
				@RequestParam(required=true) String tenantId ,
				@PathVariable Integer id) throws Exception{
		
		return masterService.updateRoofType(roofTypeRequest, tenantId, id);
	}

	
	/**
	* Description : This api for creating strctureClass master
	* @param tenantId
	* @param StructureClassRequest
	* @return structureClassResponse
	* @throws Exception
	*/


	@RequestMapping(path="structureclasses/_create",method=RequestMethod.POST)
	public StructureClassResponse craeateStructureClassMaster(@RequestParam String tenantId, @RequestBody  StructureClassRequest structureClassRequest){

	return	masterService.craeateStructureClassMaster(tenantId, structureClassRequest);

	}


	/**
	* Description : This api for updating strctureClass master
	* @param tenantId
	* @param StructureClassRequest
	* @return structureClassResponse
	* @throws Exception
	*/
	@RequestMapping(path="structureclasses/{id}/_update",method=RequestMethod.POST)
	public StructureClassResponse updateStructureClassMaster(@RequestParam String tenantId, @PathVariable Long id,@RequestBody StructureClassRequest structureClassRequest){

	return	masterService.updateStructureClassMaster(tenantId,id,structureClassRequest);

	}
	
	
	/**
	* Description : This api for searching strctureClass master
	* @param requestInfo
	* @param tenantId
	* @param ids
	* @param name
	* @param code
	* @param nameLocal
	* @param active 
	* @param orderNumber
	* @param pageSize
	* @param offSet
	* @return structureClassResponse
	* @throws Exception
	*/

	@RequestMapping(path="structureclasses/_search",method=RequestMethod.POST)
	public StructureClassResponse getStructureClassMaster(@RequestBody RequestInfoWrapper requestInfo,
	@RequestParam(required=true) String tenantId,
	@RequestParam(required=false) Integer[] ids,
	@RequestParam(required=false) String name,
	@RequestParam(required=false) String code,
	@RequestParam(required=false) String nameLocal,
	@RequestParam(required=false) Boolean active,
	@RequestParam(required=false) Integer orderNumber,
	@RequestParam(required=false) Integer pageSize,
	@RequestParam(required=false) Integer offSet
	) throws Exception {
	return masterService.getStructureClassMaster(requestInfo.getRequestInfo(),tenantId,ids, name , code, nameLocal, active, orderNumber, pageSize, offSet);

	}
	
	/**
	 * Description : This api for creating propertyType master
	 * @param tenantId
	 * @param propertyTypeRequest
	 * @return
	 */

	@RequestMapping(path="/propertytypes/_create",method=RequestMethod.POST)
    public PropertyTypeResponse createPropertyTypeMaster(@RequestParam String tenantId, @RequestBody PropertyTypeRequest propertyTypeRequest){

        return  masterService.createPropertyTypeMaster(tenantId,propertyTypeRequest);

    }

	/**
	 * Description : This api for updating propertyType master
	 * @param tenantId
	 * @param id
	 * @param propertyTypeRequest
	 * @return
	 */
	
    @RequestMapping(path="/propertytypes/{id}/_update",method=RequestMethod.POST)
    public PropertyTypeResponse updatePropertyTypeMaster(@RequestParam String tenantId, @PathVariable Long id,@RequestBody PropertyTypeRequest propertyTypeRequest){

        return  masterService.updatePropertyTypeMaster(tenantId,id,propertyTypeRequest);

    }

    /**
     * Description : This api for searching propertyType master
     * @param requestInfo
     * @param tenantId
     * @param ids
     * @param name
     * @param code
     * @param nameLocal
     * @param active
     * @param orderNumber
     * @param pageSize
     * @param offSet
     * @return
     * @throws Exception
     */
    
    @RequestMapping(path="/propertytypes/_search",method=RequestMethod.POST)
    public PropertyTypeResponse getPropertyTypeMaster(@RequestBody RequestInfoWrapper requestInfo ,
            @RequestParam(required=true) String tenantId,
            @RequestParam(required=false) Integer[] ids,            
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String code,
            @RequestParam(required=false) String nameLocal,
            @RequestParam(required=false) Boolean active,
            @RequestParam(required=false) Integer orderNumber,
            @RequestParam(required=false) Integer pageSize,
            @RequestParam(required=false) Integer offSet
            ) throws Exception {
        return masterService.getPropertyTypeMaster(requestInfo.getRequestInfo(),tenantId,ids, name ,code,nameLocal,active,orderNumber,pageSize,offSet);

    }
    
    /**
     * Description : This api for creating occupancy Type master
     * @param tenantId
     * @param occuapancyMasterRequest
     * @return
     */

    @RequestMapping(path="/occuapancies/_create",method=RequestMethod.POST)
    public OccuapancyMasterResponse createOccuapancyMaster(@RequestParam String tenantId, @RequestBody OccuapancyMasterRequest occuapancyMasterRequest){

        return  masterService.createOccuapancyMaster(tenantId,occuapancyMasterRequest);

    }
    
    
    /**
     * Description : This api for updating occupancyType master
     * @param tenantId
     * @param id
     * @param occuapancyRequest
     * @return
     */

    @RequestMapping(path="/occuapancies/{id}/_update",method=RequestMethod.POST)
    public OccuapancyMasterResponse updateOccuapancyMaster(@RequestParam String tenantId, @PathVariable Long id,@RequestBody OccuapancyMasterRequest occuapancyRequest){

        return  masterService.updateOccuapancyMaster(tenantId,id,occuapancyRequest);

    }
    
    /**
     * Description : This api for searching occupancy type master
     * @param requestInfo
     * @param tenantId
     * @param ids
     * @param name
     * @param code
     * @param nameLocal
     * @param active
     * @param orderNumber
     * @param pageSize
     * @param offSet
     * @return
     * @throws Exception
     */

    @RequestMapping(path="/occuapancies/_search",method=RequestMethod.POST)
    public OccuapancyMasterResponse getOccuapancyMaster(@RequestBody RequestInfoWrapper requestInfo ,
            @RequestParam(required=true) String tenantId,
            @RequestParam(required=false) Integer[] ids,            
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String code,
            @RequestParam(required=false) String nameLocal,
            @RequestParam(required=false) Boolean active,
            @RequestParam(required=false) Integer orderNumber,
            @RequestParam(required=false) Integer pageSize,
            @RequestParam(required=false) Integer offSet
            ) throws Exception {
        return masterService.getOccuapancyMaster(requestInfo.getRequestInfo(),tenantId,ids, name ,code,nameLocal,active,orderNumber,pageSize,offSet);

    }
    
    /**
	 * Description : This api for getting wall type master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterResponse
	 * @throws Exception
	 */


	@RequestMapping(path="/walltypes/_search",method=RequestMethod.POST)
	public WallTypeResponse getWallTypeMaster(@RequestBody RequestInfoWrapper requestInfo ,
			@RequestParam(required=true) String tenantId,
			@RequestParam(required=false) Integer[] ids,
			@RequestParam(required=false) String category,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String code,
			@RequestParam(required=false) String nameLocal,
			@RequestParam(required=false) Integer pageSize,
			@RequestParam(required=false) Integer offSet) throws Exception {

		return masterService.getWallTypeMaster(requestInfo.getRequestInfo(), tenantId, ids, name, code, nameLocal, pageSize, offSet);
	
	}
	
	/**
	 * Description : Create new walltype(s)
	 * @param tenantId
	 * @param wallTypeRequest
	 * @return WallTypeResponse
	 * @throws Exception
	 */


	@RequestMapping(path="/walltypes/_create",method=RequestMethod.POST)
	public WallTypeResponse createWallTypeMaster(
			@RequestParam String tenantId,
			@RequestBody WallTypeRequest wallTypeRequest) throws Exception {

		return masterService.createWallTypeMaster(tenantId, wallTypeRequest);
	}
	
	/**
	 * Description : Update any of the walltypes
	 * @param tenantId
	 * @param id
	 * @param wallTypeRequest
	 * @return WallTypeResponse
	 * @throws Exception
	 */


	@RequestMapping(path="/walltypes/{id}/_update",method=RequestMethod.POST)
	public WallTypeResponse updateWallTypeMaster(
			@RequestParam String tenantId,
			@PathVariable Long id,
			@RequestBody WallTypeRequest wallTypeRequest) throws Exception {

		return masterService.updateWallTypeMaster(tenantId, id, wallTypeRequest);
		
	}
	
	/**
	 * Description : This api for getting usage type master details
	 * @param tenantId
	 * @param code
	 * @param requestInfo
	 * @return masterResponse
	 * @throws Exception
	 */

	@RequestMapping(path="/usages/_search",method=RequestMethod.POST)
	public UsageMasterResponse getUsageMaster(@RequestBody RequestInfoWrapper requestInfo ,
			@RequestParam(required=true) String tenantId,
			@RequestParam(required=false) Integer[] ids,
			@RequestParam(required=false) String category,
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String code,
			@RequestParam(required=false) String nameLocal,
			@RequestParam(required=false) Integer pageSize,
			@RequestParam(required=false) Integer offSet) throws Exception {

		return	masterService.getUsageMaster(requestInfo.getRequestInfo(), tenantId, ids, name, code, nameLocal, pageSize, offSet);

	}

	/**
	 * Description : This api for creating new usagemaster(s)
	 * @param tenantId
	 * @param usageMasterRequest
	 * @return masterResponse
	 * @throws Exception
	 */
	@RequestMapping(path="/usages/_create",method=RequestMethod.POST)
	public UsageMasterResponse createUsageMaster(
			@RequestParam String tenantId,
			@RequestBody UsageMasterRequest usageMasterRequest) throws Exception {

		return masterService.createUsageMaster(tenantId, usageMasterRequest);
	}

	/**
	 * Description : This api to Update any of the usagemasters
	 * @param tenantId
	 * @param usageMasterRequest
	 * @return masterResponse
	 * @throws Exception
	 */

	@RequestMapping(path="/usages/{id}/_update",method=RequestMethod.POST)
	public UsageMasterResponse updateUsageMaster(
			@RequestParam String tenantId,
			@PathVariable Long id,
			@RequestBody UsageMasterRequest usageMasterRequest) throws Exception {

		return masterService.updateUsageMaster(tenantId, id, usageMasterRequest);
	}

}
