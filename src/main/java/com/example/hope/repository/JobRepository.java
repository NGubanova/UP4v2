package com.example.hope.repository;

import com.example.hope.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository  extends CrudRepository<Job, Long> {
    Job findByNameContaining(String name);
}
