package com.freelance.freelancebackend.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.freelance.freelancebackend.dto.UserDto;
import com.freelance.freelancebackend.entity.User;

@Service
public interface UserService {

  User getUser(Long userId);
  User getUser(String username);
  User createUser(User user);
  User updateUser(Long userId, User user);

  @PreAuthorize("hasRole('ADMIN')")
  void deleteUser(Long id);

  @PreAuthorize("hasRole('ADMIN')")
  void delteUser(String username);
  List<User> getAllUsers();
  UserDto getUserDto(String username);
  
}
