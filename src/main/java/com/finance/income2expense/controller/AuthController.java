package com.finance.income2expense.controller;

import com.finance.income2expense.data.LoginRequestData;
import com.finance.income2expense.data.LoginResponseData;
import com.finance.income2expense.exception.TokenException;
import com.finance.income2expense.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponseData login(@RequestBody LoginRequestData request) {
        try {
            return userService.authenticateUser(request);
        } catch (TokenException ex) {
            LoginResponseData responseData = new LoginResponseData();
            responseData.setMessage(ex.getMessage());
            return responseData;
        }
    }
}
