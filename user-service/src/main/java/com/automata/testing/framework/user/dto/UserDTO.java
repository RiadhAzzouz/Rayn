package com.automata.testing.framework.user.dto;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/*
 * Dependencies
 */

/**
 * Class representing a Data Transfer Object for a User.
 * 
 * @author GELIBERT
 */
@Data
@SuperBuilder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    /**
     * The user id.
     */
    private String userId;

    /**
     * The user first name.
     */
    private String firstName;

    /**
     * The user last name.
     */
    private String lastName;

    /**
     * The user email address.
     */
    private String emailAddress;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
