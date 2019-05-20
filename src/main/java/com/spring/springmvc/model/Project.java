package com.spring.springmvc.model;

import com.spring.springmvc.listeners.ProjectListener;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@EntityListeners(value = ProjectListener.class)
@Table(name = "projects")
public class Project extends MappedEntity {

    @Column
    private String name;

    @Column
    private Integer balance;

    @Column
    private Integer countDevelopers;
}
