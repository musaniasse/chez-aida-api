package com.chezaida.chezaidaservice.controller;

import com.chezaida.chezaidaservice.dto.LoginRequest;
import com.chezaida.chezaidaservice.dto.Response;
import com.chezaida.chezaidaservice.entity.User;
import com.chezaida.chezaidaservice.service.interfac.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody User user){
        Response response = userService.register(user);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest){
        Response response = userService.login(loginRequest);
        System.out.println("ok");
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
