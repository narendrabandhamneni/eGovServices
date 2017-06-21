package org.egov.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The floor details. The Floor contains either Flats in case of apartment or
 * Rooms in case of group or individual house.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Floor {

	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("floorNo")
	@NotNull
	@Size(min = 1, max = 16)
	private String floorNo = null;

	@JsonProperty("units")
	@Valid
	private List<Unit> units = new ArrayList<Unit>();

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;
}
