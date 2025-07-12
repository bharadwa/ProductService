package org.arcserve.productservice.controlleradvices;
import org.arcserve.productservice.dtos.ProductNotFoundExceptionDTO;
import org.arcserve.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> catchProductNotFoundException(ProductNotFoundException notFoundException) {
        ProductNotFoundExceptionDTO dto = new ProductNotFoundExceptionDTO();
        dto.setMessage(String.format("Product with id : %s not found", notFoundException.getErrorParams()));
        dto.setResolution("Please provide valid product");
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

}
