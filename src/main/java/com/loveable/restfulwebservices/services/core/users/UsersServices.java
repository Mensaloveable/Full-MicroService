package com.loveable.restfulwebservices.services.core.users;

import com.loveable.restfulwebservices.dtos.UserDto;

import java.util.List;

public interface UsersServices {
    UserDto save(UserDto userDto);
    UserDto getUser(UserDto userDto);
    List<UserDto> getUsers();
}
