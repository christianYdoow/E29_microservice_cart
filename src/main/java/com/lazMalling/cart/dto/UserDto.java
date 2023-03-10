package com.lazMalling.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long userId;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String mobile;
    private String role;
}
