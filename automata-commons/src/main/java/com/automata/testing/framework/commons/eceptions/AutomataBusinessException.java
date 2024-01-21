package com.automata.testing.framework.commons.eceptions;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Dependencies
 */

/**
 * Automata Business exception.
 * 
 * @author GELIBERT
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AutomataBusinessException extends Exception {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    /**
     * Serial Version ID.
     */
    private static final long serialVersionUID = 7449070504704185037L;

    // -------------------------------------- private attributes

    /**
     * Error code.
     */
    private String errorCode;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    /**
     * Default Constructor.
     */
    public AutomataBusinessException(String errorCode, String message, Throwable cause) {
      super(message, cause);
      this.errorCode = errorCode;
    }

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
