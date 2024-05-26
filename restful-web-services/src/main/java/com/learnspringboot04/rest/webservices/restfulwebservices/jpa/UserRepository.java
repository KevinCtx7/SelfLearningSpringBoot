package com.learnspringboot04.rest.webservices.restfulwebservices.jpa;

import com.learnspringboot04.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
