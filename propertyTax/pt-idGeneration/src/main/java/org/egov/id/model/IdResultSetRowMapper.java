package org.egov.id.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class IdResultSetRowMapper implements RowMapper 
{

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
