package com.automata.testing.framework.post.service;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import java.util.Optional;

import com.automata.testing.framework.algorithm.service.IDecryptionService;
import com.automata.testing.framework.algorithm.service.IEncryptionService;
import com.automata.testing.framework.commons.eceptions.AutomataBusinessException;
import com.automata.testing.framework.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automata.testing.framework.post.dto.PostDTO;
import com.automata.testing.framework.post.model.PostEntity;
import com.automata.testing.framework.post.repository.IPostRepository;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Dependencies
 */

/**
 * Post service implementation.
 * 
 * @author GELIBERT
 */
@Service
public class PostServiceImpl implements IPostService {

    // -------------------------------------- Inner classes

    // -------------------------------------- public static attributes

    // -------------------------------------- private static attributes

    // -------------------------------------- private attributes

    /**
     * Loading the post repository in order to load datas.
     */
    @Autowired
    private IPostRepository postRepo;

    @Autowired
    private IEncryptionService encryptionService;

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
     * {@inheritDoc}
     */
    public Integer createPost(PostDTO post) {
      PostEntity postDoc = PostEntity.builder().content(encryptionService.encode(post.getContent())).userId(post.getUser().getUserId())
        .userFirstName(post.getUser().getFirstName()).userLastName(post.getUser().getLastName()).build();
      return postRepo.save(postDoc).getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PostEntity getPost(Integer id) throws AutomataBusinessException {
	      return postRepo.findById(id)
                .map(this::decryptPost)
                .orElseThrow(() -> new AutomataBusinessException("404", "POST_NOT_FOUND", null));
    }

    @Override
    public void deletePost(Integer id) throws AutomataBusinessException {
        Optional<PostEntity> post = postRepo.findById(id);
        if (post.isPresent()) {
            postRepo.deleteById(id);
        } else {
            throw new AutomataBusinessException("404", "POST_NOT_FOUND", null);
        }
    }

    private PostEntity decryptPost(PostEntity post) {
        if (post != null) {
            post.setContent(decryptionService.decode(post.getContent()));
        }
        return post;
    }

    // -------------------------------------- Setters and Getters

}
