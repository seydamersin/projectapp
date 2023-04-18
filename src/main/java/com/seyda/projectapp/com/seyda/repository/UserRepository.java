package com.seyda.projectapp.com.seyda.repository;

import com.seyda.projectapp.com.seyda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User,  Long> {

}
