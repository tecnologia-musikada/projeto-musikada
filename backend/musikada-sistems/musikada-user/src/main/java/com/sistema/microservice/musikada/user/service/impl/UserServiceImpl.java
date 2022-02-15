package com.sistema.microservice.musikada.user.service.impl;

import com.sistema.microservice.musikada.user.constants.ExceptionConstants;
import com.sistema.microservice.musikada.user.entities.User;
import com.sistema.microservice.musikada.user.exception.custom.UserMusikadaException;
import com.sistema.microservice.musikada.user.service.api.UserService;
import com.sistema.microservice.musikada.user.to.mapper.UserMapperObject;
import com.sistema.microservice.musikada.user.to.request.NewUserRequestTO;
import com.sistema.microservice.musikada.user.to.request.UpdateUserRequestTO;
import com.sistema.microservice.musikada.user.to.response.UserResponseTO;
import io.quarkus.mongodb.panache.PanacheQuery;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import io.quarkus.elytron.security.common.BcryptUtil;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    private UserMapperObject userMapperObject;

    @Override
    public List<UserResponseTO> findAllUsers() {
        List<User> allUsers = User.listAll();
        List<UserResponseTO> usersResponse = new ArrayList<>();
        for (User user : allUsers) {
            UserResponseTO userResponseTO = userMapperObject.convertUserToUserResponseTO(user);
            userResponseTO.setUserId(user.id.toString());
            usersResponse.add(userResponseTO);
        }
        return usersResponse;
    }

    @Override
    public UserResponseTO findUserById(String userId) throws UserMusikadaException {
        ObjectId objectId = new ObjectId(userId);
        Optional<User> userOptional = User.findByIdOptional(objectId);
        UserResponseTO userResponseTO = null;
        if(!userOptional.isPresent())
            throw new UserMusikadaException(ExceptionConstants.ERROR_CODE_USER_NOT_FOUND, userId);

        userResponseTO = userMapperObject.convertUserToUserResponseTO(userOptional.get());
        return userResponseTO;
    }

    @Override
    public void createnewUser(NewUserRequestTO dto) throws UserMusikadaException {
        PanacheQuery<User> userPanacheQuery = User.find("email", dto.getEmail());
        Optional<User> optionalUser = userPanacheQuery.stream().findAny();
        if (optionalUser.isPresent())
            throw new UserMusikadaException(ExceptionConstants.ERROR_CODE_EMAIL_USER_ALREADY_EXIST, dto.getEmail());

        User user = userMapperObject.convertNewUserrequestToUser(dto);
        user.setPassword(encodePassword(user.getPassword()));
        user.persist();
    }

    @Override
    public void deleteUser(String userId) throws UserMusikadaException{
        ObjectId objectId = new ObjectId(userId);
        Optional<User> userOptional = User.findByIdOptional(objectId);
        if(!userOptional.isPresent())
            throw new UserMusikadaException(ExceptionConstants.ERROR_CODE_USER_NOT_FOUND, userId);
        User.deleteById(objectId);
    }

    @Override
    public void updateUser(String userId, UpdateUserRequestTO dto) {
        ObjectId objectId = new ObjectId(userId);
        User user = userMapperObject.convertUpdateUserrequestToUser(dto);
        user.id = objectId;
        user.update();
    }

    private static String encodePassword(String password) {
        String passwordEncod = BcryptUtil.bcryptHash(password);
        return passwordEncod;
    }
}