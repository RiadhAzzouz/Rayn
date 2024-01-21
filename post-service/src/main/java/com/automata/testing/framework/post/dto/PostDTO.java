package com.automata.testing.framework.post.dto;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import java.io.Serializable;

import com.automata.testing.framework.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dependencies
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO implements Serializable {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    /**
     * Serial Version Id.
     */
    private static final long serialVersionUID = 7212070381547965352L;

    // -------------------------------------- private attributes

    /**
     * The post Id.
     */
    private Integer id;

    /**
     * The post content.
     */
    private String content;

    /**
     * The linked user for the post.
     */
    private UserDTO user;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
