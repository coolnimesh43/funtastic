package org.funtastic.pojo;

public class ResponsePOJO {

	private Boolean success;
	private String errorMessage;

	public ResponsePOJO(Boolean success, String errorMessage) {
		super();
		this.success = success;
		this.errorMessage = errorMessage;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
