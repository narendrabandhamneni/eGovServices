package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * ResponseInfo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseInfo   {
  
  @NonNull	
  private String apiId;

  @NonNull
  private String ver;

  @NonNull
  private String ts;

  private String resMsgId;

 
  private String msgId;

 @NonNull
  private String status;

 
}

