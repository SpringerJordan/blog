package com.domain.login.services;

import com.domain.core.ResourceCreationException;
import com.domain.core.ResourceNotFoundException;
import com.domain.login.models.Login;

import java.util.List;

public interface LoginService {
    Login create(Login login) throws ResourceCreationException;
    Login getById(Long id) throws ResourceNotFoundException;
    Login getByUserName(String userName) throws ResourceNotFoundException;
    List<Login> getAll();
    Login update(Long id, Login loginDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
