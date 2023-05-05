package com.seyda.projectapp.controller;

import com.seyda.projectapp.entity.User;
import com.seyda.projectapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return  userService.saveOneUser(newUser);
    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        //customexception ekle
        return userService.getOneUserById(userId);

    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId,@RequestBody User newUser){
   return userService.updateOneUser(userId, newUser);
    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteById(userId);

    }

}
