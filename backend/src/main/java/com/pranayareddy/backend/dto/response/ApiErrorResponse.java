package com.pranayareddy.backend.dto.response;

import java.time.Instant;

public class ApiErrorResponse {

    private boolean success;
    private String message;
    private Instant timestamp;
    private int status;
    private String error;
    private String path;

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(boolean success,
                            String message,
                            Instant timestamp,
                            int status,
                            String error,
                            String path) {
        this.success = success;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}