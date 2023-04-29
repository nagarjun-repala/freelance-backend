package com.freelance.freelancebackend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelance.freelancebackend.Constants;
import com.freelance.freelancebackend.entity.Project;
import com.freelance.freelancebackend.entity.User;
import com.freelance.freelancebackend.exception.ResourceNotFoundException;
import com.freelance.freelancebackend.repository.ProjectRepository;
import com.freelance.freelancebackend.repository.UserRepository;

@Service
public class ProjectServiceImpl implements ProjectService{

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private UserRepository userRepository;

  @Override
  public Project createProject(Long userId, Project project) {
    User user = userRepository.findById(userId).get();
    LocalDateTime currentLocalDateTime = LocalDateTime.now();
    project.setUsers(user);
    project.setCreatedOn(currentLocalDateTime);
    project.setStatus(Constants.OPEN);
    return projectRepository.save(project);
  }

  @Override
  public void deleteProject(Long projectId) {
    projectRepository.deleteById(projectId);
  }

  @Override
  public Project updateProject(Project project, Long projectId) {
    // TODO Auto-generated method stub
        Optional<Project> projectEntity = projectRepository.findById(projectId);
        if(projectEntity.isEmpty()) throw new ResourceNotFoundException("project not found");    
        Project updateProject = projectEntity.get();
        updateProject.setId(project.getId());
        updateProject.setUsers(project.getUsers());
        updateProject.setCreatedOn(project.getCreatedOn());
        updateProject.setBudget(project.getBudget());
        updateProject.setDescription(project.getDescription());
        return updateProject;
  }

  @Override
  public Project getProject(Long projectId) {

    Optional<Project> projectEntity = projectRepository.findById(projectId);
    if(projectEntity.isEmpty()) throw new ResourceNotFoundException("project not found");
    return projectEntity.get();    

    }

  @Override
  public List<Project> getProjects() {
    return (List<Project>)projectRepository.findAll();
  }
  
}
