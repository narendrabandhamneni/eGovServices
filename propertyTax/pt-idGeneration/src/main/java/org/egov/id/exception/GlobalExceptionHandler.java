package org.egov.id.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.models.Error;
import org.egov.models.ErrorRes;
import org.egov.models.IDSeqNotFoundException;
import org.egov.models.IDSeqOverflowException;
import org.egov.models.InvalidIDFormatException;
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

@RestControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	Environment environment;

	/**
	 * Description : MethodArgumentNotValidException type exception handler
	 * 
	 * @param ex
	 * @return
	 */

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorRes processValidationError(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<String, String>();
		for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}

		Error error = new Error(HttpStatus.BAD_REQUEST.toString(),
				environment.getProperty("invalid.input"), null, errors);
		List<Error> errorList = new ArrayList<Error>();
		errorList.add(error);
		ResponseInfo responseInfo = new ResponseInfo();
		responseInfo.setStatus(StatusEnum.FAILED.toString());
		return new ErrorRes(responseInfo, errorList);
	}

	/**
	 * Description : General exception handler method
	 * 
	 * @param ex
	 * @param req
	 * @return
	 */
	@ExceptionHandler(value = {Exception.class})
	public ErrorRes unknownException(Exception ex, WebRequest req) {
		if (ex instanceof InvalidIDFormatException) {
			Error error = new Error(HttpStatus.BAD_REQUEST.toString(),
					((InvalidIDFormatException) ex).getCustomMsg(), null,
					new HashMap<String, String>());
			ResponseInfo responseInfo = new ResponseInfo();
			responseInfo.setApiId(((InvalidIDFormatException) ex)
					.getRequestInfo().getApiId());
			responseInfo.setVer(
					((InvalidIDFormatException) ex).getRequestInfo().getVer());
			responseInfo.setMsgId(((InvalidIDFormatException) ex)
					.getRequestInfo().getMsgId());
			responseInfo.setTs(new Date().getTime());
			responseInfo.setStatus(StatusEnum.FAILED.toString());
			List<Error> errorList = new ArrayList<Error>();
			errorList.add(error);
			return new ErrorRes(responseInfo, errorList);
		} else if (ex instanceof IDSeqOverflowException) {
			Error error = new Error(HttpStatus.BAD_REQUEST.toString(),
					((IDSeqOverflowException) ex).getCustomMsg(), null,
					new HashMap<String, String>());
			ResponseInfo responseInfo = new ResponseInfo();
			responseInfo.setApiId(
					((IDSeqOverflowException) ex).getRequestInfo().getApiId());
			responseInfo.setVer(
					((IDSeqOverflowException) ex).getRequestInfo().getVer());
			responseInfo.setMsgId(
					((IDSeqOverflowException) ex).getRequestInfo().getMsgId());
			responseInfo.setTs(new Date().getTime());
			responseInfo.setStatus(StatusEnum.FAILED.toString());
			List<Error> errorList = new ArrayList<Error>();
			errorList.add(error);
			return new ErrorRes(responseInfo, errorList);
		} else if (ex instanceof IDSeqNotFoundException) {
			Error error = new Error(HttpStatus.BAD_REQUEST.toString(),
					((IDSeqNotFoundException) ex).getCustomMsg(), null,
					new HashMap<String, String>());
			ResponseInfo responseInfo = new ResponseInfo();
			responseInfo.setApiId(
					((IDSeqNotFoundException) ex).getRequestInfo().getApiId());
			responseInfo.setVer(
					((IDSeqNotFoundException) ex).getRequestInfo().getVer());
			responseInfo.setMsgId(
					((IDSeqNotFoundException) ex).getRequestInfo().getMsgId());
			responseInfo.setTs(new Date().getTime());
			responseInfo.setStatus(StatusEnum.FAILED.toString());
			List<Error> errorList = new ArrayList<Error>();
			errorList.add(error);
			return new ErrorRes(responseInfo, errorList);
		} else {
			Error error = new Error(HttpStatus.BAD_REQUEST.toString(),
					ex.getMessage(), null, new HashMap<String, String>());
			ResponseInfo responseInfo = new ResponseInfo();
			responseInfo.setStatus(environment.getProperty("failed"));
			List<Error> errorList = new ArrayList<Error>();
			errorList.add(error);
			return new ErrorRes(responseInfo, errorList);
		}
	}

}
