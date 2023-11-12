package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
    @NotBlank
    @Size(min=1,max=100, message = "Please enter a description 1 to 100 chars long")
    private String description;

    @ManyToMany(mappedBy = "skills")
    private final List<Job> jobs = new ArrayList<>();

    public Skill() {};

    //getter
    public String getDescription(){
        return description;
    }

    //setter
    public void setDescription(String description){
        this.description=description;
    }

    //list all jobs in the array list
    public List<Job> getJobs() {
        return jobs;
    }
}
