package com.freelance.freelancebackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.freelance.freelancebackend.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

  
}
