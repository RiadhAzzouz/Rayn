package com.automata.testing.framework.post;

import com.automata.testing.framework.algorithm.service.IEncryptionService;
import com.automata.testing.framework.user.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.automata.testing.framework.post.dto.PostDTO;
import com.automata.testing.framework.post.model.PostEntity;
import com.automata.testing.framework.post.repository.IPostRepository;

import lombok.extern.slf4j.Slf4j;

/*
 * Copyright: Copyright (c) Automata akt.io 2021
 */

/*
 * Dependencies
 */

/**
 * Testing class for Post Controller
 * 
 * @author GELIBERT
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = { RestTemplateAutoConfiguration.class, PostServiceApi.class })
@Slf4j
class PostControllerIT {

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
     * The post repository, used to check datas.
     */
    @Autowired
    private IPostRepository postRepository;


    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    /**
     * Testing the post creation.
     */
    @Test
    void creationPostOkTest() {

			// Post creation.
			UserDTO user = UserDTO.builder().firstName("Blaise").lastName("Pascal").emailAddress("blaise.pascal@gmail.com")
				.userId("AHhhhhookk").build();
			PostDTO postCreate = PostDTO.builder().content("ABC").user(user).build();

			// sending the request.
			ResponseEntity<String> res = this.restTemplate.postForEntity("/api/post", postCreate, String.class);

			Assertions.assertEquals(1, postRepository.count());
			// We get the user and we check the informations.
			PostEntity postSaved = this.postRepository.findById(1).get();
			log.info("The post in database is {}", postSaved);
			Assertions.assertEquals(postCreate.getUser().getUserId(), postSaved.getUserId());
			Assertions.assertEquals(postCreate.getUser().getFirstName(), postSaved.getUserFirstName());
			Assertions.assertEquals(postCreate.getUser().getLastName(), postSaved.getUserLastName());
			Assertions.assertNotNull(postSaved.getId());
			// Content should be encrypted in database.
			Assertions.assertEquals("NOP", postSaved.getContent());

			PostEntity getPostFromApi = this.restTemplate.getForEntity("/api/post/1", PostEntity.class).getBody();
			log.info("The post from API {}", getPostFromApi);
			Assertions.assertEquals(postCreate.getUser().getUserId(), getPostFromApi.getUserId());
			Assertions.assertEquals(postCreate.getUser().getFirstName(), getPostFromApi.getUserFirstName());
			Assertions.assertEquals(postCreate.getUser().getLastName(), getPostFromApi.getUserLastName());
			Assertions.assertNotNull(postSaved.getId());
			// Content should not be encrypted through API.
			Assertions.assertEquals("ABC", getPostFromApi.getContent());
    }

    /**
     * When the id does not exists, it should return "not found".
     */
		@Test
    void findPostByIdNotFound() {
			ResponseEntity<PostEntity> getPostFromApi = this.restTemplate.getForEntity("/api/post/2", PostEntity.class);
			log.info("The post from API {}", getPostFromApi);
			// Must be not found.
			Assertions.assertEquals(HttpStatus.NOT_FOUND, getPostFromApi.getStatusCode());
    }

    // -------------------------------------- Setters and Getters

}
