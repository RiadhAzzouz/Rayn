package com.automata.testing.framework.user.controller;
/*
 * Copyright: Copyright (c) Automata akt.io 2021
 */

import com.automata.testing.framework.commons.eceptions.AutomataBusinessException;
import com.automata.testing.framework.user.dto.UserSignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automata.testing.framework.user.dto.UserDTO;
import com.automata.testing.framework.user.service.IUserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Dependencies
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    /**
     * The user Service.
     */
    @Autowired
    private IUserService userService;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    /**
     * Rest API for the creation of the user.
     * 
     * @param user
     *             the user
     * @return the response entity
     */
    @PostMapping(path = "/user")
    public ResponseEntity<String> createUser(@RequestBody UserSignupDTO user) {
      log.debug("Receiving the user {}", user);
      userService.createUser(user);
      return ResponseEntity.ok().build();
    }

  @DeleteMapping(path = "/user/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable int id) throws AutomataBusinessException {
    log.debug("Deleting user {}", id);
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
  }

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
