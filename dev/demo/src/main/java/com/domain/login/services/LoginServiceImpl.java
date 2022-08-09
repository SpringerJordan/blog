package com.domain.login.services;

import com.domain.core.ResourceCreationException;
import com.domain.core.ResourceNotFoundException;
import com.domain.login.models.Login;
import com.domain.login.repos.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService{
    private LoginRepository loginRepository;

    //@Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login create(Login login) throws ResourceCreationException {
        Optional<Login> optional = loginRepository.findByUserName(login.getUserName());
        if(optional.isPresent())
            throw new ResourceCreationException("User with email exists: " + login.getUserName());
        login = loginRepository.save(login);
        return login;
    }

    @Override
    public Login getById(Long id) throws ResourceNotFoundException {
        Login login = loginRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No User with id: " + id));
        return login;
    }

    @Override
    public Login getByUserName(String userName) throws ResourceNotFoundException {
        Login login = loginRepository.findByUserName(userName)
                .orElseThrow(()->new ResourceNotFoundException("No User with email: " + userName));
        return login;
    }

    @Override
    public List<Login> getAll() {
        return loginRepository.findAll();
    }

    @Override
    public Login update(Long id, Login loginDetail) throws ResourceNotFoundException {
        Login login = getById(id);
        login.setUserName(loginDetail.getUserName());
        login.setPassword(loginDetail.getPassword());
       // login.setEmail(loginDetail.getEmail());
        login = loginRepository.save(login);
        return login;
    }

    @Override
    public void delete(Long id) {
        Login login = getById(id);
        loginRepository.delete(login);
    }
}
