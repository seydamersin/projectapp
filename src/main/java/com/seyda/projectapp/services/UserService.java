package com.seyda.projectapp.services;

import com.seyda.projectapp.entity.User;
import com.seyda.projectapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
   private final UserRepository repository;

   public UserService(UserRepository repository) {
      this.repository = repository;
   }

   public static void getOnePostUser(Long userId) {
   }

   public List<User> getAllUsers() {
      return repository.findAll();
   }

   public User saveOneUser(User newUser) {
      return repository.save(newUser);
   }

   public User getOneUserById(Long userId) {
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
