package com.loveable.restfulwebservices.services.users;

import com.loveable.restfulwebservices.dtos.UserDto;
import com.loveable.restfulwebservices.exception.UserAlreadyExistException;
import com.loveable.restfulwebservices.exception.UserNotFoundException;
import com.loveable.restfulwebservices.models.Users;
import com.loveable.restfulwebservices.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServicesImpl implements UsersServices {

    private final UsersRepository usersRepository;
    private final ModelMapper mapper;

    @Override
    public UserDto save(UserDto userDto) {

        Optional<Users> userPresence = usersRepository.findByEmail(userDto.getEmail());

        if (userPresence.isPresent()) {
            throw new UserAlreadyExistException("Email Already Exist. Try forget-password or use a different email");
        }

        userDto.setLastSeen(new Date());
        Users user = mapper.map(userDto, Users.class);
        Users savedUser = usersRepository.save(user);

        return mapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUser(UserDto userDto) {

        Optional<Users> userPresence = usersRepository.findByEmail(userDto.getEmail());

        if (userPresence.isEmpty()) {
            throw new UserNotFoundException("Invalid Email or Password");
        }

        Users user = userPresence.get();
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
