package org.egov.property.exception;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.models.AttributeNotFoundException;
import org.egov.models.Error;
import org.egov.models.ErrorRes;
import org.egov.models.ResponseInfo;
import org.egov.models.ResponseInfo.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Description : Global exception handler for property module
 * @author Narendra
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private Environment environment;
	
	/**
	 * Description : MethodArgumentNotValidException type exception handler
	 * @param ex
	 * @return
	 */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorRes processValidationError(MethodArgumentNotValidException ex) {
    	Map<String,String> errors=new HashMap<String,String>();
    	for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
             errors.put(error.getField(),error.getDefaultMessage());
         }
    	
    	Error error=new Error(HttpStatus.BAD_REQUEST.toString(),environment.getProperty("invalid.input"),null,errors);
		List<Error> errorList=new ArrayList<Error>();
		errorList.add(error);
    	ResponseInfo responseInfo=new ResponseInfo();
		responseInfo.setStatus(StatusEnum.FAILED.toString());
		return new ErrorRes(responseInfo,errorList);		
		}
    
    /**
     * Description : General exception handler method
     * @param ex
     * @param req
     * @return
     */
    
	@ExceptionHandler(value = { Exception.class })

	public ErrorRes unknownException(Exception ex, WebRequest req) {
		if(ex instanceof InvalidInputException){
			Error error=new Error(HttpStatus.BAD_REQUEST.toString(),environment.getProperty("invalid.input"),null,null);
			ResponseInfo responseInfo=new ResponseInfo();
			responseInfo.setApiId(((InvalidInputException)ex).getRequestInfo().getApiId());
			responseInfo.setVer(((InvalidInputException)ex).getRequestInfo().getVer());
			responseInfo.setMsgId(((InvalidInputException)ex).getRequestInfo().getMsgId());
			responseInfo.setTs(new Date().getTime());
			responseInfo.setStatus(StatusEnum.FAILED.toString());
			List<Error> errorList=new ArrayList<Error>();
			errorList.add(error);
			return new ErrorRes(responseInfo,errorList);		}
		else if(ex instanceof InvalidPropertyBoundaryException){
			Error error=new Error(HttpStatus.BAD_REQUEST.toString(),environment.getProperty("invalid.property.boundary"),null,new HashMap<String,String>());
			ResponseInfo responseInfo=new ResponseInfo();
			responseInfo.setApiId(((InvalidPropertyBoundaryException)ex).getRequestInfo().getApiId());
			responseInfo.setVer(((InvalidPropertyBoundaryException)ex).getRequestInfo().getVer());
			responseInfo.setMsgId(((InvalidPropertyBoundaryException)ex).getRequestInfo().getMsgId());
			responseInfo.setTs(new Date().getTime());
			responseInfo.setStatus(StatusEnum.FAILED.toString());
			List<Error> errorList=new ArrayList<Error>();
			errorList.add(error);
			responseInfo.setStatus(StatusEnum.FAILED.toString());
			return new ErrorRes(responseInfo,errorList);
		}
		else if(ex instanceof AttributeNotFoundException){
			Error error=new Error(HttpStatus.BAD_REQUEST.toString(),environment.getProperty("invalid.input"),environment.getProperty("attribute.notfound"),new HashMap<String,String>());
			ResponseInfo responseInfo=new ResponseInfo();
			responseInfo.setApiId(((AttributeNotFoundException)ex).getRequestInfo().getApiId());
			responseInfo.setVer(((AttributeNotFoundException)ex).getRequestInfo().getVer());
			responseInfo.setMsgId(((AttributeNotFoundException)ex).getRequestInfo().getMsgId());
			responseInfo.setTs(new Date().getTime());
			responseInfo.setStatus(StatusEnum.FAILED.toString());
			List<Error> errorList=new ArrayList<Error>();
			errorList.add(error);
			return new ErrorRes(responseInfo,errorList);
		}
		
		else if(ex instanceof InvalidUpdatePropertyException){
			Error error=new Error(HttpStatus.BAD_REQUEST.toString(),((InvalidUpdatePropertyException) ex).getCustomMsg(),null,new HashMap<String,String>());
			ResponseInfo responseInfo=new ResponseInfo();
			responseInfo.setApiId(((InvalidUpdatePropertyException)ex).getRequestInfo().getApiId());
			responseInfo.setVer(((InvalidUpdatePropertyException)ex).getRequestInfo().getVer());
			responseInfo.setMsgId(((InvalidUpdatePropertyException)ex).getRequestInfo().getMsgId());
			responseInfo.setTs(new Date().getTime());
			responseInfo.setStatus(StatusEnum.FAILED.toString());
			List<Error> errorList=new ArrayList<Error>();
			errorList.add(error);
			return new ErrorRes(responseInfo,errorList);
		}
		
		else if (ex instanceof PropertySearchException){
			Error error=new Error(HttpStatus.BAD_REQUEST.toString(),environment.getProperty("invalid.input"),null,null);
			ResponseInfo responseInfo=new ResponseInfo();
			responseInfo.setApiId(((PropertySearchException)ex).getRequestInfo().getApiId());
			responseInfo.setVer(((PropertySearchException)ex).getRequestInfo().getVer());
			responseInfo.setMsgId(((PropertySearchException)ex).getRequestInfo().getMsgId());
			responseInfo.setTs(new Date().getTime());
			responseInfo.setStatus(StatusEnum.FAILED.toString());
			List<Error> errorList=new ArrayList<Error>();
			errorList.add(error);
			return new ErrorRes(responseInfo,errorList);
			
		}
		
		else{
			Error error=new Error(HttpStatus.INTERNAL_SERVER_ERROR.toString(),ex.getMessage(),null,new HashMap<String,String>());
			ResponseInfo responseInfo=new ResponseInfo();
			responseInfo.setStatus(StatusEnum.FAILED.toString());
			List<Error> errorList=new ArrayList<Error>();
			errorList.add(error);
			return new ErrorRes(responseInfo,errorList);
		}

	}

	

}
