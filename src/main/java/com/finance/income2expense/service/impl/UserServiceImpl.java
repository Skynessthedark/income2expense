package com.finance.income2expense.service.impl;

import com.finance.income2expense.data.LoginRequestData;
import com.finance.income2expense.data.LoginResponseData;
import com.finance.income2expense.exception.TokenException;
import com.finance.income2expense.service.I2ETokenService;
import com.finance.income2expense.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsService userDetailsService;

    private final I2ETokenService i2ETokenService;

    private final AuthenticationManager authenticationManager;

    public UserServiceImpl(UserDetailsService userDetailsService, I2ETokenService i2ETokenService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.i2ETokenService = i2ETokenService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public LoginResponseData authenticateUser(LoginRequestData request) throws TokenException {
        if(Objects.isNull(request)
                || !StringUtils.hasText(request.getUsername())
                || !StringUtils.hasText(request.getPassword()))
            throw new TokenException("Missing credentials.");

        String username = request.getUsername();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(Objects.isNull(userDetails))
            throw new TokenException("User not found by username: " + username);

        var auth = new UsernamePasswordAuthenticationToken(username, request.getPassword());
        authenticationManager.authenticate(auth);

        LoginResponseData responseData = new LoginResponseData();
        responseData.setToken(i2ETokenService.generateToken(userDetails));
        responseData.setExpireDate(i2ETokenService.getExpirationTime());
        return responseData;
    }
}
