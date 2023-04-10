package com.inaal.rumahkost_api.controllers;

import com.inaal.rumahkost_api.models.dto.UserDTO;
import com.inaal.rumahkost_api.models.entity.User;
import com.inaal.rumahkost_api.models.response.SuccessResponse;
import com.inaal.rumahkost_api.services.IServices;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private IServices<User> userService;
    private ModelMapper modelMapper;

    @Autowired
    public UserController(IServices<User> userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity getAllUser(){
        List<User> users = userService.getAllService();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SuccessResponse("Success get all user", users));
    }
    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) throws Exception {
        User user = userService.getByIdService(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SuccessResponse("Success get user with id " + id, user));
    }
    @PostMapping
    public ResponseEntity createUser(@Valid @RequestBody UserDTO userDTO) throws Exception {
        User user = modelMapper.map(userDTO, User.class);
        userService.saveService(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new SuccessResponse("Success create user", user));
    }
    public ResponseEntity updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id) throws Exception {
        User user = modelMapper.map(userDTO, User.class);
        user.setId(id);
        userService.updateService(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SuccessResponse("Success update user with id " + id, user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) throws Exception {
        User user = userService.getByIdService(id);
        userService.deleteService(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new SuccessResponse("Success delete user with id " + id, user));
    }

}
