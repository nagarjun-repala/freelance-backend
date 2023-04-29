package com.freelance.freelancebackend.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelance.freelancebackend.Constants;
import com.freelance.freelancebackend.entity.Project;
import com.freelance.freelancebackend.entity.ProjectQueue;
import com.freelance.freelancebackend.entity.User;
import com.freelance.freelancebackend.repository.ProjectQueueRepository;
import com.freelance.freelancebackend.repository.ProjectRepository;
import com.freelance.freelancebackend.repository.UserRepository;

@Service
public class ProjectQueueServiceImpl implements ProjectQueueService {

  @Autowired
  private ProjectQueueRepository projectQueueRepository;

  @Autowired
  private UserService userService;

  @Autowired
  private ProjectService projectService;


  @Override
  public void addApplicant(Long userId, Long projectId, ProjectQueue projectQueue) {
    User user = userService.getUser(userId);
    Project project = projectService.getProject(projectId);
    LocalDateTime currentLocalDateTime = LocalDateTime.now();
    projectQueue.setAppliedOn(currentLocalDateTime);
    projectQueue.setUsers(user);
    projectQueue.setProject(project);
    projectQueue.setStatus(Constants.APPLIED);
    projectQueueRepository.save(projectQueue);
  }

  @Override
  public void rejectApplicant(Long userId, Long projectId) {
    User user = userService.getUser(userId);
    Project project = projectService.getProject(projectId);
    ProjectQueue updateApplicant = projectQueueRepository.findByUsersIdAndProjectId(user.getId(), project.getId()).get();
    updateApplicant.setStatus(Constants.REJECT);
    projectQueueRepository.save(updateApplicant);
  }

  @Override
  public void approveApplicant(Long userId, Long projectId) {
    User user = userService.getUser(userId);
    Project project = projectService.getProject(projectId);
    ProjectQueue updateApplicant = projectQueueRepository.findByUsersIdAndProjectId(user.getId(), project.getId()).get();
    updateApplicant.setStatus(Constants.ACCEPT);
    projectQueueRepository.save(updateApplicant);
  }
  
}
