package org.egov.models;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * User
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@NotNull
	@Length(min=4, max= 128)
	private String tenantId;

	private Double id;

	@NotNull
	@Length(min=1, max=64)
	private String userName;

	private String authToken;

	@Length(min=1, max=5)
	private String salutation;

	@NotNull
	@Length(min=1, max= 100)
	private String name;

	@NotNull
	@Length(min=1, max=8)
	private String gender;

	@NotNull
	@Length(min=1, max= 10)
	private String mobileNumber;

	@Length(min=1, max= 128)
	private String emailId;

	@Length(min=12, max= 12)
	private String aadhaarNumber;

	@NotNull
	private Boolean active;

	private Long pwdExpiryDate;

	@NotNull
	private String locale;

	@Length(min=1, max= 16)
	@NotNull
	private String type;

	private Boolean accountLocked;

	@Valid
	private List<Role> roles;


	private UserDetails userDetails;

	private AuditDetails auditDetails;
	
	private Boolean isPrimaryOwner;

	private Boolean isSecondaryOwner;

	private Double ownerShipPercentage;

	private String ownerType;

}
