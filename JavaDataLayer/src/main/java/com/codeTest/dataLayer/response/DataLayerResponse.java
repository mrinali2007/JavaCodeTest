package com.codeTest.dataLayer.response;

public class DataLayerResponse {
  public String message;
  public boolean success = false;
  public long result;

  public DataLayerResponse(String message, boolean success, long result) {
    this.message = message;
    this.success = success;
    this.result = result;
  }

  public long getResult() {
    return result;
  }

  public void setResult(long result) {
    this.result = result;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }


}
