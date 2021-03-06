package org.egov.models;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <h1>IdGenerationRequest</h1>
 * @author Narendra
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
