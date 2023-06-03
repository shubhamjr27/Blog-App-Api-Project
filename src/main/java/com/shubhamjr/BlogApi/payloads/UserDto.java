package com.shubhamjr.BlogApi.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username should be of atleast 4 characters !!")
    private String name;
    @Email(message = "Email address is not valid !!")
    @NotEmpty(message = "Email is required !!")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 20, message = "Password must be of min 3 chars and max 20 chars !!")
    private String password;

    @NotEmpty
    private String about;
}
