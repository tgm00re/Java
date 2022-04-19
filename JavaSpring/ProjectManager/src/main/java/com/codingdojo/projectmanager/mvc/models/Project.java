package com.codingdojo.projectmanager.mvc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Title is required")
	private String title;
	
	@NotBlank(message="Description is required")
	@Size(min=3, message="Description must be at least 3 characters")
	private String description;
	
	@NotBlank(message="Due date is required")
	private String dueDate;
	
	
	@ManyToMany
	@JoinTable(
		name="users_projects",
		joinColumns = @JoinColumn(name="project_id"),
		inverseJoinColumns = @JoinColumn(name="user_id")
		)
	private List<User> users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lead_id")
	private User lead;
	
	@OneToMany(mappedBy="project", fetch = FetchType.LAZY)
	private List<Task> tasks;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date created_at;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updated_at;
	
	
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
	
	public Project() {}

	public Project(@NotBlank(message = "Title is required") String title,
			@NotBlank(message = "Description is required") @Size(min = 3, message = "Description must be at least 3 characters") String description,
			@NotBlank(message = "Due date is required") String dueDate, List<User> users, User lead, List<Task> tasks) {
		super();
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.users = users;
		this.lead = lead;
		this.tasks = tasks;
	}

	public Project(Long id, @NotBlank(message = "Title is required") String title,
			@NotBlank(message = "Description is required") @Size(min = 3, message = "Description must be at least 3 characters") String description,
			@NotBlank(message = "Due date is required") String dueDate, List<User> users, User lead, List<Task> tasks) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.users = users;
		this.lead = lead;
		this.tasks = tasks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getLead() {
		return lead;
	}

	public void setLead(User lead) {
		this.lead = lead;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	
	
	
	
	
	
	
	
}
