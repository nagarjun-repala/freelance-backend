package com.freelance.freelancebackend.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.freelance.freelancebackend.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByUsername(String username);
  @Transactional
  void deleteUserByUsername(String username);
  
  
}
