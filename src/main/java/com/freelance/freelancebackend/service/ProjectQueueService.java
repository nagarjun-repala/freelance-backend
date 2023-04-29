package com.freelance.freelancebackend.service;

import com.freelance.freelancebackend.entity.ProjectQueue;

public interface ProjectQueueService {

  void addApplicant(Long userId, Long projectId, ProjectQueue projectQueue);
  void rejectApplicant(Long userId, Long projectId);
  void approveApplicant(Long userId, Long projectId);

  
}
