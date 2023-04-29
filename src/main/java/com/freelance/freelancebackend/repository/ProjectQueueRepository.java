package com.freelance.freelancebackend.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.freelance.freelancebackend.entity.ProjectQueue;

public interface ProjectQueueRepository extends CrudRepository<ProjectQueue, Long> {

  @Transactional
  Optional<ProjectQueue> deleteByUsersIdAndProjectId(Long userId, Long projectId);
  Optional<ProjectQueue> findByUsersIdAndProjectId(Long userId, Long projectId);
  
}
