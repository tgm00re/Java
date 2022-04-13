package com.codingdojo.dojosandninjas.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.mvc.models.Dojo;
import com.codingdojo.dojosandninjas.mvc.models.Ninja;
import com.codingdojo.dojosandninjas.mvc.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	public List<Dojo> findAll(){
		return dojoRepo.findAll();
	}
	
	public Dojo findDojoById(Long id) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		return null;
	}
	
//	public List<Ninja> getAllNinjas(Long id){
//		Optional<Dojo> dojo = dojoRepo.findById(id);
//		if(dojo.isPresent()) {
//			Dojo theDojo = dojo.get();
//			return theDojo.getNinjas();
//		}
//		return null;
//	}
	
	public Dojo addNinja(Long id, Ninja ninja) {
		Optional<Dojo> dojo = dojoRepo.findById(id);
		if(dojo.isPresent()) {
			Dojo foundDojo = dojo.get();
			List<Ninja> dojoNinjas = foundDojo.getNinjas();
			dojoNinjas.add(ninja);
			foundDojo.setNinjas(dojoNinjas);
		}
		return null;
	}
	
}
