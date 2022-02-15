package com.sistema.microservice.musikada.user.service.impl;

import com.sistema.microservice.musikada.user.constants.ExceptionConstants;
import com.sistema.microservice.musikada.user.entities.User;
import com.sistema.microservice.musikada.user.exception.custom.UserMusikadaException;
import com.sistema.microservice.musikada.user.service.api.UserLoginService;
import com.sistema.microservice.musikada.user.to.request.UserLoginCredentialsUpdatingRequestTO;
import com.sistema.microservice.musikada.user.to.request.UserLoginRequestTO;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.mongodb.panache.PanacheQuery;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class UserLoginServiceImpl implements UserLoginService {

    @Override
    public boolean makeLogin(UserLoginRequestTO dto) throws UserMusikadaException{
        PanacheQuery<User> userPanacheQuery = User.find("email", dto.getEmail());
        Optional<User> optionalUser = userPanacheQuery.stream().findAny();
        if (!optionalUser.isPresent())
            throw new UserMusikadaException(ExceptionConstants.ERROR_CODE_USER_WITH_EMAIL_NOT_FOUND, dto.getEmail());
        return optionalUser.filter(user -> decodePassword(dto.getPassword(), user.getPassword())).isPresent();
    }

    @Override
    public boolean forgetPassword(String email) throws UserMusikadaException{
        PanacheQuery<User> userPanacheQuery = User.find("email", email);
        Optional<User> optionalUser = userPanacheQuery.stream().findAny();
        if (!optionalUser.isPresent()) {
            throw new UserMusikadaException(ExceptionConstants.ERROR_CODE_USER_WITH_EMAIL_NOT_FOUND, email);
        }
        return optionalUser.isPresent();
    }

    @Override
    public boolean userUpdateLoginCredentials(UserLoginCredentialsUpdatingRequestTO dto) throws UserMusikadaException{
        PanacheQuery<User> userPanacheQuery = User.find("email", dto.getEmail());
        Optional<User> optionalUser = userPanacheQuery.stream().findAny();
        if(!optionalUser.isPresent()){
            throw new UserMusikadaException(ExceptionConstants.ERROR_CODE_USER_WITH_EMAIL_NOT_FOUND, dto.getEmail());
        }
        User user = optionalUser.get();
        if(dto.getNewPassword().equals(dto.getConfirmPassword())){
            user.setPassword(encodePassword(dto.getNewPassword()));
            user.update();
            return true;
        }
        return false;
    }

    private static boolean decodePassword(String password, String passwordEncod) {
        return BcryptUtil.matches(password, passwordEncod);
    }
    private static String encodePassword(String password) {
        String passwordEncod = BcryptUtil.bcryptHash(password);
        return passwordEncod;
    }
}