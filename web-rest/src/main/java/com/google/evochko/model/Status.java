package com.google.evochko.model;

public enum Status {
    OK(0, "OK"),
    ERROR(1001, "ERROR");

    private int code;
    private String value;

    private Status(int code, String status) {
        this.code = code;
        this.value = status;
    }

    public int getCode() {
        return code;
    }

    public String getValue()    {
        return value;
    }
}
