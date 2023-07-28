package com.iamneo.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="task_access")
public class Task {
    @Id
    @GeneratedValue
    private int Task_id;
    private String projectname;
    private int projectid;
    private String assignedto;
    private String description;
  
  
    public Task() {
    }




	public String getProjectname() {
		return projectname;
	}


	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}


	public int getProjectid() {
		return projectid;
	} 


	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}


	public String getAssignedto() {
		return assignedto;
	}


	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Task(int task_id, String projectname, int projectid, String assignedto, String description) {
		super();
		Task_id = task_id;
		this.projectname = projectname;
		this.projectid = projectid;
		this.assignedto = assignedto;
		this.description = description;
	}
   
    
}