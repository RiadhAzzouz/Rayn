package com.automata.testing.framework.user.repository;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import java.util.Optional;

/**
 * Dependencies
 */

import org.springframework.data.repository.CrudRepository;

import com.automata.testing.framework.user.model.UserEntity;

/**
 * The user repository, used to store data and manipulate it.
 * 
 * @author GELIBERT
 */
public interface IUserRepository extends CrudRepository<UserEntity, Integer> {

    // -------------------------------------- Public methods

    Optional<UserEntity> findByEmailAddress(String string);

}
