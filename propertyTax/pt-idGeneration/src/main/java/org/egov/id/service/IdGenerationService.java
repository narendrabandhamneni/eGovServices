package org.egov.id.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.egov.id.model.Attribute;
import org.egov.id.model.IdGenerationRequest;
import org.egov.id.model.IdRequest;
import org.egov.id.model.IdResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

@Service
public class IdGenerationService {

	@Autowired
	DataSource dataSource;

	@Autowired
	private Environment environment;

	public String generateId(IdGenerationRequest idGenReq) {

		IdRequest idRequest = idGenReq.getIdRequest();
		List<Attribute> attributes = new ArrayList<Attribute>(idRequest.getAttributes());
		IdResultSet resultSet = new IdResultSet();
		//connection and prepared statement
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		String generatedId = null;
		try{
			conn = DataSourceUtils.getConnection(dataSource);
			conn.setAutoCommit(false);
			//select the id type from the id generation table 
			String idSelectQuery = "SELECT * FROM " + environment.getProperty("idTypeTable")  + " WHERE (idtype=? and entity=? and tenentid=?) FOR UPDATE";
			pst = conn.prepareStatement(idSelectQuery);
			pst.setString(1,idRequest.getIdType());
			pst.setString(2,idRequest.getEntity());
			pst.setString(3,idRequest.getTenentId());
			rs = pst.executeQuery();
			while(rs.next()){
				resultSet.setTenentid(rs.getString("tenentid"));
				resultSet.setCurrentseqnum(rs.getString("currentseqnum"));
				resultSet.setEntity(rs.getString("entity"));
				resultSet.setId(rs.getString("id"));
				resultSet.setIdtype(rs.getString("idtype"));
				resultSet.setRegex(rs.getString("regex"));
			}
			generatedId = ValidateAttributesAndGetId(attributes, resultSet);
			//updating the sequence number of the id type
			String idUpdateQuery = "UPDATE  " + environment.getProperty("idTypeTable")  + " SET currentseqnum=? WHERE (idtype=? and entity=? and tenentid=?)";
			pst = conn.prepareStatement(idUpdateQuery);
			pst.setInt(1,Integer.parseInt(resultSet.getCurrentseqnum())+1);
			pst.setString(2,idRequest.getIdType());
			pst.setString(3,idRequest.getEntity());
			pst.setString(4,idRequest.getTenentId());
			pst.executeUpdate();
			//committing the transaction
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return generatedId;

	}

	//method to check the attribute exists or not
	public boolean containsAttribute(List<Attribute> attributeList, String key) {

		for (Attribute attribute : attributeList) {
			if (attribute.getKey().equals(key)) {
				return true;
			}
		}
		return false;

	}

	//method to generate random text
	public String generateRandomText(){

		Random random = new Random();
		int k = random.nextInt(25)+65;
		int l = random.nextInt(25)+65;
		String randomTxt = Character.toString((char) k)+(char)l;
		return randomTxt;

	}

	//method to validate the attributes and returns the generated id
	public String ValidateAttributesAndGetId( List<Attribute> attributes, IdResultSet resultSet ){

		String regex = resultSet.getRegex();
		List<String> matchList = new ArrayList<String>();
		Pattern regExpPattern = Pattern.compile("\\{(.*?)\\}");
		Matcher regexMatcher = regExpPattern.matcher(regex);
		while (regexMatcher.find()) {//Finds Matching Pattern in String
			matchList.add(regexMatcher.group(1));//Fetching Group from String
		}
		for(String str:matchList) {
			if(str.equalsIgnoreCase("randNo") || str.equalsIgnoreCase("seqNumber")){
				if(str.equalsIgnoreCase("randNo")){
					regex = regex.replace("{randNo}", generateRandomText());
				} else {
					regex = regex.replace("{seqNumber}", resultSet.getCurrentseqnum());
				}
			} else {
				if(containsAttribute(attributes, str)){
					for(Attribute a:attributes){  
						if(a.getKey().equalsIgnoreCase(str)){
							regex = regex.replace("{"+str+"}", a.getValue());
						} 
					}
				} else {
					//throw the exception for attribute not found
					throw new IllegalStateException("attribute "+ str +" Not found");
				}
			}
		}
		return regex.toString().toUpperCase();

	}
}
