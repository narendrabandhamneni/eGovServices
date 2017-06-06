package org.egov.models;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <h1>PropertyLocation</h1>
 * @author Narendra
 *
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PropertyLocation {

	private Boundary revenueBoundary;

	private Boundary locationBoundary;

	private Boundary adminBoundary;

	@Size(min=1, max=256)
	private String northBoundedBy;

	@Size(min=1, max=256)
	private String eastBoundedBy;

	@Size(min=1, max=256)
	private String westBoundedBy;

	@Size(min=1, max=256)
	private String southBoundedBy;

	/**
	 * Description : This is to get the searchType fields of the target class
	 * @author Narendra
	 * @param target
	 * @param searchType
	 * @return result
	 */
	public List<String> getFieldsOfType(Class<?> target, Class<?> searchType) {

		Field[] fields  = target.getDeclaredFields();
		List<String> result = new ArrayList<String>();

		for(Field field:fields){
			if(field.getType().equals(searchType)){
				result.add(searchType.getName());
			}
		}
		return result;
	}

	/**
	 * Description : This is to get the BoundaryType fields of the PropertyLocation class
	 * @author Narendra
	 * @return List<String>
	 */
	public List<String> getAllBoundaries(){
		return getFieldsOfType(PropertyLocation.class, Boundary.class); 
	}

}
