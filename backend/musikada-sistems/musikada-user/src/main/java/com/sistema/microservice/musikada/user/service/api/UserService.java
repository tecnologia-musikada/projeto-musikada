package com.sistema.microservice.musikada.user.service.api;

import com.sistema.microservice.musikada.user.exception.custom.UserMusikadaException;
import com.sistema.microservice.musikada.user.to.request.NewUserRequestTO;
import com.sistema.microservice.musikada.user.to.request.UpdateUserRequestTO;
import com.sistema.microservice.musikada.user.to.response.UserResponseTO;

import java.util.List;

public interface UserService {
    public List<UserResponseTO> findAllUsers();
    public UserResponseTO findUserById(String userId) throws UserMusikadaException;
    public void createnewUser(NewUserRequestTO dto) throws UserMusikadaException;
    public void deleteUser(String userId) throws UserMusikadaException;
    public void updateUser(String userId, UpdateUserRequestTO dto) throws UserMusikadaException;
}