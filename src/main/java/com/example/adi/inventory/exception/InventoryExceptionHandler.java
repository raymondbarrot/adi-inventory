package com.example.adi.inventory.exception;

import com.example.adi.inventory.model.InventoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@ControllerAdvice
public class InventoryExceptionHandler {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<?> missingParameter(SQLIntegrityConstraintViolationException e) {
        InventoryResponse response = InventoryResponse.builder()
                .reason(e.getLocalizedMessage())
                .status("Failed")
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
