package com.divya.schoolservice.service;

import com.divya.schoolservice.entities.User;
import com.divya.schoolservice.exception.NotFound;
import com.divya.schoolservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("uerServiceImpl")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User getByUsername(final String username) throws NotFound {
        Optional<User> userByName = userRepo.getUserByName(username);

        if (userByName.isPresent()) {
            return userByName.get();
        } else {
            throw new NotFound("User not found with username: " + username);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userByName = userRepo.getUserByName(username);

        if (userByName.isPresent()) {
            User user = userByName.get();
            return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
