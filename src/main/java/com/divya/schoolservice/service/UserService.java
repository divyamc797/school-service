package com.divya.schoolservice.service;

import com.divya.schoolservice.entities.User;
import com.divya.schoolservice.exception.NotFound;

public interface UserService {
    User getByUsername(final String username) throws NotFound;
}
