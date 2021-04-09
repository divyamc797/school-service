package com.divya.schoolservice.service;

import com.divya.schoolservice.entities.User;
import com.divya.schoolservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("uerServiceImpl")
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userByName = userRepo.getUserByName(username);

        if (userByName.isPresent()) {
            User user = userByName.get();
            List<SimpleGrantedAuthority> grantedAuthorities = user.getRoles()
                    .stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getRole()))
                    .collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(user.getName(),
                    user.getPassword(),
                    grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
