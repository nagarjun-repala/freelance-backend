package com.freelance.freelancebackend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.freelance.freelancebackend.entity.User;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable{

    private Long id;
    private String username;
    private String email;
    // private List<String> roles;

    public UserDto(User user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        // this.roles = getRoles(user.getRoles());
    }
    // private List<String> getRoles(Set<Role> roles){
    //     List<String> userRoles = new ArrayList<>();
    //     for (Role role : roles) {
    //         userRoles.add(role.getName());
    //     }
    //     return userRoles;
    // }
}
