package com.antkorwin.authservice.repository;

import com.antkorwin.authservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created on 16.11.2018.
 *
 * @author Korovin Anatoliy
 */
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByName(String name);
}
