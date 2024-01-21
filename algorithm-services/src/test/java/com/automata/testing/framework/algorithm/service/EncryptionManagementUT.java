package com.automata.testing.framework.algorithm.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2021
 */

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.automata.testing.framework.algorithm.service.EncrypteRotation13ServiceImpl;
import com.automata.testing.framework.algorithm.service.IDecryptionService;
import com.automata.testing.framework.algorithm.service.IEncryptionService;

/**
 * Dependencies
 */

/**
 * Unit test for algorithms.
 * 
 * @author GELIBERT
 */
@SpringBootTest(classes = ApplicationTest.class)
class EncryptionManagementUT {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes
    
    /**
     * Encryption service to use.
     */
    @Autowired
    private IEncryptionService encryptionService;
    
    /**
     * Decryption service to use.
     */
    @Autowired
    private IDecryptionService decryptionService;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods
    
    /**
     * Testing the ROT 13 Algorithm.
     */
    @Test
    void iDontKnowTest() {
	
      // Testing with data ABC, that should be changed in NOP
      String res = encryptionService.encode("ABC");

      Assertions.assertEquals("NOP", res);

      res = encryptionService.encode("XYZ");
      Assertions.assertEquals("efg", res);
    }
    
    /**
     * Testing Synchronous encoding and decoding.
     */
    @Test
    void iDontKnowTest2() {
      // Testing the decoding algorithm.
      String toTest = RandomStringUtils.randomAlphabetic(30).toUpperCase();
      String encodedToTest = encryptionService.encode(toTest);
      String decodedToTest = decryptionService.decode(encodedToTest);
      Assertions.assertEquals(toTest, decodedToTest);
    }

    @Test
    void permutationPairTest() {
      String input = "KAYA";
      String encodedToTest = encryptionService.permutation(input);
      Assertions.assertEquals("AKAY", encodedToTest);
    }

  @Test
  void permutationImpairTest() {
    String input = "KAYAK";
    String encodedToTest = encryptionService.permutation(input);
    Assertions.assertEquals("AKAYX", encodedToTest);
  }

    // -------------------------------------- Setters and Getters

}
