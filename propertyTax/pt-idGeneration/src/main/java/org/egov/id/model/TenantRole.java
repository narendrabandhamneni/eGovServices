package org.egov.id.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User role carries the tenant related role information for the user. A user
 * can have multiple roles per tenant based on the need of the tenant. A user
 * may also have multiple roles for multiple tenants. Author : Pavan Kumar Kamma
 */

public class TenantRole {
	@JsonProperty("tenantId")
	@NotNull
	private String tenantId = null;

	@JsonProperty("roles")
	@NotNull
	private List<Role> roles = new ArrayList<Role>();

	/**
	 * tenantid for the tenant
	 * 
	 * @return tenantId
	 **/
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * Roles assigned for a particular tenant - array of role codes/names
	 * 
	 * @return roles
	 **/
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TenantRole tenantRole = (TenantRole) o;
		return Objects.equals(this.tenantId, tenantRole.tenantId)
				&& Objects.equals(this.roles, tenantRole.roles);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tenantId, roles);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class TenantRole {\n");

		sb.append("    tenantId: ").append(toIndentedString(tenantId))
				.append("\n");
		sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
