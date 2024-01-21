package com.automata.testing.framework.post.repository;
/*
 * Copyright: Copyright (c) Automata akt.io 2022
 */

import org.springframework.data.repository.CrudRepository;

import com.automata.testing.framework.post.model.PostEntity;

/**
 * Dependencies
 */

/**
 * The post repository.
 * 
 * @author GELIBERT
 */
public interface IPostRepository extends CrudRepository<PostEntity, Integer> {

    // -------------------------------------- Public methods

}
