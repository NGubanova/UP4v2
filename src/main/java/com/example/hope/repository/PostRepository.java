package com.example.hope.repository;

import com.example.hope.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByNameContaining (String name);
}
