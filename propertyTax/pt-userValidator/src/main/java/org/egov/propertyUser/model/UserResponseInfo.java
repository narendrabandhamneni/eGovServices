package org.egov.propertyUser.model;

import java.util.List;

import org.egov.models.ResponseInfo;
import org.egov.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * <h1>UserResponseInfo</h1>
 * This model have  List of User and RequestInfo models
 * This model class is used to get User response 
 * 
 * @author S Anilkumar
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseInfo {

	private List<User> user;

	private ResponseInfo responseInfo;

}
