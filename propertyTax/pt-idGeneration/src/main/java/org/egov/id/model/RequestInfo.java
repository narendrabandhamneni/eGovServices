package org.egov.id.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * RequestInfo should be used to carry meta information about the requests to
 * the server as described in the fields below. All eGov APIs will use
 * requestinfo as a part of the request body to carry this meta information.
 * Some of this information will be returned back from the server as part of the
 * ResponseInfo in the response body to ensure correlation. Author : Pavan Kumar
 * Kamma
 */

public class RequestInfo {
	@JsonProperty("apiId")
	@NotNull
	@Size(max = 128)
	private String apiId = null;

	@JsonProperty("ver")
	@NotNull
	@Size(max = 32)
	private String ver = null;

	@JsonProperty("ts")
	@NotNull
	private Long ts = null;

	@JsonProperty("action")
	@NotNull
	@Size(max = 32)
	private String action = null;

	@JsonProperty("did")
	@Size(max = 1024)
	private String did = null;

	@JsonProperty("key")
	@Size(max = 256)
	private String key = null;

	@JsonProperty("msgId")
	@NotNull
	@Size(max = 256)
	private String msgId = null;

	@JsonProperty("requesterId")
	@Size(max = 256)
	private String requesterId = null;

	@JsonProperty("authToken")
	private String authToken = null;

	@JsonProperty("userInfo")
	private UserInfo userInfo = null;

	@JsonProperty("correlationId")
	private String correlationId = null;

	/**
	 * unique API ID
	 * 
	 * @return apiId
	 **/
	public String getApiId() {
		return apiId;
	}

	public void setApiId(String apiId) {
		this.apiId = apiId;
	}

	/**
	 * API version - for HTTP based request this will be same as used in path
	 * 
	 * @return ver
	 **/

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	/**
	 * time in epoch
	 * 
	 * @return ts
	 **/

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}

	/**
	 * API action to be performed like _create, _update, _search (denoting POST,
	 * PUT, GET) or _oauth etc
	 * 
	 * @return action
	 **/

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * Device ID from which the API is called
	 * 
	 * @return did
	 **/
	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	/**
	 * API key (API key provided to the caller in case of server to server
	 * communication)
	 * 
	 * @return key
	 **/

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Unique request message id from the caller
	 * 
	 * @return msgId
	 **/
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	/**
	 * UserId of the user calling
	 * 
	 * @return requesterId
	 **/

	public String getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(String requesterId) {
		this.requesterId = requesterId;
	}

	/**
	 * //session/jwt/saml token/oauth token - the usual value that would go into
	 * HTTP bearer token
	 * 
	 * @return authToken
	 **/
	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	/**
	 * Get userInfo
	 * 
	 * @return userInfo
	 **/

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * Get correlationId
	 * 
	 * @return correlationId
	 **/
	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RequestInfo requestInfo = (RequestInfo) o;
		return Objects.equals(this.apiId, requestInfo.apiId)
				&& Objects.equals(this.ver, requestInfo.ver)
				&& Objects.equals(this.ts, requestInfo.ts)
				&& Objects.equals(this.action, requestInfo.action)
				&& Objects.equals(this.did, requestInfo.did)
				&& Objects.equals(this.key, requestInfo.key)
				&& Objects.equals(this.msgId, requestInfo.msgId)
				&& Objects.equals(this.requesterId, requestInfo.requesterId)
				&& Objects.equals(this.authToken, requestInfo.authToken)
				&& Objects.equals(this.userInfo, requestInfo.userInfo)
				&& Objects.equals(this.correlationId,
						requestInfo.correlationId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(apiId, ver, ts, action, did, key, msgId,
				requesterId, authToken, userInfo, correlationId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RequestInfo {\n");

		sb.append("    apiId: ").append(toIndentedString(apiId)).append("\n");
		sb.append("    ver: ").append(toIndentedString(ver)).append("\n");
		sb.append("    ts: ").append(toIndentedString(ts)).append("\n");
		sb.append("    action: ").append(toIndentedString(action)).append("\n");
		sb.append("    did: ").append(toIndentedString(did)).append("\n");
		sb.append("    key: ").append(toIndentedString(key)).append("\n");
		sb.append("    msgId: ").append(toIndentedString(msgId)).append("\n");
		sb.append("    requesterId: ").append(toIndentedString(requesterId))
				.append("\n");
		sb.append("    authToken: ").append(toIndentedString(authToken))
				.append("\n");
		sb.append("    userInfo: ").append(toIndentedString(userInfo))
				.append("\n");
		sb.append("    correlationId: ").append(toIndentedString(correlationId))
				.append("\n");
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
