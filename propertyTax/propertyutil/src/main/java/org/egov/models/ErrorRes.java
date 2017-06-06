package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <h1>ErrorRes</h1>
 * @author Narendra
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ErrorRes {

	private ResponseInfo resposneInfo;

	private Error error;

}
