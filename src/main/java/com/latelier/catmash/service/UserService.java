package com.latelier.catmash.service;

import com.latelier.catmash.entity.User;
import com.latelier.catmash.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class UserService  implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public User getUser(String username) {
        log.info("Inside getUser of UserService");
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername of UserService");
        User user = getUser(username);
        if(user == null) throw new UsernameNotFoundException("user not found");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public User addUser(User user) {
        log.info("Inside addUser of UserService");
        return userRepository.save(user);
    }
}
