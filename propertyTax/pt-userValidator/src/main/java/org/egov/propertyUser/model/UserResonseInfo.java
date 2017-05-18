package org.egov.propertyUser.model;

import org.egov.models.ResponseInfo;
import org.egov.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResonseInfoModel {
	
	private User user;
	
	private ResponseInfo responseInfo;

}
