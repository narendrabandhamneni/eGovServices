package org.egov.id.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.egov.id.model.IdResultSet;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class IdResultSetRowMapper implements RowMapper {
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		IdResultSet idResultSet = new IdResultSet();
		idResultSet.setTenentid(rs.getString("tenentid"));
		idResultSet.setCurrentseqnum(rs.getString("currentseqnum"));
		idResultSet.setEntity(rs.getString("entity"));
		idResultSet.setId(rs.getString("id"));
		idResultSet.setIdtype(rs.getString("idtype"));
		idResultSet.setRegex(rs.getString("regex"));

		return idResultSet;
	}
	
}
