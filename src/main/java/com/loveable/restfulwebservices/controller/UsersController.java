package com.loveable.restfulwebservices.controller;

import com.loveable.restfulwebservices.dtos.UserDto;
import com.loveable.restfulwebservices.services.users.UsersServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersServices usersServices;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(usersServices.save(userDto));
    }

    @GetMapping("/")
    public ResponseEntity<UserDto> getUser(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(usersServices.getUser(userDto));
    }

}
