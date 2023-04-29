package com.freelance.freelancebackend.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.freelancebackend.entity.Project;
import com.freelance.freelancebackend.security.manager.CustomPrincipal;
import com.freelance.freelancebackend.service.ProjectService;

@RestController
@RequestMapping("/user/project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @PostMapping("/create")
  public ResponseEntity<HttpStatus> createProject(@AuthenticationPrincipal CustomPrincipal principal, @Valid @RequestBody Project project) {

      projectService.createProject(principal.getUserId(), project);
      return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping("/{projectId}")
  public ResponseEntity<Project> deleteProject(@PathVariable Long projectId) {
      projectService.deleteProject(projectId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);     
  }   

  @GetMapping("/{projectId}")
  public ResponseEntity<Project> getProject(@PathVariable Long projectId) {
      return new ResponseEntity<>(projectService.getProject(projectId), HttpStatus.OK);     
  }   

  @GetMapping("/all")
  public ResponseEntity<List<Project>> getProjects() {
      return new ResponseEntity<>(projectService.getProjects(), HttpStatus.OK);     
  }  
  
}
