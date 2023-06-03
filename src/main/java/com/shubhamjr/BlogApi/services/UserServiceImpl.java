package com.shubhamjr.BlogApi.services;

import com.shubhamjr.BlogApi.entities.User;
import com.shubhamjr.BlogApi.exceptions.ResourceNotFoundException;
import com.shubhamjr.BlogApi.payloads.UserDto;
import com.shubhamjr.BlogApi.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.ResourceAccessException;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToDTo(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {

        User userToBeUpdated = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        userToBeUpdated.setName(userDto.getName());
        userToBeUpdated.setEmail(userDto.getEmail());
        userToBeUpdated.setPassword(userDto.getPassword());
        userToBeUpdated.setAbout(userDto.getAbout());

        User savedUser = this.userRepo.save(userToBeUpdated);
        return this.userToDTo(savedUser);

    }

    private User dtoToUser(UserDto userDto) {
        /*
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
         */
        return this.modelMapper.map(userDto, User.class);
    }

    private UserDto userToDTo(User user) {
        return this.modelMapper.map(user, UserDto.class);
    }

}
