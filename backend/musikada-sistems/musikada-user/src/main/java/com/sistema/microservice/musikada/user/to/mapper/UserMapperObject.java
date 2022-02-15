package com.sistema.microservice.musikada.user.to.mapper;

import com.sistema.microservice.musikada.user.entities.User;
import com.sistema.microservice.musikada.user.to.request.NewUserRequestTO;
import com.sistema.microservice.musikada.user.to.request.UpdateUserRequestTO;
import com.sistema.microservice.musikada.user.to.response.UserResponseTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapperObject {
    public User convertNewUserrequestToUser(NewUserRequestTO dto);
    public User convertUpdateUserrequestToUser(UpdateUserRequestTO dto);
    public UserResponseTO convertUserToUserResponseTO(User entity);
}
