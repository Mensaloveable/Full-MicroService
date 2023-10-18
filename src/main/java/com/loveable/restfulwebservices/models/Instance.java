package com.loveable.restfulwebservices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Instance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Name field should have at least 3 characters")
    private String firstname;

    @Size(min = 3, message = "Name field should have at least 3 characters")
    private String lastname;

    @Size(min = 3, message = "Name field should have at least 3 characters")
    private String otherName;

    @Email(message = "Invalid email")
    private String email;

    @NotNull
    @Size(min = 8)
    private String password;

    @OneToMany(mappedBy = "instance")
    @JsonIgnore
    @ToString.Exclude
    private List<Post> posts;

    private Date lastSeen;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
}
