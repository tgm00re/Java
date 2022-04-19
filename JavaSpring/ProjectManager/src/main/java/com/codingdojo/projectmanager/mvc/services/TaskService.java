package com.codingdojo.projectmanager.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.projectmanager.mvc.models.Task;
import com.codingdojo.projectmanager.mvc.repositories.TaskRepository;

@Service
public class TaskService {
	
	
	@Autowired
	private TaskRepository taskRepo;
	
	
	//CREATE
	public Task create(Task task) {
		return taskRepo.save(task);
	}
	
	//READ
	public Task findOneById(Long id) {
		Optional<Task> task = taskRepo.findById(id);
		if(task.isPresent()) {
			return task.get();
		}
		return null;
	}
	
	public List<Task> findAll(){
		return taskRepo.findAll();
	}
	
	
	//UPDATE
	//Not needed for this project.
	
	
	//DELETE
	//Not needed for this project
}
