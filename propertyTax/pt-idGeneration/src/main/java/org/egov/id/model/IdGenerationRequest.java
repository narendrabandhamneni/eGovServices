package org.egov.id.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <h1>IdGenerationRequest</h1>
 * 
 * @author Pavan Kumar Kamma
 *
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class IdGenerationRequest {

	private RequestInfo requestInfo;

	private List<IdRequest> idRequests;

}
