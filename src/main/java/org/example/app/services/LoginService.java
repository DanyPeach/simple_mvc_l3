package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private Logger logger = Logger.getLogger(LoginService.class);

    public boolean authenticate(LoginForm loginForm){
        logger.info("try auth with user-form");
        return loginForm.getUsername().equals("admin") && loginForm.getPassword().equals("1234");
    }
}
