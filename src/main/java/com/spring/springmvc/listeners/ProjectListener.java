package com.spring.springmvc.listeners;

import com.spring.springmvc.model.Project;

import javax.persistence.PrePersist;
import java.util.Random;

public class ProjectListener {
    @PrePersist
    public void prePersist(Project entity) {
        entity.setCountDevelopers(new Random().nextInt(10));
    }
}
