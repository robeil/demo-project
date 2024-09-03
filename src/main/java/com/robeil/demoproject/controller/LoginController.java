package com.robeil.demoproject.controller;

import com.robeil.demoproject.domain.AccountCredentials;
import com.robeil.demoproject.security.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials){
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.userName(), credentials.password());
        Authentication auth = authenticationManager.authenticate(creds);
        String jwts = jwtService.getToken(auth.getName());
        logger.info("Logged in {} : " + auth + " token : " + jwts);
        System.out.println("Logged in {} : " + auth + " token : " + jwts);

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION,"Bearer"+jwts)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,"Authorization")
                .build();
    }



}
