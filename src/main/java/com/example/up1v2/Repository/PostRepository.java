package com.example.up1v2.Repository;

import com.example.up1v2.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByName(String name);
}
