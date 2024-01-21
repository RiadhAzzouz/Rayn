package com.automata.testing.framework.post.controller;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import com.automata.testing.framework.commons.eceptions.AutomataBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.automata.testing.framework.post.dto.PostDTO;
import com.automata.testing.framework.post.model.PostEntity;
import com.automata.testing.framework.post.service.PostServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * Dependencies
 */

/**
 * Post controller.
 * 
 * @author GELIBERT
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class PostController {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    /**
     * The post service to use.
     */
    @Autowired
    private PostServiceImpl postService;

    // -------------------------------------- public attributes

    // -------------------------------------- Constructor

    // -------------------------------------- Public static methods

    // -------------------------------------- Private static methods

    // -------------------------------------- Private methods

    // -------------------------------------- Protected methods

    // -------------------------------------- Public methods

    /**
     * Rest API for the creation of the post.
     * 
     * @param post
     *             the post dto
     * @return the response entity
     */
    @PostMapping(path = "/post")
    public ResponseEntity<String> createUser(@RequestBody PostDTO post) {
      log.info("Receiving the post {}", post);
      postService.createPost(post);
      return ResponseEntity.ok().build();
    }

    /**
     * Rest API to find a post by its id.
     * 
     * @param id
     *           the identifier
     * @return the response entity
     */
    @GetMapping(path = "/post/{id}")
    public ResponseEntity<PostEntity> getUser(@PathVariable(name = "id") Integer id) throws AutomataBusinessException {
      log.info("Trying to find the post with id {}", id);

      return ResponseEntity.ok(postService.getPost(id));
    }

  @DeleteMapping(path = "/post/{id}")
  public ResponseEntity<String> deletePost(@PathVariable(name = "id") Integer id) {
    log.info("Trying to delete the post with id {}", id);

    return ResponseEntity.ok().build();
  }

    // -------------------------------------- Setters and Getters

}
