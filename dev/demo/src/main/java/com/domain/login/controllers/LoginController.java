package com.domain.login.controllers;

import com.domain.login.models.Login;
import com.domain.login.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public ResponseEntity<List<Login>> getAll(){
        List<Login> login = loginService.getAll();
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @PostMapping//("/login")
    public ResponseEntity<Login> create(@RequestBody Login login){
        login = loginService.create(login);
        return new ResponseEntity<>(login, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Login> getById(@PathVariable("id") Long id){
        Login login = loginService.getById(id);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Login> getByUserName(@RequestParam String userName){
        Login login = loginService.getByUserName(userName);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Login> update(@PathVariable("id") Long id, @RequestBody Login loginDetail){
        loginDetail = loginService.update(id, loginDetail);
        return new ResponseEntity<>(loginDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        loginService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}