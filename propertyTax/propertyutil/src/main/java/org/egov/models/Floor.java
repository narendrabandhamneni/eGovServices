package org.egov.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Floor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Floor   {
  @NonNull
  private String id;

  @NonNull
  private String floorNo;

  
  private String unitNo;

 
  private String type;

  
  private Double length;

  
  private Double width;

  @NonNull
  private Double builtupArea;

  
  private Double assessableArea;

  
  private Double bpaBuiltupArea;

  
  private String category;

 @NonNull
  private String usage;

  @NonNull
  private String occupancy;

  @NonNull
  private String structure;

  
  private String depreciation;

  
  private String occupierName;

  
  private String firmName;

  
  private Double rentCollected;

  
  private String exemptionReason;

  
  private Boolean isStructured;

 
  private LocalDate occupancyDate;

  
  private LocalDate constCompletionDate;

  
  private String bpaNo;

  
  private LocalDate bpaDate;

  
  private Double manualArv;

  
  private Double arv;

  
  private String electricMeterNo;

  
  private String waterMeterNo;

  
  private Integer createdBy;

  
  private LocalDate createdDate;

  private Integer lastModifiedBy;

  
  private LocalDate lastModifiedDate;

  
  private String tenantId;

}

