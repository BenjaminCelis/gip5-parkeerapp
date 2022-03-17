package com.example.parkeerapp.Converter;

import com.example.parkeerapp.Domain.User;
import com.example.parkeerapp.DTO.UserDTO;
import com.example.parkeerapp.DTO.UserSimpleDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {


    // user to userDTO
    public UserDTO userToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setRole(user.getRole());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    // user lijst naar userDTO lijst
    public List<UserDTO> UserListToDTO(List<User> userList){
        return userList.stream().map(this::userToDTO).collect(Collectors.toList());
    }

    // userDTO to user
    public User userDTOtoUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstname());
        user.setLastName(userDTO.getLastname());
        user.setRole(userDTO.getRole());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public UserSimpleDTO userToSimpleDTO(User user){
        UserSimpleDTO userSimpleDTO = new UserSimpleDTO();
        userSimpleDTO.setId(user.getId());
        userSimpleDTO.setUsername(user.getUsername());
        userSimpleDTO.setRole(user.getRole());
        return userSimpleDTO;
    }

}