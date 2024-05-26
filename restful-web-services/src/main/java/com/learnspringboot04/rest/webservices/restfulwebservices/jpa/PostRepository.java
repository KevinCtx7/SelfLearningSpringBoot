package com.learnspringboot04.rest.webservices.restfulwebservices.jpa;

import com.learnspringboot04.rest.webservices.restfulwebservices.user.Post;
import com.learnspringboot04.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {


}
