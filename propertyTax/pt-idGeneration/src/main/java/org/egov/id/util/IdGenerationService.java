package org.egov.id.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.egov.models.IdRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

/**
 * Description : IdGenerationService have methods related to the IdGeneration
 * @author Pavan Kumar Kamma
 */
@Service
public class IdGenerationService {

	@Autowired
	DataSource dataSource;

	/**
	 * Description : This method to generate Id when format is unknown
	 * @return generatedId
	 */
	public String getGeneratedId(IdRequest idRequest) throws Exception {
		String IdFormat = getIdFormat(idRequest);
		idRequest.setFormat(IdFormat);
		String generatedId = getFormattedId(idRequest);
		return generatedId;
	}
	
	/**
	 * Description : This method to retrieve Id format
	 * @return idFormat
	 */
	public String getIdFormat(IdRequest idRequest) throws Exception {
		//connection and prepared statement
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		String idFormat = null;
		try{
			conn = DataSourceUtils.getConnection(dataSource);
			conn.setAutoCommit(false);
			String idName = idRequest.getIdName();
			String tenantId = idRequest.getTenantId();
			//select the id format from the id generation table 
			StringBuffer idSelectQuery = new StringBuffer();
			idSelectQuery.append( "SELECT format FROM id_generator ")
			.append(" WHERE idname=? and tenantid=?");
			pst = conn.prepareStatement(idSelectQuery.toString());
			pst.setString(1,idName);
			pst.setString(2,tenantId);
			rs = pst.executeQuery();
			if(rs.next()){
				idFormat = rs.getString(1);
			} else {
				//querying for the id format with idname
				StringBuffer idNameQuery = new StringBuffer();
				idNameQuery.append( "SELECT format FROM id_generator ")
				.append(" WHERE idname=?");
				pst = conn.prepareStatement(idNameQuery.toString());
				pst.setString(1,idName);
				rs = pst.executeQuery();
				if(rs.next())
					idFormat = rs.getString(1);
			}	
			//committing the transaction
			conn.commit();
			conn.setAutoCommit(true);
		} finally{
			conn.close();
		}
		return idFormat;
	}
	
	/**
	 * Description : This method to generate Id when format is known
	 * @return Id
	 */
	
	public String getFormattedId(IdRequest idRequest) throws Exception{
		
		String idFormat = idRequest.getFormat();
		List<String> matchList = new ArrayList<String>();
		Pattern regExpPattern = Pattern.compile("\\[(.*?)\\]");
		Matcher regExpMatcher = regExpPattern.matcher(idFormat);
		while (regExpMatcher.find()) {//Finds Matching Pattern in String
			matchList.add(regExpMatcher.group(1));//Fetching Group from String
		}
		for(String attributeName:matchList) {
			if(matchList.get(0)==attributeName){
				idFormat = idFormat.replace("["+ attributeName +"]", generateDateFormat(attributeName));
			} else if(matchList.get(matchList.size()-1)==attributeName){
				idFormat = idFormat.replace("["+ attributeName +"]", generateRandomText());
			} else {
				idFormat = idFormat.replace("["+ attributeName +"]", generateSequenceNumber(attributeName));
			}
		}
		return idFormat.toString().toUpperCase();
	}
	
	/**
	 * Description : This method to generate date in given format
	 * @return formattedDate
	 */
	public String generateDateFormat(String dateFormat){
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		String formattedDate= formatter.format(date);
		return formattedDate;
	}
	
	/**
	 * Description : This method to generate random text
	 * @return randomTxt
	 */
	public String generateRandomText(){

		Random random = new Random();
		int randomNo = random.nextInt(25)+65;
		String randomTxt = ""+randomNo;
		return randomTxt;

	}
	
	/**
	 * Description : This method to generate sequence number
	 * @return strDate
	 */
	public String generateSequenceNumber(String sequenceName) throws Exception {
		
		String sequenceSql = "SELECT nextval('" + sequenceName + "')";
		//connection and prepared statement
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection conn = null;
		Long seqId = null;
		try{
			conn = DataSourceUtils.getConnection(dataSource);
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sequenceSql);
			rs = pst.executeQuery();
			if(rs.next())
				seqId = rs.getLong(1);
			
			//committing the transaction
			conn.commit();
			conn.setAutoCommit(true);
		} finally{
			conn.close();
		}
		StringBuilder seqNumber = new StringBuilder(String.format("%06d", seqId));
		return seqNumber.toString();
	}
}
