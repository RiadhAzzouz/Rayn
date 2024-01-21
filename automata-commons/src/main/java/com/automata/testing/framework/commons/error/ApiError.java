package com.automata.testing.framework.commons.error;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Model representation of error in this API.
 * 
 * @author GELIBERT
 */
@Data
@AllArgsConstructor
@Builder
public class ApiError {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    /**
     * Http Status.
     */
    private HttpStatus status;

    /**
     * Timestamp of the error.
     */
    private final LocalDateTime timestamp;

    /**
     * Message Error.
     */
    private String message;

    /**
     * Error code.
     */
    private String errorCode;

    /**
     * detailed message.
     */
    private String detailedMessage;

    /**
     * SubErrors (possible nesting).
     */
    private List<ApiValidationError> subErrors;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor
    /**
     * Private constructor.
     */
    private ApiError() {
	this.timestamp = LocalDateTime.now();
    }

    /**
     * Default constructor.
     *
     * @param status
     *               httpstatus
     */
    public ApiError(HttpStatus status) {
      this();
      this.status = status;
    }

    /**
     * Exception constructor.
     *
     * @param status
     *               http status
     * @param ex
     *               exception
     */
    public ApiError(HttpStatus status, Throwable ex) {
      this();
      this.status = status;
      this.message = "Unexpected error";
      if (ex != null) {
          this.detailedMessage = ex.getLocalizedMessage();
      }
    }

    /**
     * Complete constructor.
     *
     * @param status
     *                  http status
     * @param message
     *                  message information
     * @param errorCode
     *                  error code
     * @param ex
     *                  exception
     */
    public ApiError(HttpStatus status, String message, String errorCode, Throwable ex) {
      this();
      this.status = status;
      this.message = message;
      this.errorCode = errorCode;
      if (ex != null) {
          this.detailedMessage = ex.getLocalizedMessage();
      }
    }

    /**
     * Complete constructor.
     *
     * @param status
     *                  http status
     * @param message
     *                  message information
     * @param subErrors
     *                  subErrors
     * @param errorCode
     *                  error code
     * @param ex
     *                  exception
     */
    public ApiError(HttpStatus status, String message, String errorCode, Throwable ex,
	    List<ApiValidationError> subErrors) {
	this(status, message, errorCode, ex);
	this.subErrors = subErrors;
    }

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
