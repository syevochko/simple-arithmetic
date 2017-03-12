package com.google.evochko.exceptions;

import com.google.evochko.model.Message;
import com.google.evochko.model.Status;

public class AppException extends Exception {
    protected Message exceptionMessage;

    public AppException(String msg) {
        super(msg);
        exceptionMessage = new Message(Status.ERROR, msg, 0);
    }

    public Message getExceptionMessage()    {return exceptionMessage;}
}
