package com.automata.testing.framework.commons.error;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.automata.testing.framework.commons.eceptions.AutomataBusinessException;
import com.automata.testing.framework.commons.eceptions.AutomataTechnicalException;

/**
 * Default Rest Exception Handler. To modify the default print. <br >
 * It can handle every mistakes from th
 *
 * @author rgelibert
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    // -------------------------------------- private attributes

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    /**
     * Building Response Entity.
     *
     * @param apiError
     *                 error to print
     * @return the new entity.
     */
    private ResponseEntity<Object> buildResponseEntity(final ApiError apiError) {
	return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // -------------------------------------- Protected methods

    /**
     * Handle Access Denied Exception
     *
     * @param ex
     *                exception
     * @param request
     *                request
     * @return the object
     */
    @ExceptionHandler(value = { AccessDeniedException.class })
    protected ResponseEntity<Object> handleAccessDenied(final AccessDeniedException ex, final WebRequest request) {
	LOG.warn("Handling denied error : {}", ex.getMessage());
	return this.handleExceptionInternal(ex, new ApiError(HttpStatus.UNAUTHORIZED), new HttpHeaders(),
		HttpStatus.UNAUTHORIZED, request);
    }

    /**
     * Handle Spring validation exceptions Exceptions
     *
     * @param ex
     *                exception
     * @param request
     *                request
     * @return the object
     */
    @Override
    protected ResponseEntity<Object> handleBindException(final BindException ex, final HttpHeaders headers,
	    final HttpStatus status, final WebRequest request) {
	LOG.warn("Handling error : {}", ex.getMessage());
	return this.handleExceptionInternal(ex,
		new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), "SPRING_VALIDATION_EXCEPTION", ex),
		new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * Handle Business Exceptions
     *
     * @param ex
     *                exception
     * @param request
     *                request
     * @return the object
     */
    @ExceptionHandler(value = { AutomataBusinessException.class })
    protected ResponseEntity<Object> handleBusinessException(final AutomataBusinessException ex,
	    final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	LOG.warn("Handling error : {}", ex.getMessage());
	return this.handleExceptionInternal(ex,
		ApiError.builder().detailedMessage(ex.getLocalizedMessage()).errorCode(ex.getErrorCode())
			.message(ex.getMessage()).status(HttpStatus.BAD_REQUEST).timestamp(LocalDateTime.now()),
		new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * Handle Technical Exceptions
     *
     * @param ex
     *                exception
     * @param request
     *                request
     * @return the object
     */
    @ExceptionHandler(value = { AutomataTechnicalException.class })
    protected ResponseEntity<Object> handleBusinessException(final AutomataTechnicalException ex,
	    final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	LOG.warn("Handling error : {}", ex.getMessage());
	return this.handleExceptionInternal(ex,
		ApiError.builder().detailedMessage(ex.getLocalizedMessage()).message(ex.getMessage())
			.status(HttpStatus.INTERNAL_SERVER_ERROR).timestamp(LocalDateTime.now()),
		new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex,
	    final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
	LOG.warn("Handling Http error : {}", ex.getMessage());
	final String error = "Malformed JSON request";
	final String code = "GENERAL_001";
	return this.buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, code, ex));
    }

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
