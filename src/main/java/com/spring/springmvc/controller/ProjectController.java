package com.spring.springmvc.controller;

import com.spring.springmvc.model.Project;
import com.spring.springmvc.service.ProjectRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ProjectController {
    @Autowired
    private ProjectRepositoryService service;

    @GetMapping("/home")
    public ModelAndView projects() {
        List<Project> projects = service.getAllProject();
        return new ModelAndView("home", "projects", projects);
    }

    @PostMapping("/home")
    public String addProject(Project project) {
        service.createProject(project);
        return "redirect:/home";
    }

    @RequestMapping("/add")
    public ModelAndView createProject() {
        return new ModelAndView("add-project", "project", new Project());
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable(name = "id") Integer id) {
        service.deleteProjectById(id);
        return "redirect:/home";
    }

    @GetMapping("/change/{id}")
    public ModelAndView changeProject(@PathVariable(name = "id") Integer id) {
        return new ModelAndView("update", "project", service.getProjectById(id));
    }
}
