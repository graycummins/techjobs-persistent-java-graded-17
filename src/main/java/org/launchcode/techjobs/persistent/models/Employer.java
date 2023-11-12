package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    //makes sure the location exists
    @NotBlank
    @Size(max=100)
    private String location;

    //joins this employer to the same employer in job
    @OneToMany
    @JoinColumn(name="employer_id")
    private final List<Job> jobs = new ArrayList<>();

    //instance for JPA to use
    public Employer() {};

    //getter
    public String getLocation(){
        return location;
    }

    //setter
    public void setLocation(String location){
        this.location=location;
    }

    //list all jobs in the array list
    public List<Job> getJobs() {
        return jobs;
    }
}
