package com.freelance.freelancebackend.exception;

import com.freelance.freelancebackend.Constants;

public class ResourceEmptyException extends RuntimeException{

    public ResourceEmptyException(String resource) {
        super(resource + Constants.EMPTY);
    }

}
