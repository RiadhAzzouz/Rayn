package com.automata.testing.framework.commons.error;

/**
 * Dependencies
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Validation Error.
 *
 * @author rgelibert
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ApiValidationError implements IApiSubError {

    /**
     * Object Error.
     */
    private String object;

    /**
     * Field error.
     */
    private String field;

    /**
     * Value rejected.
     */
    private Object rejectedValue;

    /**
     * Message.
     */
    private String message;

}