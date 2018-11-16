package com.antkorwin.authservice.service;

import com.antkorwin.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created on 16.11.2018.
 *
 * @author Korovin Anatoliy
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username)
                             .map(this::convertToSpringUser)
                             .orElseThrow(() -> new RuntimeException("user not found"));
    }

    private User convertToSpringUser(com.antkorwin.authservice.model.User user) {
        return new User(user.getName(),
                        user.getPassword(),
                        user.isAdmin()
                        ? AuthorityUtils.createAuthorityList("ROLE_ADMIN")
                        : AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
