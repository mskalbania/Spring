package com.springsecurity.config;

public class UserResponse {

    private boolean success;
    private String errorMessage;

    public UserResponse() {
        this.success = true;
    }

    public UserResponse(String errorMessage) {
        this.success = false;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
