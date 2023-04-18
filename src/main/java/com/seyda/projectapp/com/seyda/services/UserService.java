package com.seyda.projectapp.com.seyda.services;

import com.seyda.projectapp.com.seyda.entity.User;
import com.seyda.projectapp.com.seyda.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
   private UserRepository repository;

   public UserService(UserRepository repository) {
      this.repository = repository;
   }

   public List<User> getAllUsers() {
      return repository.findAll();
   }

   public User saveOneUser(User newUser) {
      return repository.save(newUser);
   }

   public User getOneUser(Long userId) {
      return repository.findById(userId).orElse(null);
   }


   public void deleteById(Long userId) {
      repository.deleteById(userId);
   }

   public User updateOneUser(Long userId, User newUser) {
      Optional<User> user= repository.findById(userId);
      if(user.isPresent()){
         User foundUser=user.get();
         foundUser.setUserName(newUser.getUserName());
         foundUser.setPassword(newUser.getPassword());
        repository.save(foundUser);
         return foundUser;
      }else
         return null;
   }
}
