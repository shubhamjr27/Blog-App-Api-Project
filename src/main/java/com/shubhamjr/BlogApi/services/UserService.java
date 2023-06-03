package com.shubhamjr.BlogApi.services;

import com.shubhamjr.BlogApi.payloads.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);

}
