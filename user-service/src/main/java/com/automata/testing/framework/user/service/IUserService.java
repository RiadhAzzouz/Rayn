package com.automata.testing.framework.user.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import com.automata.testing.framework.commons.eceptions.AutomataBusinessException;
import com.automata.testing.framework.user.dto.UserSignupDTO;

/**
 * Dependencies
 */

/**
 * The interface for a user service.
 * 
 * @author GELIBERT
 */
public interface IUserService {

    // -------------------------------------- Public methods

    /**
     * Create a new user.
     * 
     * @param user
     *             the user to create.
     */
    void createUser(UserSignupDTO user);
    void deleteUser(int userId) throws AutomataBusinessException;

}
