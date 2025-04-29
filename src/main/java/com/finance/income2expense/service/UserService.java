package com.finance.income2expense.service;

import com.finance.income2expense.data.LoginRequestData;
import com.finance.income2expense.data.LoginResponseData;
import com.finance.income2expense.exception.TokenException;

public interface UserService {

    LoginResponseData authenticateUser(LoginRequestData request) throws TokenException;
}
