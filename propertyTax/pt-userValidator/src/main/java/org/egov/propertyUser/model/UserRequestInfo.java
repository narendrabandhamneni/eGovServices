package org.egov.propertyUser.model;

import java.util.List;

import org.egov.models.RequestInfo;
import org.egov.models.User;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestInfo {
	@JsonProperty("User")
	private User User;

	@JsonProperty("user")
	private List<User> user;

	@JsonProperty("RequestInfo")
	private RequestInfo RequestInfo;
}
