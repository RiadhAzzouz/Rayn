package com.automata.testing.framework.user.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */





/**
 * Dependencies
 */
import com.automata.testing.framework.algorithm.service.IEncryptionService;
import com.automata.testing.framework.commons.eceptions.AutomataBusinessException;
import com.automata.testing.framework.user.dto.UserSignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automata.testing.framework.user.dto.UserDTO;
import com.automata.testing.framework.user.model.UserEntity;
import com.automata.testing.framework.user.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;


/**
 * The Implementation of the service.
 * 
 * @author GELIBERT
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    @Autowired
    private IUserRepository repository;

    @Autowired
    private IEncryptionService encryptionService;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    @Override
    public void createUser(UserSignupDTO user) {
      log.info("Saving data for user {}", user);
      user.setPassword(encryptionService.encode(user.getPassword()));
      // We create the user in database.
      UserEntity savingUser = UserEntity.builder()
              .firstName(user.getFirstName())
              .lastName(user.getLastName())
              .emailAddress(user.getEmailAddress())
              .password(user.getPassword()).build();
      log.debug("Saving the user {}", user);
      repository.save(savingUser);
    }

    @Override
    public void deleteUser(int userId) throws AutomataBusinessException {
      log.info("deleting user {}", userId);
      Optional<UserEntity> user = repository.findById(userId);
      if (user.isPresent()) {
        repository.deleteById(userId);
      } else {
        throw new AutomataBusinessException("404", "USER_NOT_FOUND", null);
      }
    }

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    // -------------------------------------- Setters and Getters

}
