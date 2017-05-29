package org.egov.property.exception;
import org.egov.models.ErrorRes;

import java.util.HashMap;

import org.egov.models.Error;
import org.egov.models.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private Environment environment;
	

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorRes processValidationError(MethodArgumentNotValidException ex) {
    	Error error=new Error(HttpStatus.BAD_REQUEST.toString(),ex.getMessage(),null,null);
		ResponseInfo responseInfo=new ResponseInfo();
		responseInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
		return new ErrorRes(responseInfo,error);		
		}
	@ExceptionHandler(value = { Exception.class })

	public ErrorRes unknownException(Exception ex, WebRequest req) {
		if(ex instanceof InvalidInputException){
			Error error=new Error(HttpStatus.BAD_REQUEST.toString(),environment.getProperty("invalidInput"),null,null);
			ResponseInfo responseInfo=new ResponseInfo();
			responseInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
			return new ErrorRes(responseInfo,error);		}
		else if(ex instanceof InvalidPropertyBoundaryException){
			Error error=new Error(HttpStatus.BAD_REQUEST.toString(),environment.getProperty("invalidPropertyBoundary"),null,new HashMap<String,String>());
			ResponseInfo responseInfo=new ResponseInfo();
			responseInfo.setStatus(HttpStatus.BAD_REQUEST.toString());
			return new ErrorRes(responseInfo,error);
		}
		else{
			Error error=new Error(HttpStatus.INTERNAL_SERVER_ERROR.toString(),ex.getMessage(),null,new HashMap<String,String>());
			ResponseInfo responseInfo=new ResponseInfo();
			responseInfo.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
			return new ErrorRes(responseInfo,error);
		}

	}

}
