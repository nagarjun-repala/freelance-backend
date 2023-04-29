package com.freelance.freelancebackend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.freelance.freelancebackend.GlobalMethods;
import com.freelance.freelancebackend.dto.UserDto;
import com.freelance.freelancebackend.entity.Role;
import com.freelance.freelancebackend.entity.User;
import com.freelance.freelancebackend.exception.UserNotFoundException;
import com.freelance.freelancebackend.repository.RoleRepository;
import com.freelance.freelancebackend.repository.UserRepository;
import com.freelance.freelancebackend.security.SecurityConstants;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  @Override
  public User getUser(Long userId) {

      Optional<User> userEntity = userRepository.findById(userId);
      if(userEntity.isEmpty()) throw new UserNotFoundException(userId);
      return userEntity.get();
  }

  @Override
  public User getUser(String username) {

      Optional<User> userEntity = userRepository.findByUsername(username);
      if(userEntity.isEmpty()) throw new UserNotFoundException(username);
      return userEntity.get();
  }

  @Override
  public User createUser(User user) {
      
    Role role = roleRepository.findById(SecurityConstants.DEFAULT_ROLE).get();    
    //   user.setCreatedOn(GlobalMethods.dateTimeFormatter(LocalDateTime.now()));
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      role.getUsers().add(user);
      User savedUser = userRepository.save(user);
    //   cart.setUser(savedUser);
    //   cartRepository.save(cart);
      roleRepository.save(role);
      return savedUser;

  }

  

  @Override
  public User updateUser(Long userId, User user) {
      Optional<User> userEntity = userRepository.findById(userId);
      if(userEntity.isEmpty()) throw new UserNotFoundException(userId);    
      User updateUser = userEntity.get();
      updateUser.setFirstName(user.getFirstName());
      updateUser.setLastName(user.getLastName());
      updateUser.setEmail(user.getEmail());
      updateUser.setPassword(user.getPassword());
      updateUser.setUsername(user.getUsername());
      return updateUser;
  }

  @Override
  public void deleteUser(Long id) {      
      userRepository.deleteById(id);
  }    

  @Override
  public void delteUser(String username) {        
      userRepository.deleteUserByUsername(username);
  }


  @Override
  public List<User> getAllUsers() {
      List<User> users = (List<User>) userRepository.findAll();
      if(users.isEmpty()) throw new UserNotFoundException();        
      return users;
  }

@Override
public UserDto getUserDto(String username) {
    UserDto userDto = new UserDto(getUser(username));
    return userDto;
}

}
