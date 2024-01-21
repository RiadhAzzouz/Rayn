package com.automata.testing.framework.algorithm.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2021
 */

/**
 * Dependencies
 */

/**
 * This interface describe the multiple algorithms we have to decrypt some
 * datas.
 * 
 * @author GELIBERT
 */
public interface IDecryptionService {

    // -------------------------------------- Public methods

    /**
     * Decode the information into input in order to get the information.
     * 
     * @param input
     *              the input to decode
     * @return the result of the decryption.
     */
    String decode(String input);

}
