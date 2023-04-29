package com.freelance.freelancebackend.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.freelancebackend.entity.User;
import com.freelance.freelancebackend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<HttpStatus> createUser(@Valid @RequestBody User user) {

      userService.createUser(user);
      return new ResponseEntity<>(HttpStatus.CREATED);
  }
  
}
