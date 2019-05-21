package com.spring.springmvc.service.impl;

import com.spring.springmvc.model.Project;
import com.spring.springmvc.repository.ProjectRepository;
import com.spring.springmvc.service.ProjectRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectRepositoryServiceImpl implements ProjectRepositoryService {
    private final ProjectRepository repository;

    @Override
    public void createProject(Project project) {
        repository.save(project);
    }

    @Override
    public Project getProjectById(int id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void updateProject(Project project) {
        repository.save(project);
    }

    @Override
    public void deleteProjectById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Project> getAllMoreThanBalance(Integer balance) {
        return repository.findAllMoreThanBalance(balance);
    }

    @Override
    public List<Project> getAllProject() {
        return repository.findAll();
    }
}
