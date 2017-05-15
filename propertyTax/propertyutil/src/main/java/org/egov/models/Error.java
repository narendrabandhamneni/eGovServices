package org.egov.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Error
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Error   {
  
  private String code;

  
  private String message;

 
  private String description;

 
  private Object filelds;

}

