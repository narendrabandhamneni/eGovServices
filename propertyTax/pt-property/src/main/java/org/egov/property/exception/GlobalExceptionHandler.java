package org.egov.property.exception;
import org.egov.property.model.ApiErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private Environment environment;
	@ExceptionHandler(value = { Exception.class })
    
    public ApiErrorResponse unknownException(Exception ex, WebRequest req) {
		if(ex instanceof InvalidInputException){
			return new ApiErrorResponse(HttpStatus.BAD_REQUEST.toString(),environment.getProperty("invalidInput"),HttpStatus.BAD_REQUEST.toString());
		}
		else{
			return new ApiErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(),ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
        
    }

}
