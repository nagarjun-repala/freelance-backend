package com.freelance.freelancebackend.service;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import com.freelance.freelancebackend.entity.Project;

public interface ProjectService {

  Project createProject(Long userId, Project project);

  @PreAuthorize("hasRole('ADMIN') OR (hasRole('USER') AND @accessService.hasAccessToProject(#projectId, principal.userId))")
  void deleteProject(Long projectId);

  Project updateProject(Project project, Long projectId);

  Project getProject(Long projectId);

  List<Project> getProjects();
  
  
}
