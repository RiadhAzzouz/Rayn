package com.automata.testing.framework.post.model;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import java.io.Serializable;

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

/**
 * The entity model for a post.
 * 
 * @author GELIBERT
 */
@Entity
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity implements Serializable {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    /**
     * Serial Version Id.
     */
    private static final long serialVersionUID = -592959605537059071L;

    // -------------------------------------- private attributes

    /**
     * The post Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The post content.
     */
    private String content;

    /**
     * The user id.
     */
    private String userId;

    /**
     * The user first name.
     */
    private String userFirstName;

    /**
     * The user last name.
     */
    private String userLastName;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
