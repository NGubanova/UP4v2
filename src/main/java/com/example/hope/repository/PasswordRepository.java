package com.example.hope.repository;

import com.example.hope.models.Password;
import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<Password, Long> {
    Password findByPasswordName(String passwordName);
}
