package com.freelance.freelancebackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelance.freelancebackend.entity.Project;

@Service("accessService")
public class AccessService {

    @Autowired
    private ProjectService projectService;

    public boolean hasAccessToProject(Long projectId, Long userId) {

        try {
            Project project = projectService.getProject(projectId);
            return project.getUsers().getId() == userId;
        } catch (Exception e) {
            return false;
        }
    }
}
