package com.sistema.microservice.musikada.user.service.api;

import com.sistema.microservice.musikada.user.exception.custom.UserMusikadaException;
import com.sistema.microservice.musikada.user.to.request.UserLoginCredentialsUpdatingRequestTO;
import com.sistema.microservice.musikada.user.to.request.UserLoginRequestTO;

public interface UserLoginService {
    public boolean makeLogin(UserLoginRequestTO dto) throws UserMusikadaException;
    boolean forgetPassword(String email) throws UserMusikadaException;
    boolean userUpdateLoginCredentials(UserLoginCredentialsUpdatingRequestTO dto) throws UserMusikadaException;
}