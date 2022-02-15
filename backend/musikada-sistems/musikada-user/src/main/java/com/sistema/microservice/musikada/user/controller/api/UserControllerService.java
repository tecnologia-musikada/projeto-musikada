package com.sistema.microservice.musikada.user.controller.api;

import com.sistema.microservice.musikada.user.exception.custom.UserMusikadaException;
import com.sistema.microservice.musikada.user.to.request.NewUserRequestTO;
import com.sistema.microservice.musikada.user.to.request.UpdateUserRequestTO;
import com.sistema.microservice.musikada.user.to.request.UserLoginCredentialsUpdatingRequestTO;
import com.sistema.microservice.musikada.user.to.request.UserLoginRequestTO;
import com.sistema.microservice.musikada.user.to.response.ResponseTO;
import com.sistema.microservice.musikada.user.to.response.UserResponseTO;

import java.util.List;

public interface UserControllerService {
    public List<UserResponseTO> findAllUsers();
    public UserResponseTO findUserById(String userId) throws UserMusikadaException;
    public void createnewUser(NewUserRequestTO dto) throws UserMusikadaException;
    public void deleteUser(String userId) throws UserMusikadaException;
    public void updateUser(String userId, UpdateUserRequestTO dto) throws UserMusikadaException;
    public boolean makeLogin(UserLoginRequestTO dto) throws UserMusikadaException;
    boolean forgetPassword(String email) throws UserMusikadaException;
    boolean userUpdateLoginCredentials(UserLoginCredentialsUpdatingRequestTO dto) throws UserMusikadaException;
}