package com.br.Pokando.exception;

import com.br.Pokando.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ApiResponse> handleNotFound(ResourceNotFoundException ex) {
    return new ResponseEntity<>(
            new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase()),
            HttpStatus.NOT_FOUND
    );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse> handleGeneric(Exception ex) {
    return new ResponseEntity<>(
            new ApiResponse("Erro interno: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),
            HttpStatus.INTERNAL_SERVER_ERROR
    );
  }
}