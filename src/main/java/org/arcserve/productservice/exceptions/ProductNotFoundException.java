package org.arcserve.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductNotFoundException extends RuntimeException{

    private String errorCode;

    private String [] errorParams;

    public ProductNotFoundException(String message) {
        super(message);
    }


    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(String message, String errorCode,String [] errorParams) {
        super(message);
        this.errorCode=errorCode;
        this.errorParams=errorParams;
    }
}
