package com.automata.testing.framework.user;

import com.automata.testing.framework.algorithm.service.IEncryptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.automata.testing.framework.user.dto.UserSignupDTO;
import com.automata.testing.framework.user.model.UserEntity;
import com.automata.testing.framework.user.repository.IUserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

/*
 * Copyright: Copyright (c) Automata akt.io 2021
 */

/**
 * Dependencies
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { RestTemplateAutoConfiguration.class,
	UserServiceApi.class })
@Slf4j
class UserControllerIT {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    /**
     * The rest template, used to generate api call.
     */
    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * The user repository, used to check datas.
     */
    @Autowired
    private IUserRepository userRepository;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    /**
     * Testing the user creation.
     */
    @Test
    void creationUserOkTest() {

			// User creation.
			UserSignupDTO user = UserSignupDTO.builder().firstName("Blaise").lastName("Pascal").emailAddress("blaise.pascal@gmail.com")
				.password("ABC").build();

			// sending the request.
			this.restTemplate.postForEntity("/api/user", user, String.class);

			Assertions.assertEquals(1, userRepository.count());
			// We get the user and we check the informations.
			UserEntity userSaved = this.userRepository.findByEmailAddress("blaise.pascal@gmail.com").get();
			log.info("The user saved is {}", userSaved);
			Assertions.assertEquals(user.getEmailAddress(), userSaved.getEmailAddress());
			Assertions.assertEquals(user.getFirstName(), userSaved.getFirstName());
			Assertions.assertEquals(user.getLastName(), userSaved.getLastName());
			Assertions.assertNotNull(userSaved.getId());
			// Password should be encrypted.
			Assertions.assertEquals("NOP", userSaved.getPassword());
    }

		@Test
		void userDeletionOkTest() {

			// User creation.
			UserSignupDTO user = UserSignupDTO.builder().firstName("Blaise").lastName("Pascal").emailAddress("blaise.pascal@gmail.com")
							.password("ABC").build();

			// sending the request.
			this.restTemplate.postForEntity("/api/user", user, String.class);

			Assertions.assertEquals(1, userRepository.count());

			// sending the request.
			this.restTemplate.delete("/api/user/1");

			Assertions.assertEquals(0, userRepository.count());
		}

    // -------------------------------------- Setters and Getters

}
