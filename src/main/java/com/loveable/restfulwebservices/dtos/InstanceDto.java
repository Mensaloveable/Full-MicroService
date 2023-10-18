package com.loveable.restfulwebservices.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InstanceDto {

    @Size(min = 3, message = "Name field should have at least 3 characters")
    private String firstname;

    @Size(min = 3, message = "Name field should have at least 3 characters")
    private String lastname;

    @Size(min = 3, message = "Name field should have at least 3 characters")
    private String otherName;

    @Email(message = "Invalid email")
    private String email;

    @Size(min = 8)
    private String password;

    private Date lastSeen;
}
