package com.codingdojo.projectmanager.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.projectmanager.mvc.models.Project;
import com.codingdojo.projectmanager.mvc.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepo;
	
	
	//CREATE
	public Project create(Project project) {
		return projectRepo.save(project);
	}
	
	//READ
	public Project findOneById(Long id) {
		Optional<Project> proj = projectRepo.findById(id);
		if(proj.isPresent()) {
			return proj.get();
		}
		return null;
	}
	
	public List<Project> findAll(){
		return projectRepo.findAll();
	}
	
	
	//UPDATE
	public Project update(Project project) {
		return projectRepo.save(project);
	}
	
	
	//DELETE
	public void delete(Long id) {
		projectRepo.deleteById(id);
	}
}
