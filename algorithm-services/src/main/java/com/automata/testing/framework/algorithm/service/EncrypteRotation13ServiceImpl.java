package com.automata.testing.framework.algorithm.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/*
 * Copyright: Copyright (c) Automata akt.io 2021
 */

/*
 * Dependencies
 */

/**
 * This is a very simple way to manage the encryption service.
 * 
 * @author GELIBERT
 */
@Service
@Slf4j
public class EncrypteRotation13ServiceImpl implements IEncryptionService {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes
    
    /**
     * Storing the last character we handled.
     */
    private String CHAR_RESULT = null;

    // -------------------------------------- private attributes

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods


    @Override
    public String encode(String input) {
			for (int i = 0; i <= input.toUpperCase().length(); i++ ) {
				if (i == 0) {
					continue;
				}
				char c = input.charAt(i - 1);
				char res = c;
				if (Character.isAlphabetic(c)) {
					res =  (char) (c + 13);
				}
				log.info("Result is {}", res);
				if (CHAR_RESULT == null) {
					CHAR_RESULT = "";
				}
				CHAR_RESULT = CHAR_RESULT + res;
			}
			String res = CHAR_RESULT;
			CHAR_RESULT = null;
			return res;
    }

		@Override
		public String permutation(String input) {

			char[] charArray = input.toCharArray();

			if (input.length() % 2 == 0) {
				for (int i = 0; i < charArray.length; i += 2) {
					char temp = charArray[i];
					charArray[i] = charArray[i + 1];
					charArray[i + 1] = temp;
				}
			} else {
				for (int i = 0; i < charArray.length - 1; i += 2) {
					char temp = charArray[i];
					charArray[i] = charArray[i + 1];
					charArray[i + 1] = temp;
				}
				char c = rot13(charArray[charArray.length-1]);
				charArray[charArray.length-1] = c;
			}

			return new String(charArray);
		}

		private char rot13(char c) {
			if (Character.isLetter(c)) {
				char base = Character.isUpperCase(c) ? 'A' : 'a';
				return (char) ((c - base + 13) % 26 + base);
			} else {
				return c;
			}
		}


    // -------------------------------------- Setters and Getters

}
