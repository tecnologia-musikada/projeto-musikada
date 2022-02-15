package com.sistema.microservice.musikada.user.controller.impl;

import com.sistema.microservice.musikada.user.controller.api.UserControllerService;
import com.sistema.microservice.musikada.user.exception.custom.UserMusikadaException;
import com.sistema.microservice.musikada.user.service.api.UserLoginService;
import com.sistema.microservice.musikada.user.service.api.UserService;
import com.sistema.microservice.musikada.user.to.request.NewUserRequestTO;
import com.sistema.microservice.musikada.user.to.request.UpdateUserRequestTO;
import com.sistema.microservice.musikada.user.to.request.UserLoginCredentialsUpdatingRequestTO;
import com.sistema.microservice.musikada.user.to.request.UserLoginRequestTO;
import com.sistema.microservice.musikada.user.to.response.UserResponseTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserControllerServiceImpl implements UserControllerService {
    @Inject
    private UserService userService;
    @Inject
    private UserLoginService userLoginService;

    @Override
    public List<UserResponseTO> findAllUsers() {
        return userService.findAllUsers();
    }

    @Override
    public UserResponseTO findUserById(String userId) throws UserMusikadaException {
        return userService.findUserById(userId);
    }

    @Override
    public void createnewUser(NewUserRequestTO dto) throws UserMusikadaException {
        userService.createnewUser(dto);
    }

    @Override
    public void deleteUser(String userId) throws UserMusikadaException {
        userService.deleteUser(userId);
    }

    @Override
    public void updateUser(String userId, UpdateUserRequestTO dto)throws UserMusikadaException {
        userService.updateUser(userId, dto);
    }

    @Override
    public boolean makeLogin(UserLoginRequestTO dto)throws UserMusikadaException {
        return userLoginService.makeLogin(dto);
    }

    @Override
    public boolean forgetPassword(String email) throws UserMusikadaException {
        return userLoginService.forgetPassword(email);
    }

    @Override
    public boolean userUpdateLoginCredentials(UserLoginCredentialsUpdatingRequestTO dto) throws UserMusikadaException{
        return userLoginService.userUpdateLoginCredentials(dto);
    }
}
