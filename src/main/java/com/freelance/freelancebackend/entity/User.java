package com.freelance.freelancebackend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Firstname cannot be blank")
  @NonNull
  @Column(name = "first_name", nullable = false)
  private String firstName;

  @NotBlank(message = "Lastname cannot be blank")
  @NonNull
  @Column(name = "last_name", nullable = false)    
  private String lastName;  

  @NotBlank(message = "designation cannot be blank")
  @NonNull
  @Column(name = "designation", nullable = false)
  private String designation;

  @NotBlank(message = "Username cannot be blank")
  @NonNull
  @Column(nullable = false, unique = true)    
  private String username;

  @NotBlank(message = "Password cannot be blank")
  @NonNull
  @Column(nullable = false)    
  @Getter(onMethod = @__(@JsonIgnore))
  @Setter(onMethod = @__(@JsonProperty))
  private String password;

  @NotBlank(message = "Email cannot be blank")
  @NonNull
  @Column(nullable = false)
  private String email;

  @NotBlank(message = "Phone cannot be blank")
  @NonNull
  @Column(nullable = false)
  private String phone;

  @NotBlank(message = "About cannot be blank")
  @NonNull
  @Column(nullable = false)
  private String about;

  @JsonIgnore
  @ManyToMany(mappedBy = "users", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<Role> roles;
  
}
