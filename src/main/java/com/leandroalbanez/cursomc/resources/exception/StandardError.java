package com.leandroalbanez.cursomc.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private Integer status;
    private String message;
    private Long timestamp;

    public StandardError(int status, String message, Long timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
