package com.loveable.restfulwebservices.services.core.users;

import com.loveable.restfulwebservices.dtos.UserDto;
import com.loveable.restfulwebservices.models.Users;
import com.loveable.restfulwebservices.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServicesImpl implements UsersServices {

    private final UsersRepository usersRepository;
    private final ModelMapper mapper;

    @Override
    public UserDto save(UserDto userDto) {
        userDto.setLastSeen(new Date());
        Users user = mapper.map(userDto, Users.class);
        Users savedUser = usersRepository.save(user);
        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUser(UserDto userDto) {
        Users user = usersRepository.findByEmail(userDto.getEmail());
        user.setPassword(null);
        return mapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<Users> allUsers = usersRepository.findAll();

        return allUsers.stream()
                .map(user -> {
                    user.setPassword(null);
                    return mapper.map(user, UserDto.class);
                })
                .toList();
    }
}
