package com.google.evochko.model;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String status;
    private String message;
    private double result;

    public Message()    {
        super();
    }

    public Message(int code, String status, String message, double result)    {
        this();
        this.code = code;
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public Message(Status status, String message, double result)    {
        this(status.getCode(), status.getValue(), message, result);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
