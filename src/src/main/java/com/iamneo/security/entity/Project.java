package com.iamneo.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="project_access")
public class Project {
    @Id
    
    private int projectid;
    private String username;
    private String requirement;
  
    private int budget;
    private String status;

    public Project() {
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Project(String username,String requirement, int budget, String status) {
		super();
		this.username=username;
		this.requirement = requirement;
		this.budget = budget;
		this.status = status;
	}
   
   
	
    
    
}