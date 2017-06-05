package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * <h1>ResponseInfo</h1>
 * @author Narendra
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseInfo {

	private String apiId;

	private String ver;

	private String ts;

	private String resMsgId;

	private String msgId;

	@NonNull
	private String status;

}
