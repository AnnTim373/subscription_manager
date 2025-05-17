package org.timofeeva.subman.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.timofeeva.subman.dto.output.ErrorOutput;
import org.timofeeva.subman.error.custom_exception.SubManException;

import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionTranslator {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorOutput> handleException(Exception ex) {
        log.error("Unknown error: {}", ex.getMessage());
        return create("Неизвестная ошибка при обработке запроса", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorOutput> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String errorsText = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return create(errorsText, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SubManException.class)
    public ResponseEntity<ErrorOutput> handleLoadingDataException(SubManException ex) {
        return create(ex.getMessage(), ex.getStatusCode());
    }

    private ResponseEntity<ErrorOutput> create(String message, HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(new ErrorOutput(message));
    }

}
