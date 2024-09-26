package com.wsu.workorderproservice.exception;

import com.wsu.workorderproservice.dto.ServiceResponseDTO;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.wsu.workorderproservice.utilities.Constants.ERROR_MESSAGE;
import static com.wsu.workorderproservice.utilities.Constants.MESSAGE;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ServiceResponseDTO> handleInvalidRequestException(InvalidRequestException e) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, e.getMessage())).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ServiceResponseDTO> handleInternalServerException(RuntimeException e) {
        return new ResponseEntity<>(ServiceResponseDTO.builder().meta(Map.of(MESSAGE, e.getMessage(), ERROR_MESSAGE, errorMessage(e))).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String errorMessage(RuntimeException e) {
        if (e.getCause() == null) {
            return "";
        }
        if (e.getCause().getCause() == null) {
            return e.getCause().getMessage();
        }
        return e.getCause().getMessage() + " " + e.getCause().getCause().getMessage();
    }

}
