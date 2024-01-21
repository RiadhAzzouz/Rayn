package com.automata.testing.framework.algorithm.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2021
 */

/**
 * Dependencies
 */

/**
 * This interface describe the multiple algorithms we have to encrypt some
 * datas.
 * 
 * @author GELIBERT
 */
public interface IEncryptionService {

    // -------------------------------------- Public methods

    /**
     * encode an input depending on the algorithme we want to use.
     * 
     * @param input
     *              the input to encrypt
     * @return the result of the encryption.
     */
    String encode(String input);
    String permutation(String input);

}
