package com.google.evochko.exceptions;

import java.util.List;

public class InvalidParameters extends AppException {
    public InvalidParameters(String msg) {
        super(msg);
    }

    public InvalidParameters(List<String> invalidKeys) {
        super("Invalid numbers in " + invalidKeys);
    }
}
