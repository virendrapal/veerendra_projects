package com.test.app.viewObject;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Response {
	
	private String statusDesc;
	private int statusCode;
	private Object responseObj;
	
	
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getResponseObj() {
		return responseObj;
	}
	public void setResponseObj(Object responseObj) {
		this.responseObj = responseObj;
	}
	@Override
	public String toString() {
		return "Response [statusDesc=" + statusDesc + ", statusCode="
				+ statusCode + ", responseObj=" + responseObj + "]";
	}
	 
	 

}
