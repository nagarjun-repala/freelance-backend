package com.freelance.freelancebackend.web;

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

import com.freelance.freelancebackend.entity.ProjectQueue;
import com.freelance.freelancebackend.security.manager.CustomPrincipal;
import com.freelance.freelancebackend.service.ProjectQueueService;

@RestController
@RequestMapping("/user/project")
public class ProjectQueueController {

  @Autowired
  private ProjectQueueService projectQueueService;
  
  @PostMapping("/{projectId}/apply")
  public ResponseEntity<HttpStatus> addApplicant(@PathVariable Long projectId, @AuthenticationPrincipal CustomPrincipal principal, @Valid @RequestBody ProjectQueue projectQueue) {

      projectQueueService.addApplicant(principal.getUserId(), projectId, projectQueue);
      return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping("/{projectId}/deny")
  public ResponseEntity<HttpStatus> rejectApplicant(@PathVariable Long projectId, @AuthenticationPrincipal CustomPrincipal principal) {

      projectQueueService.rejectApplicant(principal.getUserId(), projectId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/{projectId}/approve")
  public ResponseEntity<HttpStatus> approveApplicant(@PathVariable Long projectId, @AuthenticationPrincipal CustomPrincipal principal) {

      projectQueueService.approveApplicant(principal.getUserId(), projectId);
      return new ResponseEntity<>(HttpStatus.OK);
  }
}
