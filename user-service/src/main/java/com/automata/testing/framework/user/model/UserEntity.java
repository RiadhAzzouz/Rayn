package com.automata.testing.framework.user.model;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Dependencies
 */
@Entity
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    /**
     * The ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    /**
     * The user password.
     */
    private String password;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
